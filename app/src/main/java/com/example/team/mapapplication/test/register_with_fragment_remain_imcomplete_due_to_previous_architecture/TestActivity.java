package com.example.team.mapapplication.test.register_with_fragment_remain_imcomplete_due_to_previous_architecture;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.team.mapapplication.R;
import com.example.team.mapapplication.bean.TestBean;
import com.example.team.mapapplication.bean.WeatherBean;
import com.example.team.mapapplication.beaninterface.ITest;
import com.example.team.mapapplication.beaninterface.IWeather;
import com.example.team.mapapplication.engine.RetrofitFactory;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final TextView tv = findViewById(R.id.test_text);

        Button btn = findViewById(R.id.test_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Retrofit retrofit = RetrofitFactory.create("http://192.168.1.100:8080");
                Retrofit retrofit = RetrofitFactory.create("http://192.168.1.100:8080");
                ITest iTest = retrofit.create(ITest.class);
                Observable<TestBean> test = iTest.test();
                test.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<TestBean>() {
                            @Override
                            public void onCompleted() {
                                ToastUtils.showLong("S");
                            }

                            @Override
                            public void onError(Throwable e) {
                                ToastUtils.showLong("E");
//                        requireData();
                            }

                            @Override
                            public void onNext(TestBean weatherBean) {
                                ToastUtils.showLong("Next");
                                Log.e("TTTTTEST", weatherBean.Test);
                                tv.setText(weatherBean.Test);
//                        这里更新数据
//                        mViewModel.getDisplayInfos().addAll(weatherBean);
                            }
                        });
//
//                Retrofit retrofit = RetrofitFactory.create("https://api.thinkpage.cn");
//                IWeather iWeather = retrofit.create(IWeather.class);
//                Observable<WeatherBean> weather = iWeather.weather("rot2enzrehaztkdk","beijing");
//                weather.subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Subscriber<WeatherBean>() {
//                            @Override
//                            public void onCompleted() {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
////                        requireData();
//                            }
//
//                            @Override
//                            public void onNext(WeatherBean weatherBean) {
////                        这里更新数据
////                        mViewModel.getDisplayInfos().addAll(weatherBean);
//                                tv.setText(weatherBean.results.get(0).last_update);
//                            }
//                        });
            }
        });

    }


}

