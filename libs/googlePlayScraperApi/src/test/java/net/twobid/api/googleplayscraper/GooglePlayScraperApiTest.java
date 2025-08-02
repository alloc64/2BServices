package net.twobid.api.googleplayscraper;

import net.twobid.api.googleplayscraper.model.AppDetail;
import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

public class GooglePlayScraperApiTest {
    @Test
    void test() throws Exception {
        GooglePlayScraperApi api = new GooglePlayScraperApi.DefaultInstance().googlePlayScraperApiDefault("http://localhost:3000");

        AppDetail result = api.appDetail("com.storytaco.c5client")
                .blockingSingle();

        System.currentTimeMillis();
    }

    @Test
    void testStaticHtml() throws Exception {
        OkHttpClient client = new OkHttpClient.Builder().build();

        String html = IOUtils.toString(new ClassPathResource("gp.html").getInputStream());

        Response response = client.newCall(new Request.Builder()
                        .method("POST", RequestBody.create(MediaType.get("text/html"), html))
                        .url("http://localhost:3000/api/detail/DHQ.FileManagerForAndroid")
                        .build())
                .execute();

        String body = response.body().string();

        System.currentTimeMillis();

    }
}
