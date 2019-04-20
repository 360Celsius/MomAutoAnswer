package com.celsius.mom.dagger.modules;

import com.celsius.mom.api.manager.ApiManager;
import javax.inject.Inject;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiManagerModule {

    private ApiManager apiManager;

    @Inject
    public ApiManagerModule(ApiManager apiManager) {
        this.apiManager = apiManager;
    }

    @Provides
    @Singleton
    public ApiManager getDatabase() {
        return apiManager;
    }
}
