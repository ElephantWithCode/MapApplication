package com.example.team.mapapplication.business.login;

import android.content.Context;

import com.example.team.mapapplication.base.BaseModel;
import com.example.team.mapapplication.bean.UserBean;

public class LoginModel extends BaseModel {
    public static long userId = -1;

    //TODO:
    //未完成
    public int verifyUser(UserBean user){
        int verifyingState = 0; // 待加上检验逻辑
//        userId = -1;
        return verifyingState;
    }

    public boolean judgeUserFormat(UserBean user) {

        return false;
    }

    public void saveUserInfo(Context mContext) {

    }
}
