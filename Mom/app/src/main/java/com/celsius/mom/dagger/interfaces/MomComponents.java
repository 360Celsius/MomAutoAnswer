package com.celsius.mom.dagger.interfaces;

import com.celsius.mom.callbacks.Callbacks;
import com.celsius.mom.dagger.modules.ApiManagerModule;
import com.celsius.mom.dagger.modules.ContextModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ContextModule.class, ApiManagerModule.class})
public interface MomComponents {
    void inject(Callbacks presenter);
}
