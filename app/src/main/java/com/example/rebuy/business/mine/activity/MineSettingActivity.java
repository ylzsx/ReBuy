package com.example.rebuy.business.mine.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.rebuy.R;
import com.example.rebuy.business.account.activity.LoginActivity;
import com.example.rebuy.commom.CacheKey;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineSettingActivity extends AppCompatActivity {

    @BindView(R.id.btn_logout)
    Button mBtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_setting);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_logout:
                SharedPreferences.Editor editor = getSharedPreferences(CacheKey.FILE_NAME, MODE_PRIVATE).edit();
                editor.putString(CacheKey.TOKEN, "");
                editor.apply();
                Intent intent = new Intent(MineSettingActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
    }
}
