package com.celsius.mom.api.manager;

import com.celsius.mom.api.configurations.BaseUrls;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class ApiManager {

    public Retrofit retrofitCountriesData;
    public Retrofit retrofitCurrentCountryData;
    OkHttpClient okHttpClient;


    @Inject
    public ApiManager(){

        okHttpClient = new OkHttpClient();

        retrofitCountriesData = new retrofit2.Retrofit.Builder()
                .baseUrl(BaseUrls.BASE_URL_COUNTRIES_DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


        retrofitCurrentCountryData = new retrofit2.Retrofit.Builder()
                .baseUrl(BaseUrls.BASE_URL_CURRENT_COUNTRY_DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

}
