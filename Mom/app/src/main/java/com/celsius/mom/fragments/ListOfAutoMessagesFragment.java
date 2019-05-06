package com.celsius.mom.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.celsius.mom.R;
import com.celsius.mom.databinding.ErrorFragmentBinding;

public class ListOfAutoMessagesFragment extends BaseFragment {

    public final static String TAG = "ListOfAutoMessagesFragment";
    private View view;
    private ErrorFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.list_of_auto_messages_fragment, container, false);
        view = binding.getRoot();

        return view;
    }
}
