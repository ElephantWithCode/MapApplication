package com.example.team.mapapplication.beaninterface;

import com.example.team.mapapplication.bean.WeatherBean;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/***
 * TODO: Test Only
 */
public interface IWeather {
    @GET("/v3/weather/now.json")
    Observable<WeatherBean> weather(@Query("key")String key, @Query("location")String location);

}
