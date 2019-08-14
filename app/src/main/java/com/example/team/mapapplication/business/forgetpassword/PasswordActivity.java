package com.example.team.mapapplication.business.forgetpassword;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.team.mapapplication.R;
import com.example.team.mapapplication.base.BaseActivity;

public class PasswordActivity extends BaseActivity<PasswordPresenter> implements IPasswordView {

    @Override
    protected PasswordPresenter createPresenter() {
        return new PasswordPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_password;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attach(this);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
