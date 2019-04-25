package com.celsius.mom.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.celsius.mom.room.entities.CurrentCountryEntity;

import java.util.List;

@Dao
public interface CurrentCountryDao {

    @Insert
    public void insert(CurrentCountryEntity... currentCountryEntity);

    @Update
    public void update(CurrentCountryEntity... currentCountryEntity);

    @Delete
    public void delete(CurrentCountryEntity currentCountryEntity);

    @Query("SELECT * FROM currentcountry")
    LiveData<List<CurrentCountryEntity>> fetchAllTasks();


    @Query("SELECT * FROM currentcountry WHERE mId =:taskId")
    LiveData<CurrentCountryEntity> getTask(int taskId);

}
