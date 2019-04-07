package com.example.rebuy.business.main.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.rebuy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsDetailActivity extends AppCompatActivity {

    @BindView(R.id.img_heart)
    ImageView mImgHeart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_heart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_heart:
                if (view.isSelected()) {
                    view.setSelected(false);
                } else {
                    view.setSelected(true);
                }
                break;
        }
    }
}
