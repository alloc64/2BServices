package net.twobid.core.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.twobid.core.api.model.FindCurrencyRatesByDatesRequest;
import net.twobid.core.api.model.FindCurrencyRatesByDatesResponse;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CurrencyRateApi {
  /**
   * 
   * 
   * @param date  (required)
   * @param currency  (required)
   * @return Call&lt;Double&gt;
   */
  @GET("core/v1/currencyrate/{date}/{currency}")
  Observable<Double> findByDate(
    @retrofit2.http.Path("date") LocalDate date, @retrofit2.http.Path("currency") String currency
  );

  /**
   * 
   * 
   * @param body  (required)
   * @param currency  (required)
   * @return Call&lt;FindCurrencyRatesByDatesResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("core/v1/currencyrate/{currency}")
  Observable<FindCurrencyRatesByDatesResponse> findByDates(
    @retrofit2.http.Body FindCurrencyRatesByDatesRequest body, @retrofit2.http.Path("currency") String currency
  );

}
