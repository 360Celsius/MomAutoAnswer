package com.celsius.mom.callbacks;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.celsius.mom.SplashActivity;
import com.celsius.mom.api.interfaces.GetCountryCodeDataService;
import com.celsius.mom.api.manager.ApiManager;
import com.celsius.mom.pojos.IpApiResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Callbacks implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if(activity instanceof SplashActivity){
            GetCountryCodeDataService service = ApiManager.getCountryCodeRetrofitInstance().create(GetCountryCodeDataService.class);
            Call<IpApiResponce> call = service.getIpApiResponce();
            call.enqueue(new Callback<IpApiResponce>() {

                @Override
                public void onResponse(Call<IpApiResponce> call, Response<IpApiResponce> response) {
                    Log.e("test","1");
                    Log.e("test",response.body().getAs());
                    Log.e("test",response.body().getCity());
                    Log.e("test",response.body().getCountry());
                    Log.e("test",response.body().getCountryCode());
                    Log.e("test",response.body().getIsp());
                    Log.e("test",response.body().getLat());
                    Log.e("test",response.body().getLon());
                    Log.e("test",response.body().getOrg());
                    Log.e("test",response.body().getQuery());
                    Log.e("test",response.body().getRegion());
                    Log.e("test",response.body().getRegion());
                    Log.e("test",response.body().getStatus());
                    Log.e("test",response.body().getTimezone());
                    Log.e("test",response.body().getZip());

                }

                @Override
                public void onFailure(Call<IpApiResponce> call, Throwable t) {
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
