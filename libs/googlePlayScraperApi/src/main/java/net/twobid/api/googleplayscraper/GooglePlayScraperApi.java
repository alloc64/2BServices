/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.api.googleplayscraper;

import io.reactivex.rxjava3.core.Observable;
import lombok.RequiredArgsConstructor;
import net.twobid.api.googleplayscraper.model.AppDetail;
import net.twobid.api.googleplayscraper.model.AppList;
import net.twobid.api.googleplayscraper.model.DeveloperDetail;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.*;

import java.io.IOException;
import java.util.NoSuchElementException;

public class GooglePlayScraperApi {
    private final Schema api;
    private final OkHttpClient httpClient;

    public GooglePlayScraperApi(String apiUrl, OkHttpClient.Builder httpClient) {
        this.httpClient = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        this.api = retrofit.create(Schema.class);
    }

    public Observable<AppDetail> appDetail(String bundleId){
        return Observable.fromCallable(() -> {
            try (Response response = httpClient.newCall(new Request.Builder()
                            .url("https://play.google.com/store/apps/details?id=" + bundleId)
                            .build())
                    .execute()) {
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();

                    if (body == null)
                        throw new IOException("Response body is null");

                    String bodyString = body.string();
                    return appDetailProxy(bundleId, bodyString).blockingSingle();
                }

                if(response.code() == 404)
                    throw new NoSuchElementException();

                throw new IllegalStateException("Unexpected response " + response);
            }
        });
    }

    public Observable<AppDetail> appDetailProxy(String bundleId, String html) {
        return api.appDetailProxy(bundleId, html);
    }

    /**
     * Returns a list of apps matching the query
     * Important: this request is not proxied, because daemon providing the response does not support it
     */
    public Observable<AppList> appList(String query) {
        return api.appList(query);
    }

    /**
     * Returns developer details
     * Important: this request is not proxied, because daemon providing the response does not support it
     */
    public Observable<DeveloperDetail> developer(String developerId) {
        return api.developer(developerId);
    }

    @Component
    @RequiredArgsConstructor
    static class DefaultInstance {
        @Bean
        @ConditionalOnMissingBean
        public GooglePlayScraperApi googlePlayScraperApiDefault(
                @Value("${net.twobid.host.google-play-scraper-api:http://localhost:3000}") String apiUrl
        ) {
            return new GooglePlayScraperApi(apiUrl, new OkHttpClient.Builder().addInterceptor(chain -> {
                Request originalRequest = chain.request();
                Request compressedRequest = originalRequest.newBuilder()
                        .header("accept", "application/json, text/plain, */*")
                        .header("dnt", "1")
                        .header("sec-ch-ua", "\"Google Chrome\";v=\"117\", \"Not;A=Brand\";v=\"8\", \"Chromium\";v=\"117\"")
                        .header("sec-ch-ua-mobile", "?0")
                        .header("sec-ch-ua-platform", "\"macOS\"")
                        .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36")
                        .header("sec-fetch-site", "same-origin")
                        .header("sec-fetch-mode", "cors")
                        .header("sec-fetch-dest", "empty")
                        .header("accept-language", "en-US,en;q=0.9")
                        .build();
                return chain.proceed(compressedRequest);
            }));
        }
    }

    interface Schema {
        @POST("/api/detail/{bundleId}")
        Observable<AppDetail> appDetailProxy(@Path("bundleId") String bundleId, @Body String html);

        @GET("/api/apps")
        Observable<AppList> appList(@Query("q") String query);

        @GET("/api/developers/{developerId}")
        Observable<DeveloperDetail> developer(@Path("developerId") String developerId);
    }
}
