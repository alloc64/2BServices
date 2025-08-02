package net.twobid.core.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.core.api.model.AppUpdateEntity;
import net.twobid.core.api.model.PageAppUpdateEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AppUpdateApi {
  /**
   * 
   * 
   * @param bundleId  (required)
   * @param hash  (required)
   * @return Call&lt;Void&gt;
   */
  @GET("core/v1/apps/{bundleId}/update/challenge/{hash}")
  Observable<Void> challenge(
    @retrofit2.http.Path("bundleId") String bundleId, @retrofit2.http.Path("hash") String hash
  );

  /**
   * 
   * 
   * @param bundleId  (required)
   * @param id  (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("core/v1/apps/{bundleId}/update/{id}")
  Observable<Void> deleteById(
    @retrofit2.http.Path("bundleId") String bundleId, @retrofit2.http.Path("id") Long id
  );

  /**
   * 
   * 
   * @param bundleId  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return Call&lt;PageAppUpdateEntity&gt;
   */
  @GET("core/v1/apps/{bundleId}/update")
  Observable<PageAppUpdateEntity> findAll(
    @retrofit2.http.Path("bundleId") String bundleId, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("size") Integer size, @retrofit2.http.Query("sort") List<String> sort
  );

  /**
   * 
   * 
   * @param bundleId  (required)
   * @param id  (required)
   * @return Call&lt;AppUpdateEntity&gt;
   */
  @GET("core/v1/apps/{bundleId}/update/{id}")
  Observable<AppUpdateEntity> findById(
    @retrofit2.http.Path("bundleId") String bundleId, @retrofit2.http.Path("id") Long id
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param bundleId  (required)
   * @return Call&lt;AppUpdateEntity&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/apps/{bundleId}/update")
  Observable<AppUpdateEntity> save(
    @retrofit2.http.Body AppUpdateEntity body, @retrofit2.http.Path("bundleId") String bundleId
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param bundleId  (required)
   * @param id  (required)
   * @return Call&lt;AppUpdateEntity&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/apps/{bundleId}/update/{id}/enable")
  Observable<AppUpdateEntity> setEnabled(
    @retrofit2.http.Body Boolean body, @retrofit2.http.Path("bundleId") String bundleId, @retrofit2.http.Path("id") Long id
  );

  /**
   * 
   * 
   * @param bundleId  (required)
   * @param version  (required)
   * @return Call&lt;byte[]&gt;
   */
  @POST("core/v1/apps/{bundleId}/update/upload/{version}")
  Observable<byte[]> upload(
    @retrofit2.http.Path("bundleId") String bundleId, @retrofit2.http.Path("version") Long version
  );

}
