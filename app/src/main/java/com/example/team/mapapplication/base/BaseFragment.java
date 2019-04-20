package com.example.team.mapapplication.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BaseFragment<V extends BasePresenter> extends Fragment {

    protected V mPresenter;

    public BaseFragment(){
    }

    public void attachPresenter(V presenter){
        if (mPresenter != null){
            mPresenter = presenter;
        }
    }

    public void detachPresenter(){
        mPresenter = null;
    }
}
