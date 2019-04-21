package com.celsius.mom.api.manager;

import com.celsius.mom.api.configurations.BaseUrls;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class ApiManager {

    public Retrofit retrofit;

    @Inject
    public ApiManager(){
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BaseUrls.BASE_URL_COUNTRY_CODE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
