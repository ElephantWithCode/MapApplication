package com.example.team.mapapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.LitePalSupport;

public class InputTableInfo extends LitePalSupport implements Parcelable {
    private double x;
    private double y;
    private String fileName;

    public void setX(double x){
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public InputTableInfo(){

    }

    protected InputTableInfo(Parcel in) {
        x = in.readDouble();
        y = in.readDouble();
        fileName = in.readString();
    }

    public static final Creator<InputTableInfo> CREATOR = new Creator<InputTableInfo>() {
        @Override
        public InputTableInfo createFromParcel(Parcel in) {
            return new InputTableInfo(in);
        }

        @Override
        public InputTableInfo[] newArray(int size) {
            return new InputTableInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(x);
        parcel.writeDouble(y);
        parcel.writeString(fileName);
    }
}
