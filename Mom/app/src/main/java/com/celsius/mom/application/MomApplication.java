package com.celsius.mom.application;

import android.app.Application;

import com.celsius.mom.dagger.interfaces.DaggerMomComponents;
import com.celsius.mom.dagger.interfaces.MomComponents;
import com.celsius.mom.dagger.modules.ContextModule;
import com.celsius.mom.dagger.modules.MomDataBaseRepositoryModule;
import com.celsius.mom.room.repository.MomDataBaseRepository;

public class MomApplication extends Application {

    private static MomComponents component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMomComponents.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .momDataBaseRepositoryModule(new MomDataBaseRepositoryModule(new MomDataBaseRepository(getApplicationContext())))
                .build();
    }

    public static MomComponents getMyComponent() {
        return component;
    }

}
