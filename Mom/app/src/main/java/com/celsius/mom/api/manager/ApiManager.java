package com.celsius.mom.api.manager;

import com.celsius.mom.api.configurations.BaseUrls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static Retrofit retrofit;

    public static Retrofit getCountryCodeRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BaseUrls.BASE_URL_COUNTRY_CODE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
