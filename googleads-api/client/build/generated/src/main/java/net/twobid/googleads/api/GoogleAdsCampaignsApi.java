package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.AppIdDto;
import net.twobid.googleads.api.model.CampaignDto;
import net.twobid.googleads.api.model.CampaignNameDto;
import net.twobid.googleads.api.model.CampaignReportDto;
import net.twobid.googleads.api.model.CampaignReportRequestDto;
import net.twobid.googleads.api.model.FindAllCampaignsRequestDto;
import java.time.LocalDate;
import net.twobid.googleads.api.model.LocationTargetingDto;
import net.twobid.googleads.api.model.PageTokenPageCampaignDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsCampaignsApi {
  /**
   * 
   * 
   * @param customerId  (required)
   * @param campaignId  (required)
   * @return Call&lt;AppIdDto&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/{campaignId}/appId")
  Observable<AppIdDto> appIdById(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId
  );

  /**
   * Set bid for campaign, bid value. Monetary value, value or percents percents are handled internally. Currency is specified by the account.
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @param campaignId  (required)
   * @return Call&lt;CampaignDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/{campaignId}/bid")
  Observable<CampaignDto> bid(
    @retrofit2.http.Body Double body, @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId
  );

  /**
   * Set budget for campaign, budget value is in micros eg. (1$ * 1_000_000L) &#x3D; your budget value. Currency is specified by the account.
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @param campaignId  (required)
   * @return Call&lt;CampaignDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/{campaignId}/budget")
  Observable<CampaignDto> budget(
    @retrofit2.http.Body Long body, @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @param pageSize  (optional)
   * @param pageToken  (optional)
   * @return Call&lt;PageTokenPageCampaignDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}")
  Observable<PageTokenPageCampaignDto> findAll(
    @retrofit2.http.Body FindAllCampaignsRequestDto body, @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Query("pageSize") Integer pageSize, @retrofit2.http.Query("pageToken") String pageToken
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @param appId  (required)
   * @return Call&lt;List&lt;CampaignDto&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/{appId}/by-location")
  Observable<List<CampaignDto>> findAllTargetingLocation(
    @retrofit2.http.Body LocationTargetingDto body, @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("appId") String appId
  );

  /**
   * 
   * 
   * @param customerId  (required)
   * @param campaignId  (required)
   * @return Call&lt;CampaignDto&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/{campaignId}")
  Observable<CampaignDto> findById(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId
  );

  /**
   * 
   * 
   * @param customerId  (required)
   * @param campaignId  (required)
   * @return Call&lt;CampaignNameDto&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/{campaignId}/name")
  Observable<CampaignNameDto> nameById(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @return Call&lt;List&lt;CampaignReportDto&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/report")
  Observable<List<CampaignReportDto>> report(
    @retrofit2.http.Body CampaignReportRequestDto body, @retrofit2.http.Path("customerId") Long customerId
  );

  /**
   * 
   * 
   * @param customerId  (required)
   * @param campaignId  (required)
   * @param startDate  (required)
   * @param endDate  (required)
   * @return Call&lt;CampaignReportDto&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/{campaignId}/report")
  Observable<CampaignReportDto> reportById(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId, @retrofit2.http.Query("startDate") LocalDate startDate, @retrofit2.http.Query("endDate") LocalDate endDate
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @return Call&lt;CampaignDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/save")
  Observable<CampaignDto> save(
    @retrofit2.http.Body CampaignDto body, @retrofit2.http.Path("customerId") Long customerId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @param campaignId  (required)
   * @return Call&lt;CampaignDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/{campaignId}/status")
  Observable<CampaignDto> status(
    @retrofit2.http.Body String body, @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @param campaignId  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/{campaignId}/targeting")
  Observable<Void> targeting(
    @retrofit2.http.Body LocationTargetingDto body, @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId
  );

}
