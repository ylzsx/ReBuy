package com.example.rebuy.business.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

import com.example.rebuy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {


    @BindView(R.id.llayout_splash)
    LinearLayout mLlayoutSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initAnim();
    }

    public void initAnim() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animation);
        mLlayoutSplash.setLayoutAnimation(layoutAnimationController);
        mLlayoutSplash.startLayoutAnimation();
        mLlayoutSplash.setLayoutAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
