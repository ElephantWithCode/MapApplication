package com.example.team.mapapplication.test.register_with_fragment_remain_imcomplete_due_to_previous_architecture;

import android.os.Bundle;

import com.example.team.mapapplication.R;
import com.example.team.mapapplication.base.BaseFragment;
import com.example.team.mapapplication.base.BaseFragmentActivity;

public class RegisterActivity extends BaseFragmentActivity<RegisterPresenter> {

    @Override
    public BaseFragment getFragment() {
        return null;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
