package com.example.rebuy.business.mine.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rebuy.R;
import com.example.rebuy.business.mine.adapter.MyOrderWithoutFinishAdapter;
import com.example.rebuy.business.mine.model.MyOrderWithoutFinishModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrderWithoutFinishFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    private List<MyOrderWithoutFinishModel> mMyOrderWithoutFinishModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_order_without_finish, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        initData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        MyOrderWithoutFinishAdapter myOrderWithoutFinishAdapter = new MyOrderWithoutFinishAdapter(this.getContext(), mMyOrderWithoutFinishModels);
        mRecyclerView.setAdapter(myOrderWithoutFinishAdapter);
    }

    private void initData() {
        mMyOrderWithoutFinishModels.clear();
        for (int i = 0; i < 20; i++) {
            MyOrderWithoutFinishModel myOrderWithoutFinishModel = new MyOrderWithoutFinishModel();
            mMyOrderWithoutFinishModels.add(myOrderWithoutFinishModel);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
