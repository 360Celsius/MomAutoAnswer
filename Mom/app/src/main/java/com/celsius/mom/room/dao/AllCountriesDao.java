package com.celsius.mom.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.celsius.mom.room.entities.AllCountriesDataEntity;
import com.celsius.mom.room.entities.CurrentCountryEntity;

import java.util.List;

@Dao
public interface AllCountriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(AllCountriesDataEntity... allCountriesDataEntity);

    @Update
    public void update(AllCountriesDataEntity... allCountriesDataEntity);

    @Delete
    public void delete(AllCountriesDataEntity allCountriesDataEntity);

    @Query("SELECT * FROM allcountriesdata")
    LiveData<List<AllCountriesDataEntity>> fetchAllCountries();


    @Query("SELECT * FROM allcountriesdata WHERE mId_allcountriesdata =:taskId")
    LiveData<AllCountriesDataEntity> getAllCountries(int taskId);

}
