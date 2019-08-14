package com.example.team.mapapplication.bean;

public class UserBean {
    private String mUserName;
    private String mPassword;
    public static UserBean constructFromNameAndPassword(String mUserName, String mPassword){
        UserBean user = new UserBean();
        user.setUserName(mUserName);
        user.setPassword(mPassword);
        return user;
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
}
