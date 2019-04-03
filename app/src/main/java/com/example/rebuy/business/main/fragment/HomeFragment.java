package com.example.rebuy.business.main.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rebuy.R;
import com.example.rebuy.business.GlideImageLoder;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.banner)
    Banner mBanner;
    Unbinder unbinder;

    private List<Integer> images = new ArrayList<Integer>();

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
        initListener();
        super.onActivityCreated(savedInstanceState);
    }


    private void initData() {
        initBanner();
    }

    private void initListener() {

    }

    /**
     * 展示轮播图
     */
    private void initBanner() {
        images.add(R.drawable.banner_one);
        images.add(R.drawable.banner_two);
        images.add(R.drawable.banner_three);
        images.add(R.drawable.banner_four);
        images.add(R.drawable.banner_five);

        mBanner.setImageLoader(new GlideImageLoder());
        mBanner.setImages(images);
        //设置banner动画效果
//        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(3000);
        mBanner.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
