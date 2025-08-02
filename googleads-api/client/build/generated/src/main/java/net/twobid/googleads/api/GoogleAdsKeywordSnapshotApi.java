package net.twobid.googleads.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.googleads.api.model.KeywordSnapshotUrlDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoogleAdsKeywordSnapshotApi {
  /**
   * 
   * 
   * @param bundleId  (required)
   * @param accessKey  (required)
   * @return Call&lt;String&gt;
   */
  @GET("googleads-api/v1/keywords/snapshot/{bundleId}/{accessKey}")
  Observable<String> keywordSnapshotOfApp(
    @retrofit2.http.Path("bundleId") String bundleId, @retrofit2.http.Path("accessKey") String accessKey
  );

  /**
   * 
   * 
   * @param bundleId  (required)
   * @return Call&lt;KeywordSnapshotUrlDto&gt;
   */
  @GET("googleads-api/v1/keywords/snapshot/{bundleId}/url")
  Observable<KeywordSnapshotUrlDto> keywordSnapshotUrl(
    @retrofit2.http.Path("bundleId") String bundleId
  );

}
