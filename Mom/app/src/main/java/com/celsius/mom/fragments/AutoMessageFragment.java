package com.celsius.mom.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.celsius.mom.R;
import com.celsius.mom.application.MomApplication;
import com.celsius.mom.databinding.AutoMessageFragmentBinding;
import com.celsius.mom.room.entities.AllCountriesDataEntity;
import com.celsius.mom.room.entities.CurrentCountryEntity;
import com.celsius.mom.room.repository.MomDataBaseRepository;

import java.util.List;

import javax.inject.Inject;

public class AutoMessageFragment extends BaseFragment {

    public final static String TAG = "AutoMessageFragment";
    private View view;
    private AutoMessageFragmentBinding binding;

    @Inject
    MomDataBaseRepository momDataBaseRepository;

    private String currentCountry = null;
    private String currentPhonePrefix = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        MomApplication.getMyComponent().inject(this);

        binding = DataBindingUtil.inflate(inflater, R.layout.auto_message_fragment, container, false);
        view = binding.getRoot();

        momDataBaseRepository.getCurrentCountryEntity().observe(getActivity(), new Observer<List<CurrentCountryEntity>>() {
            @Override
            public void onChanged(List<CurrentCountryEntity> currentCountryEntities) {
                currentCountry = currentCountryEntities.get(0).getCurrentCountryName();

            }
        });


        momDataBaseRepository.getAllCountriesEntity().observe(getActivity(), new Observer<List<AllCountriesDataEntity>>() {
            @Override
            public void onChanged(List<AllCountriesDataEntity> allCountriesDataEntities) {
                for (int i=0 ; i<allCountriesDataEntities.size() ; i++){
                    if (currentCountry.equalsIgnoreCase(allCountriesDataEntities.get(i).getAlpha2Code() ) ) {
                        currentPhonePrefix = allCountriesDataEntities.get(i).getCallingCodes();
                        break;
                    }
                }
            }
        });

        return view;
    }
}
