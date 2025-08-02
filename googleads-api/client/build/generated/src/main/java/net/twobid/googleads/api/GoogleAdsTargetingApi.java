package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.GeoTargetConstantDto;
import net.twobid.googleads.api.model.SuggestGeoTargetConstantsRequestDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsTargetingApi {
  /**
   * 
   * 
   * @param body  (required)
   * @param customerId  (required)
   * @return Call&lt;List&lt;GeoTargetConstantDto&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("googleads-api/v1/campaigns/{customerId}/targeting/suggest")
  Observable<List<GeoTargetConstantDto>> suggest(
    @retrofit2.http.Body SuggestGeoTargetConstantsRequestDto body, @retrofit2.http.Path("customerId") Long customerId
  );

}
