package com.example.rebuy.business.mine.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.rebuy.R;
import com.example.rebuy.business.mine.adapter.MineOrderAdapter;
import com.example.rebuy.business.mine.fragment.MyOrderWithFinishFragment;
import com.example.rebuy.business.mine.fragment.MyOrderWithoutFinishFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineOrderActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private String[] mTitles = new String[]{"未完成", "已完成"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_order);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mFragments.add(new MyOrderWithoutFinishFragment());
        mFragments.add(new MyOrderWithFinishFragment());

        for (int i = 0; i < mTitles.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab());
        }

        // tabLayout与viewPager关联
        mTabLayout.setupWithViewPager(mViewPager);
        MineOrderAdapter mineOrderAdapter = new MineOrderAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mineOrderAdapter);

        for (int i = 0; i < mTitles.length; i++) {
            mTabLayout.getTabAt(i).setText(mTitles[i]);
        }
    }
}
