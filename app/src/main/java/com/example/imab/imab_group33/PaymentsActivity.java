package com.example.imab.imab_group33;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by daniel on 4/23/2017.
 */

public class PaymentsActivity extends Fragment {
    @Override
    public void onVIewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("PaymentsActivity");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstancestate) {
       return  inflater.inflate(R.layout.PaymentsActivity, container, false);
    }

}
