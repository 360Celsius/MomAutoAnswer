package com.celsius.mom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.celsius.mom.api.interfaces.GetCountryCodeDataService;
import com.celsius.mom.api.manager.ApiManager;
import com.celsius.mom.pojos.IpApiResponce;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


    }
}
