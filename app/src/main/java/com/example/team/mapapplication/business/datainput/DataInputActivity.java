package com.example.team.mapapplication.business.datainput;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.bin.david.form.core.SmartTable;
import com.blankj.utilcode.util.SizeUtils;
import com.dinuscxj.itemdecoration.GridOffsetsItemDecoration;
import com.example.team.mapapplication.R;
import com.example.team.mapapplication.base.BaseActivity;
import com.example.team.mapapplication.base.BaseModel;
import com.example.team.mapapplication.business.draw.DrawActivity;
import com.example.team.mapapplication.test.register_with_fragment_remain_imcomplete_due_to_previous_architecture.TableTestBean;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DataInputActivity extends BaseActivity<DataInputPresenter> implements IDataInputView {

    private DataInputModel mModel = new DataInputModel();

    private RecyclerView mTable;
    private SuperAdapter<String> mAdapter;
    private GridLayoutManager mLayoutManager;


    @Override
    protected DataInputPresenter createPresenter() {
        return new DataInputPresenter();
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

        mTable = findViewById(R.id.datainput_rv);

        Button button = findViewById(R.id.datainput_bt);

        mPresenter.initiateModelList(10);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayoutManager.setSpanCount(mLayoutManager.getSpanCount() + 1);
                mPresenter.finishDataInput();
            }
        });
    }

    @Override
    public BaseModel getModel() {
        return mModel;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initiateRecyclerView() {
        mLayoutManager = new GridLayoutManager(this, 2);

        mAdapter = new SuperAdapter<String>(this, mModel.getWholeDataList(), R.layout.datainput_edittext){

            @Override
            public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, String item) {
                EditText editText = holder.findViewById(R.id.datainput_edittext_et);
                final int position = layoutPosition;
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        mPresenter.setEditedToList(position, editable.toString());
                    }
                });
            }
        };

        GridOffsetsItemDecoration goid = new GridOffsetsItemDecoration(GridOffsetsItemDecoration.GRID_OFFSETS_VERTICAL);

        goid.setHorizontalItemOffsets(SizeUtils.dp2px(5));
        goid.setVerticalItemOffsets(SizeUtils.dp2px(5));

        mTable.addItemDecoration(goid);
        mTable.setLayoutManager(mLayoutManager);

        mTable.setAdapter(mAdapter);
    }

    @Override
    public void moveToDrawView() {
        startActivity(new Intent(this, DrawActivity.class));
    }
}
