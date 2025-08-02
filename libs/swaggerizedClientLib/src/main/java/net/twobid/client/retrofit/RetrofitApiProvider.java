/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.client.retrofit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.twobid.client.retrofit.auth0.ClientCredentialsRequest;
import okhttp3.*;
import org.apache.commons.collections4.map.LRUMap;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;

import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.security.Principal;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class RetrofitApiProvider implements AutoCloseable {
    private final String baseUrl;
    private final Map<String, Object> apiInstances = new LRUMap<>(100);
    private OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    protected RetrofitApiProvider(String baseUrl) {
        this(baseUrl, new OkHttpClient.Builder().build(), new ObjectMapper());
    }

    protected RetrofitApiProvider(String baseUrl,
                                  String resourceServerHost,
                                  String audience,
                                  String clientId,
                                  String clientSecret) {
        this(baseUrl, new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .callTimeout(5, java.util.concurrent.TimeUnit.MINUTES)
                .readTimeout(5, java.util.concurrent.TimeUnit.MINUTES)
                .writeTimeout(5, java.util.concurrent.TimeUnit.MINUTES)
                .addInterceptor(new AccessTokenInterceptor(baseUrl, resourceServerHost, ClientCredentialsRequest.builder()
                        .grantType("client_credentials")
                        .audience(audience)
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .build()))
                .build(), new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule()));
    }

    protected RetrofitApiProvider(String baseUrl, OkHttpClient httpClient, ObjectMapper objectMapper) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    protected <T> T get(Class<T> clazz) {
        return get(clazz, null, request -> request);
    }

    /**
     * Return API instance with X-principal header, to override default principal id derived from access token.
     * @param clazz API interface class
     * @param principal principal id
     */
    protected <T> T get(Class<T> clazz, Principal principal) {
        String principalId = principal.getName();
        return get(clazz, principalId, request -> request.newBuilder()
                .addHeader("X-Principal", principalId)
                .build());
    }

    private <T> T get(Class<T> clazz, String keyPrefix, RequestOverride override) {
        String key = keyPrefix == null ? clazz.toString() : keyPrefix + "_" + clazz;

        T instance = (T) apiInstances.get(key);
        if (instance != null)
            return instance;

        instance = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(new CustomConverter(objectMapper))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .callFactory(request -> httpClient.newCall(override.process(request)))
                .build()
                .create(clazz);

        apiInstances.put(key, instance);
        return instance;
    }

    @Override
    public void close() throws Exception {
        apiInstances.clear();
    }

    public interface RequestOverride {
        Request process(Request builder);
    }

    @RequiredArgsConstructor
    private static class CustomConverter extends Converter.Factory {
        private static final MediaType JSON_MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
        private static final MediaType TEXT_MEDIA_TYPE = MediaType.get("text/plain;charset=UTF-8");
        private final ObjectMapper mapper;
        @Override
        public retrofit2.Converter<ResponseBody, ?> responseBodyConverter(
                @NonNull Type type, Annotation @NonNull [] annotations, @NonNull Retrofit retrofit) {

            return new retrofit2.Converter<>() {
                @Nullable
                @Override
                public Object convert(@NonNull ResponseBody value) throws IOException {
                    String body = value.string();
                    try (value) {
                        if(TEXT_MEDIA_TYPE.equals(value.contentType()))
                            return value.string();

                        ObjectReader reader = mapper.readerFor(
                                mapper.getTypeFactory().constructType(type)
                        );
                        return reader.readValue(body);
                    }
                    catch (Exception e) {
                        throw e;
                    }
                }
            };
        }

        @Override
        public retrofit2.Converter<?, RequestBody> requestBodyConverter(
                @NonNull Type type,
                Annotation @NonNull [] parameterAnnotations,
                Annotation @NonNull [] methodAnnotations,
                @NonNull Retrofit retrofit) {
            return (retrofit2.Converter<Object, RequestBody>) value -> {
                if(value instanceof String)
                    return RequestBody.create(TEXT_MEDIA_TYPE, (String) value);

                ObjectWriter writer = mapper.writerFor(
                        mapper.getTypeFactory().constructType(type)
                );
                return RequestBody.create(JSON_MEDIA_TYPE,
                        writer.writeValueAsBytes(value)
                );
            };
        }
    }
}
