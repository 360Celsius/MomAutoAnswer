package com.celsius.mom.api.manager;

import com.celsius.mom.api.configurations.BaseUrls;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class ApiManager {

    private Retrofit retrofitCountriesData;
    private Retrofit retrofitCurrentCountryData;
    private OkHttpClient okHttpClient;


    @Inject
    public ApiManager(){

        okHttpClient = new OkHttpClient();

        retrofitCountriesData = new retrofit2.Retrofit.Builder()
                .baseUrl(BaseUrls.BASE_URL_COUNTRIES_DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();


        retrofitCurrentCountryData = new retrofit2.Retrofit.Builder()
                .baseUrl(BaseUrls.BASE_URL_CURRENT_COUNTRY_DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public Retrofit getRetrofitCountriesData() {
        return retrofitCountriesData;
    }

    public Retrofit getRetrofitCurrentCountryData() {
        return retrofitCurrentCountryData;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
