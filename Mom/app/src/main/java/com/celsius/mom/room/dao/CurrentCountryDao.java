package com.celsius.mom.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.celsius.mom.room.entities.CurrentCountryEntity;

import java.util.List;

@Dao
public interface CurrentCountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(CurrentCountryEntity... currentCountryEntity);

    @Update
    public void update(CurrentCountryEntity... currentCountryEntity);

    @Delete
    public void delete(CurrentCountryEntity currentCountryEntity);

    @Query("SELECT * FROM currentcountry")
    LiveData<List<CurrentCountryEntity>> fetchAllCurrentCountry();


    @Query("SELECT * FROM currentcountry WHERE mId_currentcountry =:taskId")
    LiveData<CurrentCountryEntity> getCurrentCountry(int taskId);

}
