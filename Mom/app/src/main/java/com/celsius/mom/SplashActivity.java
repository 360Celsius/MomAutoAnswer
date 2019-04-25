package com.celsius.mom;

import android.os.Bundle;
import android.util.Log;

import androidx.databinding.DataBindingUtil;

import com.celsius.mom.api.interfaces.GetCountriesDataService;
import com.celsius.mom.api.interfaces.GetCurrentCountryDataService;
import com.celsius.mom.api.manager.ApiManager;
import com.celsius.mom.application.MomApplication;
import com.celsius.mom.databinding.ActivitySplashBinding;
import com.celsius.mom.pojos.CountriesDataResponce;
import com.celsius.mom.pojos.CurrentCountryResponce;
import com.celsius.mom.room.repository.MomDataBaseRepository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding activitySplashBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

    }
}
