package com.example.team.mapapplication.business.datainput;

import com.example.team.mapapplication.base.BaseModel;
import com.example.team.mapapplication.bean.InputTableInfo;
import com.example.team.mapapplication.bean.InputValueInfo;
import com.example.team.mapapplication.engine.DbSaverHelper;
import com.example.team.mapapplication.engine.FlagConstant;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class DataInputModel extends BaseModel {
    private ArrayList<ArrayList<String> > mDataList = new ArrayList<>();
    private ArrayList<String> mWholeDataList = new ArrayList<>();

    private DbSaverHelper<InputTableInfo> mDbSaver = new DbSaverHelper<>();

    public int getColumnCount(){
        return mDataList.size();
    }

    public ArrayList<String> getWholeDataList() {
        return mWholeDataList;
    }

    public void saveTableInfo(String fileName){
        List<InputTableInfo> data = getInputTableInfoList(fileName);
        mDbSaver.saveValuesToDb(fileName, data);
        mDbSaver.saveDisplayToDB(fileName, FlagConstant.TYPE_INPUT_DATA);
    }

    /**
     * 将所有输入的数据按“一二”的格式打包进InputTableInfo对象
     * @param fileName
     * @return
     */
    private List<InputTableInfo> getInputTableInfoList(String fileName){
        List<String> oList = getWholeDataList();
        List<InputTableInfo> nList = new ArrayList<>();
        for (int i = 0; i < oList.size() / 2; i = i + 2){
            InputTableInfo info = new InputTableInfo();
            info.setX(Double.valueOf(oList.get(i)));
            info.setY(Double.valueOf(oList.get(i+1)));
            info.setFileName(fileName);
            nList.add(info);
        }
        return nList;
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
