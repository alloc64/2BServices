package net.twobid.core.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.core.api.model.AppPersonalizationProfileEntity;
import net.twobid.core.api.model.PageAppPersonalizationProfileEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AppPersonalizationProfilesApi {
  /**
   * 
   * 
   * @param packageName  (required)
   * @param id  (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("core/v1/personalization/profiles/{packageName}/{id}")
  Observable<Void> deleteById(
    @retrofit2.http.Path("packageName") String packageName, @retrofit2.http.Path("id") Long id
  );

  /**
   * 
   * 
   * @param packageName  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return Call&lt;PageAppPersonalizationProfileEntity&gt;
   */
  @GET("core/v1/personalization/profiles/{packageName}")
  Observable<PageAppPersonalizationProfileEntity> findAll(
    @retrofit2.http.Path("packageName") String packageName, @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("size") Integer size, @retrofit2.http.Query("sort") List<String> sort
  );

  /**
   * 
   * 
   * @param packageName  (required)
   * @param id  (required)
   * @return Call&lt;AppPersonalizationProfileEntity&gt;
   */
  @GET("core/v1/personalization/profiles/{packageName}/{id}")
  Observable<AppPersonalizationProfileEntity> findById(
    @retrofit2.http.Path("packageName") String packageName, @retrofit2.http.Path("id") Long id
  );

  /**
   * 
   * 
   * @param packageName  (required)
   * @param id  (required)
   * @return Call&lt;AppPersonalizationProfileEntity&gt;
   */
  @POST("core/v1/personalization/profiles/{packageName}/{id}/default")
  Observable<AppPersonalizationProfileEntity> markDefault(
    @retrofit2.http.Path("packageName") String packageName, @retrofit2.http.Path("id") Long id
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param packageName  (required)
   * @return Call&lt;AppPersonalizationProfileEntity&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/personalization/profiles/{packageName}")
  Observable<AppPersonalizationProfileEntity> save(
    @retrofit2.http.Body AppPersonalizationProfileEntity body, @retrofit2.http.Path("packageName") String packageName
  );

}
