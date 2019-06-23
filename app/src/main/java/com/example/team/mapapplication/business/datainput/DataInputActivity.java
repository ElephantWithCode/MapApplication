package com.example.team.mapapplication.business.datainput;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.bin.david.form.core.SmartTable;
import com.example.team.mapapplication.R;
import com.example.team.mapapplication.base.BaseActivity;
import com.example.team.mapapplication.base.BaseModel;
import com.example.team.mapapplication.test.register_with_fragment_remain_imcomplete_due_to_previous_architecture.TableTestBean;

import java.util.ArrayList;
import java.util.List;

public class DataInputActivity extends BaseActivity<DataInputPresenter> implements IDataInputView {

    private DataInputModel mModel = new DataInputModel();
    private SmartTable mTable;

    @Override
    protected DataInputPresenter createPresenter() {
        return null;
    }

    @Override
    protected int getDrawerIcon() {
        return R.drawable.qmui_icon_topbar_back;
    }

    @Override
    protected void onHomeIndicatorClicked() {
        finish();
    }

    @Override
    protected CharSequence getToolbarTitle() {
        return "表格输入";
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_data_input;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTable = findViewById(R.id.datainput_st);
        List<TableTestBean> list = new ArrayList<>();
        list.add(new TableTestBean("", ""));
        list.add(new TableTestBean("", ""));
        list.add(new TableTestBean("", ""));
        list.add(new TableTestBean("", ""));
        list.add(new TableTestBean("", ""));
        list.add(new TableTestBean("", ""));
        list.add(new TableTestBean("", ""));

        mTable.setData(list);
    }

    @Override
    public BaseModel getModel() {
        return mModel;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
