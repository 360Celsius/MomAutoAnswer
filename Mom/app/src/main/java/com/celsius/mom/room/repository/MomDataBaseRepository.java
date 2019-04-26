package com.celsius.mom.room.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.celsius.mom.room.db.MomDataBase;
import com.celsius.mom.room.entities.AllCountriesDataEntity;
import com.celsius.mom.room.entities.CurrentCountryEntity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MomDataBaseRepository {

    private String DB_NAME = "db_mom_auto_messaging";
    private MomDataBase momDataBase;

    @Inject
    public MomDataBaseRepository(Context context) {
        momDataBase = Room.databaseBuilder(context, MomDataBase.class, DB_NAME)
                .fallbackToDestructiveMigration().build();
    }


    //============================= Current Country Data ===========================================
    public void insertCurrentCountryEntity(String currentCountryName){
        CurrentCountryEntity currentCountryEntity = new CurrentCountryEntity();
        currentCountryEntity.setCurrentCountryName(currentCountryName);
        insertCurrentCountryEntity(currentCountryEntity);
    }

    @SuppressLint("StaticFieldLeak")
    private void insertCurrentCountryEntity(final CurrentCountryEntity currentCountryEntity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                momDataBase.daoCurrentCountryAccess().insert(currentCountryEntity);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void updateCurrentCountryEntity(final CurrentCountryEntity currentCountryEntity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                momDataBase.daoCurrentCountryAccess().update(currentCountryEntity);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void deleteCurrentCountryEntity(final int id) {
        final LiveData<CurrentCountryEntity> task = getCurrentCountryEntity(id);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                momDataBase.daoCurrentCountryAccess().delete(task.getValue());
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void deleteCurrentCountryEntity(final CurrentCountryEntity currentCountryEntity) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                momDataBase.daoCurrentCountryAccess().delete(currentCountryEntity);
                return null;
            }
        }.execute();
    }

    public LiveData<CurrentCountryEntity> getCurrentCountryEntity(int id) {
        return momDataBase.daoCurrentCountryAccess().getCurrentCountry(id);
    }

    public LiveData<List<CurrentCountryEntity>> getCurrentCountryEntity() {
        return momDataBase.daoCurrentCountryAccess().fetchAllCurrentCountry();
    }

    //============================= ALL Countries Data ===========================================

    public void insertAllCountriesEntity(String alpha2Code,String flag,String callingCodes){
        AllCountriesDataEntity allCountriesDataEntity = new AllCountriesDataEntity();
        allCountriesDataEntity.setAlpha2Code(alpha2Code);
        allCountriesDataEntity.setFlag(flag);
        allCountriesDataEntity.setCallingCodes(callingCodes);
        insertAllCountriesEntity(allCountriesDataEntity);
    }

    @SuppressLint("StaticFieldLeak")
    private void insertAllCountriesEntity(final AllCountriesDataEntity allCountriesDataEntity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                momDataBase.daoAllCountriesDaoAccess().insert(allCountriesDataEntity);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void updateAllCountriesDataEntityEntity(final AllCountriesDataEntity allCountriesDataEntity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                momDataBase.daoAllCountriesDaoAccess().update(allCountriesDataEntity);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void deleteAllCountriesDataEntityEntity(final int id) {
        final LiveData<AllCountriesDataEntity> task = getAllCountriesEntity(id);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                momDataBase.daoAllCountriesDaoAccess().delete(task.getValue());
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void deleteAllCountriesEntity(final AllCountriesDataEntity allCountriesDataEntity) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                momDataBase.daoAllCountriesDaoAccess().delete(allCountriesDataEntity);
                return null;
            }
        }.execute();
    }

    public LiveData<AllCountriesDataEntity> getAllCountriesEntity(int id) {
        return momDataBase.daoAllCountriesDaoAccess().getAllCountries(id);
    }

    public LiveData<List<AllCountriesDataEntity>> getAllCountriesEntity() {
        return momDataBase.daoAllCountriesDaoAccess().fetchAllCountries();
    }
}
