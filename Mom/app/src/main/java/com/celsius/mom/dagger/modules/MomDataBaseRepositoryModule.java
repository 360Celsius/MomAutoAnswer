package com.celsius.mom.dagger.modules;

import com.celsius.mom.room.repository.MomDataBaseRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MomDataBaseRepositoryModule {
    private MomDataBaseRepository momDataBaseRepositoryImpl;

    @Inject
    public MomDataBaseRepositoryModule(MomDataBaseRepository momDataBaseRepositoryImpl) {
        this.momDataBaseRepositoryImpl = momDataBaseRepositoryImpl;
    }

    @Provides
    @Singleton
    public MomDataBaseRepository getDatabase() {
        return momDataBaseRepositoryImpl;
    }
}
