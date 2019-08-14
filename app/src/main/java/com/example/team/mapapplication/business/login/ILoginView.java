package com.example.team.mapapplication.business.login;

import com.example.team.mapapplication.base.IBaseView;

public interface ILoginView extends IBaseView {
    void transferToMainView();

    void warningUserNotFound();

    void warningPasswordWrong();

    void warningInputIncomplete();
}
