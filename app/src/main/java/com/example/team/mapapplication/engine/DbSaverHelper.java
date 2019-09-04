package com.example.team.mapapplication.engine;


import com.example.team.mapapplication.bean.DataDisplayInfo;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.List;

public class DbSaverHelper<T extends LitePalSupport> {

    public Class<T> getParameterClass(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public boolean isThisNameUsed(String fileName){
        List<T> preData = LitePal.where("fileName = ?", fileName).find(getParameterClass());
        return preData != null && preData.size() > 0;
    }

    public void saveValuesToDb(String fileName, List<T> data){
        if (isThisNameUsed(fileName)){
            LitePal.deleteAll(getClass(), "fileName = ?", fileName);
        }
        for (T d : data){
            d.assignBaseObjId(0);
            d.save();
        }
    }

    public void saveDisplayToDB(String text, int type) {
        // save the saving behavior as another table. wyy

        Calendar calendar = Calendar.getInstance();
        DataDisplayInfo di = new DataDisplayInfo();
        di.setFileType(type);
        di.setFileName(text);
        di.setCalendar(calendar);
        di.setYear(calendar.get(Calendar.YEAR));
        di.setMonth(calendar.get(Calendar.MONTH ) + 1);
        di.setDay(calendar.get(Calendar.DAY_OF_MONTH));

        List<DataDisplayInfo> preData = LitePal.where("mFileName = ?", text).find(DataDisplayInfo.class);

        // determine whether the mFileName has been used. If not, then save it or it will be updated.
        if (preData == null || preData.size() <= 0){
            di.save();
        }else {
            di.updateAll("mFileName = ?", text);
        }
    }


}

