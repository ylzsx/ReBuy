package com.example.rebuy.business.mine.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.rebuy.R;
import com.example.rebuy.business.mine.adapter.MineShopAdapter;
import com.example.rebuy.business.mine.fragment.MyShopOnSaleFragment;
import com.example.rebuy.business.mine.fragment.MyShopSuccessSaleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineShopActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private String[] mTitles = new String[]{"正在销售", "成功销售"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_shop);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mFragments.add(new MyShopOnSaleFragment());
        mFragments.add(new MyShopSuccessSaleFragment());

        for (int i = 0; i < mTitles.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab());
        }
        mTabLayout.setupWithViewPager(mViewPager);
        MineShopAdapter mineShopAdapter = new MineShopAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mineShopAdapter);

        for (int i = 0; i < mTitles.length; i++) {
            mTabLayout.getTabAt(i).setText(mTitles[i]);
        }
    }
}
