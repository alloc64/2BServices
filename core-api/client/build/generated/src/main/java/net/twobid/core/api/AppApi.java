package net.twobid.core.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.core.api.model.AppEntity;
import net.twobid.core.api.model.PageAppEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AppApi {
  /**
   * 
   * 
   * @return Call&lt;Void&gt;
   */
  @DELETE("core/v1/apps/batch")
  Observable<Void> deleteBatch();
    

  /**
   * 
   * 
   * @param id  (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("core/v1/apps/{id}")
  Observable<Void> deleteById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * 
   * 
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return Call&lt;PageAppEntity&gt;
   */
  @GET("core/v1/apps")
  Observable<PageAppEntity> findAll(
    @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("size") Integer size, @retrofit2.http.Query("sort") List<String> sort
  );

  /**
   * 
   * 
   * @param bundleIds  (required)
   * @return Call&lt;List&lt;AppEntity&gt;&gt;
   */
  @GET("core/v1/apps/batch")
  Observable<List<AppEntity>> findAllByBundleId(
    @retrofit2.http.Query("bundleIds") List<String> bundleIds
  );

  /**
   * 
   * 
   * @param appToken  (required)
   * @return Call&lt;AppEntity&gt;
   */
  @GET("core/v1/apps/by/app-token/{appToken}")
  Observable<AppEntity> findByAppToken(
    @retrofit2.http.Path("appToken") String appToken
  );

  /**
   * 
   * 
   * @param id  (required)
   * @return Call&lt;AppEntity&gt;
   */
  @GET("core/v1/apps/{id}")
  Observable<AppEntity> findById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * 
   * 
   * @param publishToken  (required)
   * @return Call&lt;AppEntity&gt;
   */
  @GET("core/v1/apps/by/publish-token/{publishToken}")
  Observable<AppEntity> findByPublishToken(
    @retrofit2.http.Path("publishToken") String publishToken
  );

  /**
   * 
   * 
   * @param body  (required)
   * @return Call&lt;AppEntity&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/apps")
  Observable<AppEntity> save(
    @retrofit2.http.Body AppEntity body
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
  @POST("core/v1/apps/batch")
  Observable<Object> saveBatch(
    @retrofit2.http.Body List<AppEntity> body
  );

}
