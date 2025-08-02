/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.client.retrofit;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.rxjava3.annotations.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.twobid.client.retrofit.auth0.AccessTokenResponse;
import net.twobid.client.retrofit.auth0.ClientCredentialsRequest;
import okhttp3.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;

@Slf4j
public class AccessTokenInterceptor implements Interceptor {
    private static final int MAX_RETRIES = 5;
    private static final long RETRY_TIMEOUT = 120 * 1000;
    private static final File SECRETS_FOLDER = new File("./.secrets");

    private final String baseUrl;
    private final String resourceServerHost;
    private final ClientCredentialsRequest credentialsRequest;
    private final OkHttpClient tokenClient = new OkHttpClient.Builder().build();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private AccessTokenResponse accessToken;
    private int retryCount = 0;
    private long lastRetryTime = -1;

    public AccessTokenInterceptor(String baseUrl,
                                  String resourceServerHost,
                                  ClientCredentialsRequest credentialsRequest) {
        this.baseUrl = baseUrl;
        this.resourceServerHost = resourceServerHost;
        this.credentialsRequest = credentialsRequest;
        this.accessToken = loadPersistedToken();
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();

        if (accessToken == null || accessToken.isExpired())
            return chain.proceed(requestNewAccessToken(request));

        Response response = chain.proceed(injectAccessToken(chain.request()));

        if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            response.close();
            return chain.proceed(requestNewAccessToken(request));
        }

        return response;
    }

    private @NonNull Request requestNewAccessToken(Request request) throws IOException {
        if (retryCount >= MAX_RETRIES && System.currentTimeMillis() - lastRetryTime < RETRY_TIMEOUT) {
            log.error("Failed to get access M2M token and retry count exceeded.");
            return request;
        }

        try {
            try (Response response = tokenClient.newCall(new Request.Builder()
                            .url(resourceServerHost + "oauth/token")
                            .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                                    objectMapper.writeValueAsString(credentialsRequest)))
                            .build())
                    .execute()) {
                if (response.isSuccessful()) {
                    this.accessToken = objectMapper.readValue(response.body().string(), AccessTokenResponse.class);
                    this.retryCount = 0;
                    this.lastRetryTime = -1;
                    accessToken.setExpiresInTimestamp(System.currentTimeMillis() + accessToken.getExpiresIn() * 1000);

                    persistToken(accessToken);
                    return injectAccessToken(request);
                }
            }

            retryCount++;
            lastRetryTime = System.currentTimeMillis();
        } catch (Exception e) {
            log.error("Failed to get access M2M token", e);
            throw e;
        }

        return request;
    }

    private AccessTokenResponse loadPersistedToken() {
        try {
            AccessTokenResponse accessToken = objectMapper.readValue(getTokenFile(), AccessTokenResponse.class);

            if (accessToken != null && !accessToken.isExpired())
                return accessToken;
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            log.error("Failed to load persisted access token", e);
        }

        return null;
    }

    private void persistToken(AccessTokenResponse accessToken) {
        if (!SECRETS_FOLDER.exists())
            SECRETS_FOLDER.mkdirs();

        try {
            objectMapper.writeValue(getTokenFile(), accessToken);
        } catch (IOException e) {
            log.error("Failed to persist access token", e);
        }
    }

    private File getTokenFile() {
        URI host = URI.create(baseUrl);
        String filename = host.getHost() + "_" + host.getPort() + "_access_token.json";
        return new File(SECRETS_FOLDER, filename);
    }

    @NonNull
    private Request injectAccessToken(@NonNull Request request) {
        return request.newBuilder()
                .header("Authorization", "Bearer " + accessToken.getAccessToken())
                .build();
    }
}
