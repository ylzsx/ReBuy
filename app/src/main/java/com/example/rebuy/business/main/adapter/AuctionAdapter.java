package com.example.rebuy.business.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rebuy.R;
import com.example.rebuy.business.main.activity.GoodsDetailActivity;
import com.example.rebuy.business.main.model.AuctionModel;

import java.util.List;

/**
 * @author YangZhaoxin.
 * @since 2019/4/4 23:27.
 * email yangzhaoxin@hrsoft.net.
 */

public class AuctionAdapter extends RecyclerView.Adapter<AuctionAdapter.ViewHolder> {

    private Context mContext;
    private List<AuctionModel> mAuctionModelList;

    public AuctionAdapter(Context context, List<AuctionModel> auctionModelList) {
        mContext = context;
        mAuctionModelList = auctionModelList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout mLlayout;
        TextView mTxtContent;
        TextView mTxtPrice;
        TextView mTxtDeadline;
        TextView mTxtPersonNum;
        ImageView mImgHeart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLlayout = (LinearLayout) itemView;
            mTxtContent = itemView.findViewById(R.id.txt_content);
            mTxtPrice = itemView.findViewById(R.id.txt_price);
            mTxtDeadline = itemView.findViewById(R.id.txt_deadline);
            mTxtPersonNum = itemView.findViewById(R.id.txt_person_num);
            mImgHeart = itemView.findViewById(R.id.img_heart);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_auction, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final AuctionModel auctionModel = mAuctionModelList.get(i);
        viewHolder.mTxtContent.setText(auctionModel.getContent());
        viewHolder.mTxtPrice.setText(String.valueOf(auctionModel.getPrice()));
        viewHolder.mTxtDeadline.setText(auctionModel.getDeadline());
        viewHolder.mTxtPersonNum.setText(String.valueOf(auctionModel.getPersonNum()));
        // 解决条目混乱问题
        viewHolder.mImgHeart.setSelected(auctionModel.isFavorite());

        viewHolder.mImgHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.isSelected()) {
                    v.setSelected(false);
                    auctionModel.setFavorite(false);
                } else {
                    v.setSelected(true);
                    auctionModel.setFavorite(true);
                }
            }
        });

        viewHolder.mLlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAuctionModelList.size();
    }

}
