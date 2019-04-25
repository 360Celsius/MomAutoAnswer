package com.celsius.mom.callbacks;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.celsius.mom.SplashActivity;
import com.celsius.mom.api.interfaces.GetCountriesDataService;
import com.celsius.mom.api.interfaces.GetCurrentCountryDataService;
import com.celsius.mom.api.manager.ApiManager;
import com.celsius.mom.application.MomApplication;
import com.celsius.mom.pojos.CountriesDataResponce;
import com.celsius.mom.pojos.CurrentCountryResponce;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Callbacks implements Application.ActivityLifecycleCallbacks {

    @Inject
    ApiManager apiManagerInstance;


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        MomApplication.getMyComponent().inject(this);

        if(activity instanceof SplashActivity){


            GetCurrentCountryDataService serviceCurrentCountryData = apiManagerInstance.retrofitCurrentCountryData.create(GetCurrentCountryDataService.class);
            Call<CurrentCountryResponce> callCurrentCountryData = serviceCurrentCountryData.getCurrentCountryDataService();
            callCurrentCountryData.enqueue(new Callback<CurrentCountryResponce>() {

                @Override
                public void onResponse(Call<CurrentCountryResponce> call, Response<CurrentCountryResponce> response) {
                    Log.e("test","1");

                }

                @Override
                public void onFailure(Call<CurrentCountryResponce> call, Throwable t) {
                    Log.e("test","1");
                }
            });


            GetCountriesDataService serviceCountriesDataService  = apiManagerInstance.retrofitCountriesData.create(GetCountriesDataService.class);
            Call<List<CountriesDataResponce>> callCountriesDataService  = serviceCountriesDataService.getCountriesDataResponce();
            callCountriesDataService.enqueue(new Callback<List<CountriesDataResponce>>() {

                @Override
                public void onResponse(Call<List<CountriesDataResponce>> call, Response<List<CountriesDataResponce>> response) {
                    Log.e("test","1");

                }

                @Override
                public void onFailure(Call<List<CountriesDataResponce>> call, Throwable t) {
                    Log.e("test","1");
                }
            });
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
