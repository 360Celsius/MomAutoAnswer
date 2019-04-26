package com.celsius.mom.room.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.celsius.mom.room.dao.AllCountriesDao;
import com.celsius.mom.room.dao.CurrentCountryDao;
import com.celsius.mom.room.entities.AllCountriesDataEntity;
import com.celsius.mom.room.entities.CurrentCountryEntity;

@Database(entities = {CurrentCountryEntity.class, AllCountriesDataEntity.class}, version = 4, exportSchema = false)
public abstract class MomDataBase extends RoomDatabase {
    public abstract CurrentCountryDao daoCurrentCountryAccess();
    public abstract AllCountriesDao daoAllCountriesDaoAccess();
}
