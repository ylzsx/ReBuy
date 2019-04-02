package com.example.rebuy.business.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.rebuy.R;
import com.example.rebuy.TitleLayout;
import com.example.rebuy.business.main.adapter.MainPagerAdapter;
import com.example.rebuy.business.main.fragment.AuctionFragment;
import com.example.rebuy.business.main.fragment.HomeFragment;
import com.example.rebuy.business.main.fragment.MessageFragment;
import com.example.rebuy.business.main.fragment.MineFragment;
import com.example.rebuy.utils.FooterBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tlayout)
    TitleLayout mTlayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.llayout_footer)
    LinearLayout mLlayoutFooter;

    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private String[] mTitleArr;
    private int[] mFooterIconArr;
    private FooterBarUtils mFooterBarUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initListener();
    }

    private void initData() {
        // 添加fragment
        mFragments.add(new HomeFragment());
        mFragments.add(new AuctionFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MineFragment());
        mViewpager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), mFragments));

        // 添加底部切换按钮
        mTitleArr = new String[]{"首页", "拍卖", "信息", "我的"};
        mFooterIconArr = new int[]{R.drawable.selector_home, R.drawable.selector_auction, R.drawable.selector_message, R.drawable.selector_mine};
        mFooterBarUtils = new FooterBarUtils();
        mFooterBarUtils.createFooterBar(mLlayoutFooter, mTitleArr, mFooterIconArr);
        // 设置第一个被默认选中
        mFooterBarUtils.setSelected(0);
    }

    private void initListener() {
        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mFooterBarUtils.setSelected(i);
                mTlayout.setTitleName(mTitleArr[i]);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mFooterBarUtils.setOnFooterBarClickListener(new FooterBarUtils.onFooterBarClickListener() {
            @Override
            public void onFooterBarClick(int position) {
                mViewpager.setCurrentItem(position);
            }
        });
    }

}
