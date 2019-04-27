package com.celsius.mom.callbacks;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.celsius.mom.MainActivity;
import com.celsius.mom.SplashActivity;
import com.celsius.mom.api.interfaces.GetCountriesDataService;
import com.celsius.mom.api.interfaces.GetCurrentCountryDataService;
import com.celsius.mom.api.manager.ApiManager;
import com.celsius.mom.application.MomApplication;
import com.celsius.mom.pojos.CountriesDataResponce;
import com.celsius.mom.pojos.CurrentCountryResponce;
import com.celsius.mom.room.entities.CurrentCountryEntity;
import com.celsius.mom.room.repository.MomDataBaseRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Callbacks implements Application.ActivityLifecycleCallbacks {

    @Inject
    ApiManager apiManagerInstance;


    @Inject
    MomDataBaseRepository momDataBaseRepository;

    @SuppressLint("CheckResult")
    @Override
    public void onActivityCreated(final Activity activity, Bundle savedInstanceState) {

        MomApplication.getMyComponent().inject(this);

        if(activity instanceof SplashActivity){


            GetCurrentCountryDataService serviceCurrentCountryData = apiManagerInstance.getRetrofitCurrentCountryData().create(GetCurrentCountryDataService.class);
            GetCountriesDataService serviceCountriesDataService  = apiManagerInstance.getRetrofitCountriesData().create(GetCountriesDataService.class);

            List<Observable<?>> requests = new ArrayList<>();

            // Make a collection of all requests to call at once
            requests.add(serviceCurrentCountryData.getCurrentCountryDataService());
            requests.add(serviceCountriesDataService.getCountriesDataResponce());

            // Zipping all requests with the Function, which will receive the results.
            Observable.zip(requests, new Function<Object[], Object>() {
                @Override
                public Object apply(Object[] objects) throws Exception {
                    // Objects[] is an array of combined results of completed requests
                    momDataBaseRepository.insertCurrentCountryEntity(((CurrentCountryResponce) objects[0]).getCountryCode());

                    for(int i=0; i < ((ArrayList) objects[1]).size() ; i++){
                        momDataBaseRepository.insertAllCountriesEntity(
                                ((CountriesDataResponce) ((ArrayList) objects[1]).get(i)).getAlpha2Code(),
                                ((CountriesDataResponce) ((ArrayList) objects[1]).get(i)).getFlag(),
                                ((CountriesDataResponce) ((ArrayList) objects[1]).get(i)).getCallingCodes().get(0));

                    }


                    return new Object();
                }
                // After all requests had been performed the next observer will receive the Object, returned from Function
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(new Consumer<Object>() {  // Will be triggered if all requests will end successfully

                @Override
                public void accept(Object o) throws Exception {
                    Log.e("test","Will be triggered if all requests will end successfully");
//                    Intent intentone = new Intent(context.getApplicationContext(), MainActivity.class);
//                    context.startActivity(intentone);
                }

            }, new Consumer<Throwable>() { // Will be triggered if any error during requests will happen
                @Override
                public void accept(Throwable throwable) throws Exception {
                    Log.e("test","Will be triggered if any error during requests will happen");
//                    Intent intentone = new Intent(context.getApplicationContext(), MainActivity.class);
//                    context.startActivity(intentone);
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
