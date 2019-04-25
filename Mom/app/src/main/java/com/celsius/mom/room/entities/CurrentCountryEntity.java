package com.celsius.mom.room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "currentcountry")
public class CurrentCountryEntity {

    @ColumnInfo(name = "currentcountryname")
    private String currentCountryName;

    @PrimaryKey(autoGenerate = true)
    private int mId;

    public String getCurrentCountryName() {
        return currentCountryName;
    }

    public void setCurrentCountryName(String currentCountryName) {
        this.currentCountryName = currentCountryName;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }
}
