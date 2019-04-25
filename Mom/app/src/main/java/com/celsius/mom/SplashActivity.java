package com.celsius.mom;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.celsius.mom.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity {

    private ActivitySplashBinding activitySplashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
    }
}
