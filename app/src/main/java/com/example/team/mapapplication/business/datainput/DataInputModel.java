package com.example.team.mapapplication.business.datainput;

import com.example.team.mapapplication.base.BaseModel;

import java.io.StringReader;
import java.util.ArrayList;

public class DataInputModel extends BaseModel {
    private ArrayList<ArrayList<String> > mDataList = new ArrayList<>();
    private ArrayList<String> mWholeDataList = new ArrayList<>();

    public int getColumnCount(){
        return mDataList.size();
    }

    public ArrayList<String> getWholeDataList() {
        return mWholeDataList;
    }

    public void setDataList(ArrayList<ArrayList<String>> mDataList) {
        this.mDataList.clear();
        this.mWholeDataList.clear();
        this.mDataList.addAll(mDataList);
        this.mWholeDataList.addAll(flatter(mDataList));
    }

    public ArrayList<String> flatter(ArrayList<ArrayList<String> > datalist){
        ArrayList<String> fList = new ArrayList<>();
        for (ArrayList<String> l : datalist){
            fList.addAll(l);
        }
        return fList;
    }

    public ArrayList<ArrayList<String>> getDataList() {
        return mDataList;
    }
}
