package com.example.team.mapapplication.business.login;

import android.content.Intent;

import com.example.team.mapapplication.base.BasePresenter;
import com.example.team.mapapplication.bean.UserBean;

public class LoginPresenter extends BasePresenter<ILoginView> {
    private LoginModel mModel = new LoginModel();
    public boolean judgeUserFormat(UserBean user){
        if (mModel.judgeUserFormat(user)){
            mView.warningInputIncomplete();
            return false;
        }else {
            return true;
        }
    }
    public void login(UserBean user){
        if (!judgeUserFormat(user)) {
            return;
        }
        int verifiedState = mModel.verifyUser(user);
        switch (verifiedState){
            case LoginConstants.VERIFIED_OK:
                mModel.saveUserInfo(mContext);
                mView.transferToMainView(mModel.getTargetActivityClass());
                break;
            case LoginConstants.VERIFIED_USER_NOT_FOUND:
                mView.warningUserNotFound();
                break;
            case LoginConstants.VERIFIED_PASSWORD_WRONG:
                mView.warningPasswordWrong();
                break;
        }

    }

    public void processIntent(Intent intent){
        String className = intent.getStringExtra("class");
//        if (className.isEmpty()){     Empty Class Name Exception will be handled in the LoginModel.getTargetActivityClass method;
//            throw new Exception("Intent Name Must Be Set");
//        }
        mModel.setTargetClassName(className);
    }
}
