package com.celsius.mom.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "currentcountry", indices = {@Index(value = "currentcountryname", unique = true)} )
public class CurrentCountryEntity {

    @ColumnInfo(name = "currentcountryname")
    private String currentCountryName;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "mId_currentcountry")
    private int mId_currentcountry;

    public String getCurrentCountryName() {
        return currentCountryName;
    }

    public void setCurrentCountryName(String currentCountryName) {
        this.currentCountryName = currentCountryName;
    }

    public int getId_currentcountry() {
        return mId_currentcountry;
    }

    public void setId_currentcountry(int mId) {
        this.mId_currentcountry = mId;
    }
}
