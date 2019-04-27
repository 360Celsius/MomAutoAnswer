package com.celsius.mom;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.celsius.mom.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }

}
