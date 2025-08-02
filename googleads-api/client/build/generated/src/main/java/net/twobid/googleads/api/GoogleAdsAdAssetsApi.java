package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.AdAssetListDto;
import net.twobid.googleads.api.model.AdAssetSaveRequest;
import net.twobid.googleads.api.model.AdAssetsByAppDto;
import net.twobid.googleads.api.model.AdGroupAppAdsByAppRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsAdAssetsApi {
  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @return Call&lt;AdAssetsByAppDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/assets")
  Observable<AdAssetsByAppDto> findAll(
    @retrofit2.http.Body AdGroupAppAdsByAppRequest body, @retrofit2.http.Path("customerId") Long customerId
  );

  /**
   * 
   * 
   * @param customerId  (required)
   * @param adGroupId  (required)
   * @return Call&lt;AdAssetListDto&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/assets/{adGroupId}")
  Observable<AdAssetListDto> findAllByAdGroupId(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("adGroupId") Long adGroupId
  );

  /**
   * 
   * 
   * @param customerId  (required)
   * @param appId  (required)
   * @return Call&lt;List&lt;String&gt;&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/assets/video/{appId}")
  Observable<List<String>> findAllVideoAssetsByAppId(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("appId") String appId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @param adGroupId  (required)
   * @return Call&lt;AdAssetListDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/assets/{adGroupId}/save")
  Observable<AdAssetListDto> save(
    @retrofit2.http.Body AdAssetSaveRequest body, @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("adGroupId") Long adGroupId
  );

}
