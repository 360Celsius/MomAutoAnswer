package com.celsius.mom.application;

import android.app.Application;
import android.os.Handler;

import com.celsius.mom.callbacks.Callbacks;
import com.celsius.mom.dagger.interfaces.DaggerMomComponents;
import com.celsius.mom.dagger.interfaces.MomComponents;
import com.celsius.mom.dagger.modules.ContextModule;

public class MomApplication extends Application {

    private static MomComponents component;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new Callbacks());

        component = DaggerMomComponents.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public static MomComponents getMyComponent() {
        return component;
    }

}
