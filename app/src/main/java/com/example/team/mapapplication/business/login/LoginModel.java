package com.example.team.mapapplication.business.login;

import android.content.Context;

import com.example.team.mapapplication.base.BaseModel;
import com.example.team.mapapplication.bean.UserBean;

public class LoginModel extends BaseModel {
    public static long userId = -1;
    public String mClassName = LoginConstants.ACTIVITY_CLASS_NAMES[0];


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
