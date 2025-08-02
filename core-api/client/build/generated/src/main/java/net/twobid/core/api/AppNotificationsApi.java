package net.twobid.core.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.core.api.model.AppNotificationTokenEntity;
import net.twobid.core.api.model.NotificationConfigDto;
import net.twobid.core.api.model.PageAppNotificationTokenEntity;
import net.twobid.core.api.model.RegisterNotificationTokenRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AppNotificationsApi {
  /**
   * 
   * 
   * @param bundleId  (required)
   * @return Call&lt;NotificationConfigDto&gt;
   */
  @GET("core/v1/apps/{bundleId}/notifications/config")
  Observable<NotificationConfigDto> config(
    @retrofit2.http.Path("bundleId") String bundleId
  );

  /**
   * 
   * 
   * @return Call&lt;Void&gt;
   */
  @DELETE("core/v1/apps/{bundleId}/notifications/batch")
  Observable<Void> deleteBatch();
    

  /**
   * 
   * 
   * @param id  (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("core/v1/apps/{bundleId}/notifications/{id}")
  Observable<Void> deleteById(
    @retrofit2.http.Path("id") Long id
  );

  /**
   * 
   * 
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return Call&lt;PageAppNotificationTokenEntity&gt;
   */
  @GET("core/v1/apps/{bundleId}/notifications")
  Observable<PageAppNotificationTokenEntity> findAll(
    @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("size") Integer size, @retrofit2.http.Query("sort") List<String> sort
  );

  /**
   * 
   * 
   * @param id  (required)
   * @return Call&lt;AppNotificationTokenEntity&gt;
   */
  @GET("core/v1/apps/{bundleId}/notifications/{id}")
  Observable<AppNotificationTokenEntity> findById(
    @retrofit2.http.Path("id") Long id
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param bundleId  (required)
   * @param twobidId  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/apps/{bundleId}/notifications/token")
  Observable<Void> registerToken(
    @retrofit2.http.Body RegisterNotificationTokenRequest body, @retrofit2.http.Path("bundleId") String bundleId, @retrofit2.http.Header("twobid-id") String twobidId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @return Call&lt;AppNotificationTokenEntity&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/apps/{bundleId}/notifications")
  Observable<AppNotificationTokenEntity> save(
    @retrofit2.http.Body AppNotificationTokenEntity body
  );

  /**
   * 
   * 
   * @param body  (required)
   * @return Call&lt;Object&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/apps/{bundleId}/notifications/batch")
  Observable<Object> saveBatch(
    @retrofit2.http.Body List<AppNotificationTokenEntity> body
  );

}
