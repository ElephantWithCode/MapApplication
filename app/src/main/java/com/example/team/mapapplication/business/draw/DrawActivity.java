package com.example.team.mapapplication.business.draw;

import android.content.Context;
import android.os.Bundle;

import com.example.team.mapapplication.R;
import com.example.team.mapapplication.base.BaseActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;

public class DrawActivity extends BaseActivity<DrawPresenter> implements IDrawView{

    private DrawPresenter mPresenter = new DrawPresenter();
    private LineChart mChart;


    @Override
    protected DrawPresenter createPresenter() {
        return mPresenter;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_draw;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attach(this);
        mChart = findViewById(R.id.act_draw_lc);

        mPresenter.drawData("label");


    }

    @Override
    public void drawLine(LineData data) {
        mChart.setData(data);
        mChart.invalidate();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
