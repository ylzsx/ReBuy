package com.example.rebuy.business.main.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.rebuy.R;
import com.example.rebuy.business.mine.activity.MineCollectionActivity;
import com.example.rebuy.business.mine.activity.MineOrderActivity;
import com.example.rebuy.business.mine.activity.MineSettingActivity;
import com.example.rebuy.business.mine.activity.MineShopActivity;
import com.example.rebuy.business.mine.activity.PersonalInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {


    @BindView(R.id.llayout_personal_info)
    LinearLayout mLlayoutPersonalInfo;
    @BindView(R.id.llayout_shop)
    LinearLayout mLlayoutShop;
    @BindView(R.id.llayout_order)
    LinearLayout mLlayoutOrder;
    @BindView(R.id.llayout_collection)
    LinearLayout mLlayoutCollection;
    @BindView(R.id.llayout_setting)
    LinearLayout mLlayoutSetting;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.llayout_personal_info, R.id.llayout_shop, R.id.llayout_order, R.id.llayout_collection, R.id.llayout_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llayout_personal_info:
                Intent intent = new Intent(this.getActivity(), PersonalInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.llayout_shop:
                Intent intent1 = new Intent(this.getActivity(), MineShopActivity.class);
                startActivity(intent1);
                break;
            case R.id.llayout_order:
                Intent intent2 = new Intent(this.getActivity(), MineOrderActivity.class);
                startActivity(intent2);
                break;
            case R.id.llayout_collection:
                Intent intent3 = new Intent(this.getActivity(), MineCollectionActivity.class);
                startActivity(intent3);
                break;
            case R.id.llayout_setting:
                Intent intent4 = new Intent(this.getActivity(), MineSettingActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
