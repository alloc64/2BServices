package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.CampaignAdAssetsPerformanceDto;
import net.twobid.googleads.api.model.CampaignsAdAssetsPerformanceRequestDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsCampaignsAdAssetsApi {
  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @return Call&lt;Map&lt;String, CampaignAdAssetsPerformanceDto&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/ad-assets/performance-report")
  Observable<Map<String, CampaignAdAssetsPerformanceDto>> performanceReport(
    @retrofit2.http.Body CampaignsAdAssetsPerformanceRequestDto body, @retrofit2.http.Path("customerId") Long customerId
  );

}
