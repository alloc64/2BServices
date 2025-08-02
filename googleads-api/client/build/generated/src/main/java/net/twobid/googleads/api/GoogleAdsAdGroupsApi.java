package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.AdGroupDto;
import net.twobid.googleads.api.model.AdGroupNameDto;
import net.twobid.googleads.api.model.PageTokenPageAdGroupDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsAdGroupsApi {
  /**
   * 
   * 
   * @param customerId  (required)
   * @param campaignId  (required)
   * @param pageSize  (optional)
   * @param pageToken  (optional)
   * @return Call&lt;PageTokenPageAdGroupDto&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/{campaignId}/adgroups")
  Observable<PageTokenPageAdGroupDto> findAll(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId, @retrofit2.http.Query("pageSize") Integer pageSize, @retrofit2.http.Query("pageToken") String pageToken
  );

  /**
   * 
   * 
   * @param customerId  (required)
   * @param campaignId  (required)
   * @param adGroupId  (required)
   * @return Call&lt;AdGroupDto&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/{campaignId}/adgroups/{adGroupId}")
  Observable<AdGroupDto> findById(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId, @retrofit2.http.Path("adGroupId") Long adGroupId
  );

  /**
   * 
   * 
   * @param customerId  (required)
   * @param campaignId  (required)
   * @param adGroupId  (required)
   * @return Call&lt;AdGroupNameDto&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/{campaignId}/adgroups/{adGroupId}/name")
  Observable<AdGroupNameDto> nameById(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId, @retrofit2.http.Path("adGroupId") Long adGroupId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @param campaignId  (required)
   * @return Call&lt;AdGroupDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/{campaignId}/adgroups")
  Observable<AdGroupDto> save(
    @retrofit2.http.Body AdGroupDto body, @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @param campaignId  (required)
   * @param adGroupId  (required)
   * @return Call&lt;AdGroupDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/{campaignId}/adgroups/{adGroupId}/status")
  Observable<AdGroupDto> status(
    @retrofit2.http.Body String body, @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId, @retrofit2.http.Path("adGroupId") Long adGroupId
  );

}
