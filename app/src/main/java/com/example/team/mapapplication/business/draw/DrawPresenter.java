package com.example.team.mapapplication.business.draw;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.team.mapapplication.base.BasePresenter;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

public class DrawPresenter extends BasePresenter<IDrawView> {
    private DrawModel mModel = new DrawModel();

    public void drawData(String label){
        LineDataSet dataSet = new LineDataSet(mModel.getData(mContext), label);
        LineData data = new LineData(dataSet);
        mView.drawLine(data);
    }
}
