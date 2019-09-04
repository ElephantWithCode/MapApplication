package com.example.team.mapapplication.beaninterface;

import android.database.Observable;

import com.example.team.mapapplication.bean.UserBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IUser {
    @FormUrlEncoded
    @POST("/toPhone/userTest")
    Call<UserBean> verifyUser(@Field("ID")String id, @Field("Password")String password);
}
