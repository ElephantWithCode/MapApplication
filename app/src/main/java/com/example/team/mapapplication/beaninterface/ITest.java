package com.example.team.mapapplication.beaninterface;

import com.example.team.mapapplication.bean.TestBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

// 192.168.1.100:8080/TEST
public interface ITest {
//    @FormUrlEncoded
//    @POST("/Test")
//    Call<TestBean> test(@Query("key")String key, @Query("value")String test);
//    Observable<TestBean> test(@Field("test")String value);
    @GET("/Test")
    Observable<TestBean> test();
}
