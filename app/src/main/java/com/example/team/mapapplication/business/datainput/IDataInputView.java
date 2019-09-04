package com.example.team.mapapplication.business.datainput;

import com.example.team.mapapplication.base.IBaseView;
import com.example.team.mapapplication.base.IBaseViewModel;
import com.example.team.mapapplication.base.LoadingDemonstrater;

public interface IDataInputView extends IBaseView, IBaseViewModel, LoadingDemonstrater {
    void initiateRecyclerView();

    void askFileName();

    void moveToDrawView();
}
