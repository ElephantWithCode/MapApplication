package com.example.team.mapapplication.business.draw;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.team.mapapplication.base.BaseModel;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DrawModel extends BaseModel {

    public ArrayList<Float> parseData(Collection<String> stringList){
        ArrayList<Float> doubleList = new ArrayList<>();
        for (String s : stringList){
            doubleList.add(Float.valueOf(s));
        }
        return doubleList;
    }

    /***
     * 仅作测试用
     * @return
     */
    public List<Entry> getData(){
        List<Entry> entries = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < 10; i ++){
            temp.add(String.valueOf(i));
        }
        for (Float d : parseData(temp)){
            entries.add(new Entry(d, d));
        }
        return entries;
    }

    public List<Entry> getData(Context context){
        List<Entry> entries = new ArrayList<>();
        Set<String> temp = new HashSet<>();
        SharedPreferences sp = context.getSharedPreferences("input_data", Context.MODE_PRIVATE);
        sp.getStringSet("data", temp);
        for (Float d : parseData(temp)){
            entries.add(new Entry(d, d));
        }
        return entries;
    }
}
