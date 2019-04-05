package com.example.rebuy.business.main.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rebuy.R;
import com.example.rebuy.business.GlideImageLoder;
import com.example.rebuy.business.main.adapter.GuessLikeAdapter;
import com.example.rebuy.business.main.model.GuessLikeModel;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.llayout_look_around)
    LinearLayout mLlayoutLookAround;
    @BindView(R.id.llayout_goods_delivered)
    LinearLayout mLlayoutGoodsDelivered;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    Unbinder unbinder;

    private List<Integer> mImages = new ArrayList<Integer>();
    private List<GuessLikeModel> mGuesslikeModels = new ArrayList<GuessLikeModel>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        super.onActivityCreated(savedInstanceState);
    }


    private void initData() {
        initBanner();
        initRecyclerView();
    }

    @OnClick({R.id.llayout_look_around, R.id.llayout_goods_delivered})
    public void onClickedView(View view) {
        switch (view.getId()) {
            case R.id.llayout_look_around:
                Toast.makeText(this.getContext(), "随便逛逛", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llayout_goods_delivered:
                Toast.makeText(this.getContext(), "有货出手", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 展示轮播图
     */
    private void initBanner() {
        if (mImages.size() == 0) {
            mImages.add(R.drawable.banner_one);
            mImages.add(R.drawable.banner_two);
            mImages.add(R.drawable.banner_three);
            mImages.add(R.drawable.banner_four);
            mImages.add(R.drawable.banner_five);
        }

        mBanner.setImageLoader(new GlideImageLoder());
        mBanner.setImages(mImages);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(3000);
        mBanner.start();
    }


    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        initGuessLikeData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        mRecycleView.setLayoutManager(gridLayoutManager);
        GuessLikeAdapter adapter = new GuessLikeAdapter(this.getContext(), mGuesslikeModels);
        mRecycleView.setAdapter(adapter);

        mRecycleView.setNestedScrollingEnabled(false);
    }

    /**
     * 初始化RecyclerView数据
     */
    private void initGuessLikeData() {
        mGuesslikeModels.clear();
        for (int i = 0; i < 20; i++) {
            GuessLikeModel guessLikeModel = new GuessLikeModel();

            Random random = new Random();
            int temp = random.nextInt(50000 - 8000 + 1) + 8000; // 得到8000到50000的随机数
            int tmp[] = new int[3];
            double price = (double) temp / 100;

            guessLikeModel.setPrice(price);
            guessLikeModel.setContent(getResources().getString(R.string.txt_lace_dress));
            for (int j = 0; j < 3; j++) {
                tmp[j] = random.nextInt();
            }
            guessLikeModel.setAuction(tmp[0] % 2 == 0);
            guessLikeModel.setExchange(tmp[1] % 2 == 0);
            guessLikeModel.setSell(tmp[2] % 2 == 0);

            mGuesslikeModels.add(guessLikeModel);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
