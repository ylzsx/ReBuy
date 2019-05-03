package com.example.rebuy.business.home.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.rebuy.R;
import com.example.rebuy.business.home.adapter.LookAroundAdapter;
import com.example.rebuy.business.home.model.LookAroundModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LookAroundActivity extends AppCompatActivity {

    @BindView(R.id.llayout_yikoujia)
    LinearLayout mLlayoutYikoujia;
    @BindView(R.id.llayout_exchange)
    LinearLayout mLlayoutExchange;
    @BindView(R.id.llayout_auction)
    LinearLayout mLlayoutAuction;
    @BindView(R.id.view_yikoujia)
    View mViewYikoujia;
    @BindView(R.id.view_exchange)
    View mViewExchange;
    @BindView(R.id.view_auction)
    View mViewAuction;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private LookAroundAdapter mLookAroundAdapter;
    private List<LookAroundModel> mLookAroundModels = new ArrayList<LookAroundModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_around);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        // 初始化RecyclerView
        initLookAroundModel();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mLookAroundAdapter = new LookAroundAdapter(this, mLookAroundModels);
        mRecyclerView.setAdapter(mLookAroundAdapter);
    }

    private void initLookAroundModel() {
        mLookAroundModels.clear();
        for (int i = 0; i < 20; i++) {
            LookAroundModel lookAroundModel = new LookAroundModel();
            mLookAroundModels.add(lookAroundModel);
        }
    }

    @OnClick({R.id.llayout_yikoujia, R.id.llayout_exchange, R.id.llayout_auction})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llayout_yikoujia:
                if (mViewYikoujia.getVisibility() == View.VISIBLE) {
                    mViewYikoujia.setVisibility(View.INVISIBLE);
                } else {
                    mViewYikoujia.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.llayout_exchange:
                if (mViewExchange.getVisibility() == View.VISIBLE) {
                    mViewExchange.setVisibility(View.INVISIBLE);
                } else {
                    mViewExchange.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.llayout_auction:
                if (mViewAuction.getVisibility() == View.VISIBLE) {
                    mViewAuction.setVisibility(View.INVISIBLE);
                } else {
                    mViewAuction.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
