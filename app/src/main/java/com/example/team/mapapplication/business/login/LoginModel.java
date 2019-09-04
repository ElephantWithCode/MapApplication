package com.example.team.mapapplication.business.login;

import android.content.Context;

import com.example.team.mapapplication.base.BaseModel;
import com.example.team.mapapplication.bean.UserBean;
import com.example.team.mapapplication.beaninterface.IUser;
import com.example.team.mapapplication.engine.RetrofitFactory;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginModel extends BaseModel {
    public static long userId = -1;
    public String mClassName = LoginConstants.ACTIVITY_CLASS_NAMES[0];


    //TODO:
    //未完成
    public int verifyUser(UserBean user){
        int verifyingState = 0; // 待加上检验逻辑

        Retrofit retrofit = RetrofitFactory.create("http://192.168.1.100:8080");
        IUser iUser = retrofit.create(IUser.class);
        Call<UserBean> callback = iUser.verifyUser(user.getUserName(), user.getPassword());
        try {
            Response<UserBean> callbackState = callback.execute();
            verifyingState = callbackState.body().getIsOk().length() < 3 ? 1 : 0;
            // 返回值为 OK 或者 FALSE
            // < 3 的话为 OK 即赋值 1. 否则 0
        } catch (IOException e) {
            e.printStackTrace();
        }
//        userId = -1;
        return verifyingState;
    }

    /***
     * 判断用户输入格式
     * @param user 用户信息bean
     * @return 若有某一项未输入，则为真
     */
    public boolean judgeUserFormat(UserBean user) {
        return user.getUserName().isEmpty() || user.getPassword().isEmpty();
    }

    public void saveUserInfo(Context mContext) {

    }

    public Class getTargetActivityClass() {
        if (mClassName != null){
            try {
                return Class.forName(mClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setTargetClassName(String className) {
        mClassName = className;
    }
}
