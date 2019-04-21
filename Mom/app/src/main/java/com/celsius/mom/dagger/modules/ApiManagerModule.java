package com.celsius.mom.dagger.modules;

import android.content.Context;

import com.celsius.mom.api.manager.ApiManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiManagerModule {

    @Provides
    @Singleton
    public ApiManager getApiManager() {
        return new ApiManager();
    }
}
