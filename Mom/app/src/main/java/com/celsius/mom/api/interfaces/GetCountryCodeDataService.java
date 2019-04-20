package com.celsius.mom.api.interfaces;

import com.celsius.mom.api.configurations.EndPoints;
import com.celsius.mom.pojos.IpApiResponce;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryCodeDataService {
    @GET(EndPoints.COUNTRY_CODE)
    Call<IpApiResponce> getIpApiResponce();
}
