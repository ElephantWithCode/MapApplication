package com.example.team.mapapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.team.mapapplication.R;

public abstract class BaseFragmentActivity<V extends BasePresenter> extends BaseActivity {

    @Override
    protected V createPresenter() {
        return null;
    }

    public abstract BaseFragment getFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFragment();
    }

    private void setFragment() {
        BaseFragment fragment = getFragment();
        try {
            fragment.attachPresenter(mPresenter);
        } catch (Exception e) {
            Log.e("None Fragment Error", "You need to specify a fragment for your activity");
            throw e;
        }
        /*
        R.id.fragment_container remains unborn yet
        getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        */
    }
}
