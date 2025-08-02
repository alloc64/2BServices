package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.KeywordIdeasRequestDto;
import net.twobid.googleads.api.model.KeywordMetricDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsKeywordsApi {
  /**
   * 
   * 
   * @param body  (required)
   * @return Call&lt;List&lt;KeywordMetricDto&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/keywords/historical-metrics")
  Observable<List<KeywordMetricDto>> historicalMetrics(
    @retrofit2.http.Body List<String> body
  );

  /**
   * 
   * 
   * @param body  (required)
   * @return Call&lt;List&lt;KeywordMetricDto&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/keywords/ideas")
  Observable<List<KeywordMetricDto>> keywordIdeas(
    @retrofit2.http.Body KeywordIdeasRequestDto body
  );

}
