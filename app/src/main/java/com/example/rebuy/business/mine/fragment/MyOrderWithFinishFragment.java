package com.example.rebuy.business.mine.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rebuy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrderWithFinishFragment extends Fragment {


    public MyOrderWithFinishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_order_with_finish, container, false);
    }

}
