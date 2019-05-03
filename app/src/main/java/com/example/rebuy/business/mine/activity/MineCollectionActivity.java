package com.example.rebuy.business.mine.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rebuy.R;
import com.example.rebuy.business.auction.adapter.AuctionAdapter;
import com.example.rebuy.business.auction.model.AuctionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineCollectionActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<AuctionModel> mAuctionModels = new ArrayList<>();
    AuctionAdapter mAuctionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_collection);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        // 初始化RecyclerView
        initAuctionData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAuctionAdapter = new AuctionAdapter(this, mAuctionModels);
        mRecyclerView.setAdapter(mAuctionAdapter);
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
}
