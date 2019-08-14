package com.example.team.mapapplication.business.datainput;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.team.mapapplication.base.BasePresenter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataInputPresenter extends BasePresenter<IDataInputView> {

    private DataInputModel mModel = (DataInputModel) mView.getModel();

    public void setEditedToList(int position, String string) {
        mModel.getWholeDataList().set(position, string);
    }

    public void initiateModelList(int count) {
        for (int i = 0; i < count; i++){
            mModel.getWholeDataList().add("123");
        }
    }

    public void finishDataInput() {
        SharedPreferences.Editor editor = mContext.getSharedPreferences("input_data", Context.MODE_PRIVATE).edit();
        editor.putStringSet("data", constructSetFromArrayList(mModel.getWholeDataList()));
        editor.apply();
        mView.moveToDrawView();
    }

    private Set<String> constructSetFromArrayList(ArrayList<String> wholeDataList) {
        Set<String> set = new HashSet<String>(wholeDataList);
        return set;
    }
}
