package net.twobid.core.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.core.api.model.ConfigurableServiceEntity;
import net.twobid.core.api.model.PageConfigurableServiceEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ConfigurableServiceApi {
  /**
   * 
   * 
   * @return Call&lt;Void&gt;
   */
  @DELETE("core/v1/services/batch")
  Observable<Void> deleteBatch();
    

  /**
   * 
   * 
   * @param id  (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("core/v1/services/{id}")
  Observable<Void> deleteById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * 
   * 
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return Call&lt;PageConfigurableServiceEntity&gt;
   */
  @GET("core/v1/services")
  Observable<PageConfigurableServiceEntity> findAll(
    @retrofit2.http.Query("page") Integer page, @retrofit2.http.Query("size") Integer size, @retrofit2.http.Query("sort") List<String> sort
  );

  /**
   * 
   * 
   * @param id  (required)
   * @return Call&lt;ConfigurableServiceEntity&gt;
   */
  @GET("core/v1/services/{id}")
  Observable<ConfigurableServiceEntity> findById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * 
   * 
   * @param body  (required)
   * @return Call&lt;ConfigurableServiceEntity&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/services")
  Observable<ConfigurableServiceEntity> save(
    @retrofit2.http.Body ConfigurableServiceEntity body
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
  @POST("core/v1/services/batch")
  Observable<Object> saveBatch(
    @retrofit2.http.Body List<ConfigurableServiceEntity> body
  );

}
