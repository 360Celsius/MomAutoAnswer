package com.celsius.mom.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "currentcountry")
public class CurrentCountryEntity {

    @ColumnInfo(name = "currentcountryname")
    private String currentCountryName;

    @PrimaryKey(autoGenerate = true)
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
