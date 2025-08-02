package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.LoginRedirectDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsAuthApi {
  /**
   * 
   * 
   * @param state  (required)
   * @param code  (required)
   * @return Call&lt;Void&gt;
   */
  @GET("googleads-api/v1/auth")
  Observable<Void> authenticate(
    @retrofit2.http.Query("state") String state, @retrofit2.http.Query("code") String code
  );

  /**
   * 
   * 
   * @param redirectUrl  (required)
   * @return Call&lt;LoginRedirectDto&gt;
   */
  @GET("googleads-api/v1/login-redirect")
  Observable<LoginRedirectDto> loginRedirect(
    @retrofit2.http.Query("redirectUrl") String redirectUrl
  );

}
