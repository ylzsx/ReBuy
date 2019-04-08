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
import com.example.rebuy.business.mine.adapter.MyShopOnSaleAdapter;
import com.example.rebuy.business.mine.model.MyShopOnSaleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyShopOnSaleFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;

    private List<MyShopOnSaleModel> mMyShopOnSaleModels = new ArrayList<MyShopOnSaleModel>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_shop_on_sale, container, false);
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
        MyShopOnSaleAdapter myShopOnSaleAdapter = new MyShopOnSaleAdapter(this.getContext(), mMyShopOnSaleModels);
        mRecyclerView.setAdapter(myShopOnSaleAdapter);
    }

    private void initData() {
        mMyShopOnSaleModels.clear();
        for (int i = 0; i < 20; i++) {
            MyShopOnSaleModel myShopOnSaleModel = new MyShopOnSaleModel();
            mMyShopOnSaleModels.add(myShopOnSaleModel);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
