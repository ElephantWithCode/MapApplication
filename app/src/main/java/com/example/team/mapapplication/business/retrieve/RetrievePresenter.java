package com.example.team.mapapplication.business.retrieve;

import rx.Observable;
import android.os.Handler;

import com.example.team.mapapplication.base.BasePresenter;
import com.example.team.mapapplication.bean.WeatherBean;
import com.example.team.mapapplication.beaninterface.IWeather;
import com.example.team.mapapplication.engine.RetrofitFactory;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
     * 在线获取数据，测试中
     */
    public void showTableOnline(){
        mViewModel.getDisplayInfos().clear();
        mView.showLoading();

        Retrofit retrofit = RetrofitFactory.create("https://api.thinkpage.cn");
        IWeather iWeather = retrofit.create(IWeather.class);
        Observable<WeatherBean> weather = iWeather.weather("rot2enzrehaztkdk","beijing");
        weather.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeatherBean>() {
                    @Override
                    public void onCompleted() {
                        mView.notifyDataSetChanged();
                        mView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        requireData();
                    }

                    @Override
                    public void onNext(WeatherBean weatherBean) {
//                        mViewModel.getDisplayInfos().addAll(weatherBean);
                    }
                });
    }

    /**
     * 同样的测试中
     * @param fileName 要删除的文件名
     */
    public void deleteThisTableOnline(final String fileName){
        mView.showLoading();

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
