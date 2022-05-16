package com.strawnetwork.weatherlocus.retrofit;

import com.strawnetwork.weatherlocus.models.MainListData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("forecast?units=metric&")
    Call<MainListData> getWeatherData(@Query("q") String cityname,@Query("appid")String appid);

}
