package com.example.rebuy.business;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rebuy.R;

/**
 * @author YangZhaoxin.
 * @since 2019/3/31 11:14.
 * email yangzhaoxin@hrsoft.net.
 */

public class TitleLayout extends LinearLayout {

    private TextView mTxtTitleName;
    private ImageView mImgBack;
    private Context mContext;

    public TitleLayout(Context context) {
        super(context);
        initView(context);
    }

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        setValues(attrs);
    }

    /**
     * 初始化控件
     * @param context
     */
    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_title, this);
        mTxtTitleName = view.findViewById(R.id.txt_title_name);
        mImgBack = view.findViewById(R.id.img_back);
        mContext = context;

        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)mContext).finish();
            }
        });
    }

    /**
     * 自定义属性
     * @param attrs
     */
    private void setValues(AttributeSet attrs) {
        TypedArray array = mContext.obtainStyledAttributes(attrs, R.styleable.attrs_title);
        String titleName = array.getString(R.styleable.attrs_title_titleName);
        boolean showBack = array.getBoolean(R.styleable.attrs_title_isShowBack,false);

        mTxtTitleName.setText(titleName);
        if (showBack) {
            mImgBack.setVisibility(VISIBLE);
        } else {
            mImgBack.setVisibility(GONE);
        }

        array.recycle();
    }

    /**
     * 外部设置标题方法
     * @param titleName
     */
    public void setTitleName(String titleName) {
        if (mTxtTitleName != null) {
            mTxtTitleName.setText(titleName);
        }
    }

    /**
     * 外部设置是否显示返回按钮
     * @param showBack
     */
    public void setShowBack(boolean showBack) {
        if (mImgBack != null) {
            if (showBack) {
                mImgBack.setVisibility(VISIBLE);
            } else {
                mImgBack.setVisibility(GONE);
            }
        }
    }
}

