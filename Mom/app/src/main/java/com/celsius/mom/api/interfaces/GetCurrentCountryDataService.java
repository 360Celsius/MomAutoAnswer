package com.celsius.mom.api.interfaces;

import com.celsius.mom.api.configurations.EndPoints;
import com.celsius.mom.pojos.CountriesDataResponce;
import com.celsius.mom.pojos.CurrentCountryResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCurrentCountryDataService {
    @GET(EndPoints.CURENT_COUNTRY_DATA)
    Call<CurrentCountryResponce> getCurrentCountryDataService();
}
