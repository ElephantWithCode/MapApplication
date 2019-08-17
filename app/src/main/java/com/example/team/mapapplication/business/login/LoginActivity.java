package com.example.team.mapapplication.business.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.team.mapapplication.R;
import com.example.team.mapapplication.base.BaseActivity;
import com.example.team.mapapplication.bean.UserBean;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView{


    private EditText mUserNameEdit;
    private EditText mPasswordEdit;
    private TextView mLoginBtn;

    @Override
    protected LoginPresenter createPresenter() {
        return mPresenter;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attach(this);

        mPresenter.processIntent(getIntent());

        initView();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserBean user = UserBean.constructFromNameAndPassword(mUserNameEdit.getText().toString(), mPasswordEdit.getText().toString());
                mPresenter.login(user);
            }
        });



    }

    private void initView() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void transferToMainView(Class c) {
        startActivity(new Intent(this, c));
    }

    @Override
    public void warningUserNotFound() {

    }

    @Override
    public void warningPasswordWrong() {

    }

    @Override
    public void warningInputIncomplete() {

    }
}
