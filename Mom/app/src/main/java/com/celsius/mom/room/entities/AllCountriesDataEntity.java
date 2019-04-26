package com.celsius.mom.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "allcountriesdata", indices = {@Index(value = "alpha2Code", unique = true)} )
public class AllCountriesDataEntity {

    @ColumnInfo(name = "alpha2Code")
    private String alpha2Code;

    @ColumnInfo(name = "flag")
    private String flag;

    @ColumnInfo(name = "callingCodes")
    private String callingCodes;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "mId_allcountriesdata")
    private int mId_allcountriesdata;

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(String callingCodes) {
        this.callingCodes = callingCodes;
    }

    public int getId_allcountriesdata() {
        return mId_allcountriesdata;
    }

    public void setId_allcountriesdata(int mId_allcountriesdata) {
        this.mId_allcountriesdata = mId_allcountriesdata;
    }
}
