package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.AccountInfoDto;
import net.twobid.googleads.api.model.UserAccountInfoDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsAccountApi {
  /**
   * 
   * 
   * @param customerId  (required)
   * @return Call&lt;AccountInfoDto&gt;
   */
  @GET("googleads-api/v1/account/{customerId}/balance")
  Observable<AccountInfoDto> accountBalance(
    @retrofit2.http.Path("customerId") Long customerId
  );

  /**
   * 
   * 
   * @return Call&lt;UserAccountInfoDto&gt;
   */
  @GET("googleads-api/v1/account")
  Observable<UserAccountInfoDto> findAll();
    

  /**
   * 
   * 
   * @return Call&lt;Long&gt;
   */
  @GET("googleads-api/v1/account/default")
  Observable<Long> findDefault();
    

  /**
   * 
   * 
   * @param customerId  (required)
   * @return Call&lt;UserAccountInfoDto&gt;
   */
  @POST("googleads-api/v1/account/{customerId}/default")
  Observable<UserAccountInfoDto> markDefault(
    @retrofit2.http.Path("customerId") Long customerId
  );

}
