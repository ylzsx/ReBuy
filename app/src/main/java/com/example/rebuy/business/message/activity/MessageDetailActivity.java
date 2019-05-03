package com.example.rebuy.business.message.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rebuy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MessageDetailActivity extends AppCompatActivity {

    public static final String IMG = "img";
    public static final String NAME = "name";
    public static final String TIME = "time";
    public static final String DATE = "date";
    public static final String CONTENT = "content";

    @BindView(R.id.cirimg_portrait)
    CircleImageView mCirimgPortrait;
    @BindView(R.id.txt_name)
    TextView mTxtName;
    @BindView(R.id.txt_date)
    TextView mTxtDate;
    @BindView(R.id.txt_time)
    TextView mTxtTime;
    @BindView(R.id.txt_application_content)
    TextView mTxtApplicationContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        // 设置从上一个界面传递的数据
        Intent intent = getIntent();
        int img = intent.getIntExtra(IMG, R.drawable.pic_order_finish);
        Glide.with(this).load(img).into(mCirimgPortrait);
        mTxtName.setText(intent.getStringExtra(NAME));
        mTxtTime.setText(intent.getStringExtra(TIME));
        mTxtDate.setText(intent.getStringExtra(DATE));
        mTxtApplicationContent.setText(intent.getStringExtra(CONTENT));
    }
}
