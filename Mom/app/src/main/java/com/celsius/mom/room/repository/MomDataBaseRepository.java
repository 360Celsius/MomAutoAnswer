package com.celsius.mom.room.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.celsius.mom.room.db.MomDataBase;
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
        momDataBase = Room.databaseBuilder(context, MomDataBase.class, DB_NAME).build();
    }


    //============================= Current Country Data ===========================================
    public void inserdCurrentCountryEntity(String currentCountryName){
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
        final LiveData<CurrentCountryEntity> task = getTask(id);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                momDataBase.daoCurrentCountryAccess().delete(task.getValue());
                return null;
            }
        }.execute();
    }

    public void deleteTask(final int id) {
        final LiveData<CurrentCountryEntity> task = getTask(id);
        if(task != null) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    momDataBase.daoCurrentCountryAccess().delete(task.getValue());
                    return null;
                }
            }.execute();
        }
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

    public LiveData<CurrentCountryEntity> getTask(int id) {
        return momDataBase.daoCurrentCountryAccess().getTask(id);
    }

    public LiveData<List<CurrentCountryEntity>> getTasks() {
        return momDataBase.daoCurrentCountryAccess().fetchAllTasks();
    }

    //============================= ALL Countries Data ===========================================


}
