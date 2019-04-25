package com.celsius.mom.api.interfaces;

import com.celsius.mom.api.configurations.EndPoints;
import com.celsius.mom.pojos.CountriesDataResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryCodeDataService {
    @GET(EndPoints.COUNTRIES_DATA)
    Call<List<CountriesDataResponce>> getCountriesDataResponce();
}
