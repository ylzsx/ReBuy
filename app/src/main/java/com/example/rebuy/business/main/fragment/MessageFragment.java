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
import com.example.rebuy.business.main.adapter.MessageAdapter;
import com.example.rebuy.business.main.model.MessageModel;
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
public class MessageFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.seife_refresh)
    SwipeRefreshLayout mSeifeRefresh;
    Unbinder unbinder;

    private List<MessageModel> mMessageModels = new ArrayList<MessageModel>();
    private MessageAdapter mMessageAdapter;

    private int[] mPortraits = {R.drawable.ic_message1, R.drawable.ic_message2};
    private String[] mNames = {"阿狸哈哈哈", "徐瀚哈哈哈"};
    private String[] mContents = {"取消订单", "申请退款"};
    private String[] mDates = {"2016.03.05", "2016.04.12"};
    private String[] mTime = {"18:22", "12:26"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        initListener();
        super.onActivityCreated(savedInstanceState);
    }

    private void initListener() {
        mSeifeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initMessage();
                refreshMessage();
            }
        });
    }

    private void refreshMessage() {
        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                ThreadUtils.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        initMessage();
                        mMessageAdapter.notifyDataSetChanged();
                        mSeifeRefresh.setRefreshing(false);
                    }
                });
            }
        });
    }

    private void initData() {
        // 初始化RecyclerView
        initMessage();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mMessageAdapter = new MessageAdapter(this.getContext(), mMessageModels);
        mRecyclerView.setAdapter(mMessageAdapter);
    }

    private void initMessage() {
        mMessageModels.clear();
        for (int j = 0; j < 2; j++) {
            Random random = new Random();
            int i = random.nextInt(20) % 2;
            MessageModel messageModel = new MessageModel(mPortraits[i], mNames[i], mContents[i], mDates[i], mTime[i]);
            mMessageModels.add(messageModel);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
