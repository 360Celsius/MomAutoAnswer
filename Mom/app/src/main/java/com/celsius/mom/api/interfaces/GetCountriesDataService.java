package com.celsius.mom.api.interfaces;

import com.celsius.mom.api.configurations.EndPoints;
import com.celsius.mom.pojos.CountriesDataResponce;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountriesDataService {
    @GET(EndPoints.COUNTRIES_DATA)
    Observable<List<CountriesDataResponce>> getCountriesDataResponce();
}
