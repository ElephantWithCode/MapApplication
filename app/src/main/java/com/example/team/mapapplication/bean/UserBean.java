package com.example.team.mapapplication.bean;

public class UserBean {
    private String mUserName;
    private String mPassword;
    private String IsOk;

    public static UserBean constructFromNameAndPassword(String mUserName, String mPassword){
        UserBean user = new UserBean();
        user.setUserName(mUserName);
        user.setPassword(mPassword);
        return user;
    }

    public static Boolean isLogined(){
        return false;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        this.mUserName = userName;
    }

    public String getIsOk() {
        return IsOk;
    }

    public void setIsOk(String isOk) {
        IsOk = isOk;
    }
}
