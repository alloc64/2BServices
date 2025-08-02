package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.AdGroupAdDtoObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsAdGroupsAdsApi {
  /**
   * 
   * 
   * @param customerId  (required)
   * @param campaignId  (required)
   * @param adGroupId  (required)
   * @return Call&lt;AdGroupAdDtoObject&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/{campaignId}/adgroups/{adGroupId}/ads")
  Observable<AdGroupAdDtoObject> findSingle(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("campaignId") Long campaignId, @retrofit2.http.Path("adGroupId") Long adGroupId
  );

}
