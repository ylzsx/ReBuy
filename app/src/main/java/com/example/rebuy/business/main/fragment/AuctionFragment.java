package com.example.rebuy.business.main.fragment;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rebuy.R;
import com.example.rebuy.business.main.adapter.AuctionAdapter;
import com.example.rebuy.business.main.model.AuctionModel;
import com.example.rebuy.utils.ThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuctionFragment extends Fragment {

    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    Unbinder unbinder;

    private List<AuctionModel> mAuctionModels = new ArrayList<AuctionModel>();
    private AuctionAdapter mAuctionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auction, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        initListener();
        super.onActivityCreated(savedInstanceState);
    }


    private void initData() {
        // 初始化RecyclerView
        initAuctionData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        mRecycleView.setLayoutManager(linearLayoutManager);
        mAuctionAdapter = new AuctionAdapter(this.getContext(), mAuctionModels);
        mRecycleView.setAdapter(mAuctionAdapter);
    }

    private void initAuctionData() {
        mAuctionModels.clear();
        for (int i = 0; i < 20; i++) {
            AuctionModel auctionModel = new AuctionModel();
            auctionModel.setContent(getResources().getString(R.string.txt_lace_dress));
            Random random = new Random();
            int temp = random.nextInt(5000 - 800 + 1) + 800;
            double price = (double) temp / 10;
            auctionModel.setPrice(price);
            auctionModel.setDeadline("2016.09.04");
            int personNum = random.nextInt(20 - 10 + 1) + 10;
            auctionModel.setPersonNum(personNum);

            mAuctionModels.add(auctionModel);
        }
    }

    private void initListener() {
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshAuction();
            }
        });
    }

    private void refreshAuction() {
        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                ThreadUtils.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        initAuctionData();
                        // 通知数据变化
                        mAuctionAdapter.notifyDataSetChanged();
                        // 表示刷新事件结束
                        mSwipeRefresh.setRefreshing(false);
                    }
                });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
