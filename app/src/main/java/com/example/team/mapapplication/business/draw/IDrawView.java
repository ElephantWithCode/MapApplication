package com.example.team.mapapplication.business.draw;

import com.example.team.mapapplication.base.IBaseView;
import com.github.mikephil.charting.data.LineData;

public interface IDrawView extends IBaseView {
    public void drawLine(LineData data);
}
