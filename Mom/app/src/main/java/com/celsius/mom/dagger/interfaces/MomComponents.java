package com.celsius.mom.dagger.interfaces;

import com.celsius.mom.dagger.modules.ContextModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ContextModule.class})
public interface MomComponents {

}
