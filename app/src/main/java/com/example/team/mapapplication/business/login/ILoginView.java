package com.example.team.mapapplication.business.login;

import com.example.team.mapapplication.base.IBaseView;
import com.example.team.mapapplication.base.LoadingDemonstrater;

public interface ILoginView extends IBaseView, LoadingDemonstrater {
    void transferToMainView(Class c);

    void warningUserNotFound();

    void warningPasswordWrong();

    void warningInputIncomplete();
}
