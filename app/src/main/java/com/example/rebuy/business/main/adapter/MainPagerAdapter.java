package com.example.rebuy.business.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangZhaoxin.
 * @since 2019/4/1 23:38.
 * email yangzhaoxin@hrsoft.net.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments = new ArrayList<Fragment>();

    public MainPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
