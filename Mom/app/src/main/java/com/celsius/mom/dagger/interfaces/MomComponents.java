package com.celsius.mom.dagger.interfaces;

import com.celsius.mom.SplashActivity;
import com.celsius.mom.dagger.modules.ApiManagerModule;
import com.celsius.mom.dagger.modules.ContextModule;
import com.celsius.mom.dagger.modules.MomDataBaseRepositoryModule;
import com.celsius.mom.fragments.AutoMessageFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ContextModule.class, ApiManagerModule.class, MomDataBaseRepositoryModule.class})
public interface MomComponents {
    void inject(SplashActivity presenter);
    void inject(AutoMessageFragment presenter);

}
