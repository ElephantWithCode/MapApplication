package com.example.team.mapapplication.business.retrieve;

import android.os.Handler;

import com.example.team.mapapplication.base.BasePresenter;

/**
 * Created by Ellly on 2018/8/12.
 */

public class RetrievePresenter extends BasePresenter<IRetrieveView> {

    private RetrieveViewModel mViewModel;

    private RetrieveModel mModel = new RetrieveModel();

    @Override
    public void attach(IRetrieveView view) {
        super.attach(view);
        mViewModel = (RetrieveViewModel) mView.getModel();
    }

    public void requireData() {
        mViewModel.getDisplayInfos().clear();

        mViewModel.getDisplayInfos().addAll(mModel.getDisplayInfos());
    }

    /**
     * Asynchronous way of loading data. wyy
     */
    public void showTable(){
        mView.showLoading();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                requireData();
                mView.notifyDataSetChanged();
                mView.hideLoading();
            }
        });
    }

    /**
     *
     * @param fileName table name
     */

    public void deleteThisTable(final String fileName) {
        mView.showLoading();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                mModel.deleteThisDataList(fileName);
                mModel.deleteThisDisplayInfo(fileName);
                requireData();
                mView.notifyDataSetChanged();
            }
        });

    }
}
