package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.ConversionActionDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsConversionActionsApi {
  /**
   * 
   * 
   * @param customerId  (required)
   * @param conversionActionId  (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("googleads-api/v1/campaigns/{customerId}/conversion-actions/{conversionActionId}")
  Observable<Void> deleteCustomConversionAction(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("conversionActionId") Long conversionActionId
  );

  /**
   * 
   * 
   * @param customerId  (required)
   * @param appId  (required)
   * @return Call&lt;List&lt;ConversionActionDto&gt;&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/conversion-actions/app/{appId}")
  Observable<List<ConversionActionDto>> findAll(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("appId") String appId
  );

  /**
   * 
   * 
   * @param customerId  (required)
   * @param conversionActionId  (required)
   * @return Call&lt;ConversionActionDto&gt;
   */
  @GET("googleads-api/v1/campaigns/{customerId}/conversion-actions/{conversionActionId}")
  Observable<ConversionActionDto> findById(
    @retrofit2.http.Path("customerId") Long customerId, @retrofit2.http.Path("conversionActionId") Long conversionActionId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @return Call&lt;ConversionActionDto&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/conversion-actions/save")
  Observable<ConversionActionDto> save(
    @retrofit2.http.Body ConversionActionDto body, @retrofit2.http.Path("customerId") Long customerId
  );

}
