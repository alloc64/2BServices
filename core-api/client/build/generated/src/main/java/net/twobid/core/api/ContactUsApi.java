package net.twobid.core.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.core.api.model.ContactUsRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ContactUsApi {
  /**
   * 
   * 
   * @param body  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/contact/send")
  Observable<Void> send(
    @retrofit2.http.Body ContactUsRequest body
  );

}
