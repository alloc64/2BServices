package net.twobid.core.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.core.api.model.SecureStateAppInfoDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AppSecureStateApi {
  /**
   * 
   * 
   * @param body  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/apps/secure-state/app-info")
  Observable<Void> saveAppInfo(
    @retrofit2.http.Body List<SecureStateAppInfoDto> body
  );

}
