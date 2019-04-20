package com.example.team.mapapplication.test.register_with_fragment_remain_imcomplete_due_to_previous_architecture;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.team.mapapplication.base.BaseFragment;

public class RegisterFragment extends BaseFragment<RegisterPresenter> implements IRegisterView{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}


