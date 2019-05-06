package com.celsius.mom;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import com.celsius.mom.databinding.ActivityMainBinding;
import com.celsius.mom.fragments.AutoMessageFragment;
import com.celsius.mom.fragments.ListOfAutoMessagesFragment;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_view_placeholder, new ListOfAutoMessagesFragment(), ListOfAutoMessagesFragment.TAG);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
