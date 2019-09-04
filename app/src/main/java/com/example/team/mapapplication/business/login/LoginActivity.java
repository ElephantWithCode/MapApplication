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
import com.example.team.mapapplication.engine.QMUITextDialogGenerater;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;

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
        mLoginBtn = findViewById(R.id.act_login_btn_lg);
        mUserNameEdit = findViewById(R.id.act_login_et_name);
        mPasswordEdit = findViewById(R.id.act_login_et_password);
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
        QMUIDialog dialog = new QMUITextDialogGenerater(this, "未找到该用户").getDialog();
        dialog.show();
    }

    @Override
    public void warningPasswordWrong() {
        new QMUITextDialogGenerater(this, "用户密码错误").getDialog().show();
    }

    @Override
    public void warningInputIncomplete() {
        new QMUITextDialogGenerater(this, "请全部输入").getDialog().show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected CharSequence getToolbarTitle() {
        return "登录";
    }

    @Override
    protected void onHomeIndicatorClicked() {
        super.onHomeIndicatorClicked();
        finish();
    }

    @Override
    protected int getDrawerIcon() {
        return R.drawable.qmui_icon_topbar_back;
    }
}
