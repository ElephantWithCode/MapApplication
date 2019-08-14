package com.example.team.mapapplication.business.login;

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
                mView.transferToMainView();
                break;
            case LoginConstants.VERIFIED_USER_NOT_FOUND:
                mView.warningUserNotFound();
                break;
            case LoginConstants.VERIFIED_PASSWORD_WRONG:
                mView.warningPasswordWrong();
                break;
        }

    }
}
