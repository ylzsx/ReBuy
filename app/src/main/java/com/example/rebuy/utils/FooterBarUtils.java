package com.example.rebuy.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rebuy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangZhaoxin.
 * @since 2019/4/1 23:46.
 * email yangzhaoxin@hrsoft.net.
 */

public class FooterBarUtils {

    private Context mContext;
    private List<ViewHolder> mViewHolders = new ArrayList<ViewHolder>();
    private onFooterBarClickListener mOnFooterBarClickListener;

    class ViewHolder {
        LinearLayout mLinearLayout;
        ImageView imgItemIcon;
        TextView txtItemTitle;

        public ViewHolder(LinearLayout linearLayout, ImageView imgItemIcon, TextView txtItemTitle) {
            this.mLinearLayout = linearLayout;
            this.imgItemIcon = imgItemIcon;
            this.txtItemTitle = txtItemTitle;
        }
    }

    public interface onFooterBarClickListener {
        public void onFooterBarClick(int position);
    }

    public void setOnFooterBarClickListener(onFooterBarClickListener footerBarClickListener) {
        mOnFooterBarClickListener = footerBarClickListener;
    }

    /**
     * 创建FooterBar
     * @param container
     * @param titleArr
     * @param footerIconArr
     */
    public void createFooterBar(LinearLayout container, String[] titleArr, int[] footerIconArr) {
        mContext = container.getContext();
        for (int i = 0; i < titleArr.length; i++) {
            LinearLayout linearLayout = (LinearLayout) View.inflate(mContext, R.layout.item_footer, null);
            ImageView imageView = linearLayout.findViewById(R.id.img_item_icon);
            TextView textView = linearLayout.findViewById(R.id.txt_item_title);
            ViewHolder viewHolder = new ViewHolder(linearLayout, imageView, textView);

            viewHolder.txtItemTitle.setText(titleArr[i]);
            viewHolder.imgItemIcon.setImageResource(footerIconArr[i]);

            // 设置点击事件
            final int position = i;
            viewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnFooterBarClickListener.onFooterBarClick(position);
                }
            });

            // 设置平分屏幕
            int width = 0;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
            params.weight = 1;

            container.addView(linearLayout, params);

            // 将TextView保存起来
            mViewHolders.add(viewHolder);
        }
    }

    /**
     * 设置被选中样式
     * @param position
     */
    public void setSelected(int position) {
        for (ViewHolder viewHolder : mViewHolders) {
            viewHolder.imgItemIcon.setSelected(false);
            viewHolder.txtItemTitle.setTextColor(ContextCompat.getColor(mContext, R.color.grey));
        }
        mViewHolders.get(position).imgItemIcon.setSelected(true);
        mViewHolders.get(position).txtItemTitle.setTextColor(ContextCompat.getColor(mContext, R.color.yellow));
    }

}
