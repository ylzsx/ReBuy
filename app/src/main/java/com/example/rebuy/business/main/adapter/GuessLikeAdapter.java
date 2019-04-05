package com.example.rebuy.business.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rebuy.R;
import com.example.rebuy.business.main.model.GuessLikeModel;

import java.util.List;

/**
 * @author YangZhaoxin.
 * @since 2019/4/4 19:30.
 * email yangzhaoxin@hrsoft.net.
 */

public class GuessLikeAdapter extends RecyclerView.Adapter<GuessLikeAdapter.ViewHolder> {

    private Context mContext;
    private List<GuessLikeModel> mGuessLikeModelList;

    public GuessLikeAdapter(Context context, List<GuessLikeModel> guessLikeModelList) {
        mContext = context;
        mGuessLikeModelList = guessLikeModelList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView mLlayoutGuessLike;
        TextView mTxtPrice;
        TextView mTxtContent;
        ImageView mImgHeart;
        ImageView mImgAuction;
        ImageView mImgExchange;
        ImageView mImgSell;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLlayoutGuessLike = (CardView) itemView;
            mTxtPrice = itemView.findViewById(R.id.txt_price);
            mTxtContent = itemView.findViewById(R.id.txt_content);
            mImgHeart = itemView.findViewById(R.id.img_heart);
            mImgAuction = itemView.findViewById(R.id.img_type_auction);
            mImgExchange = itemView.findViewById(R.id.img_type_exchange);
            mImgSell = itemView.findViewById(R.id.img_type_sell);
        }
    }

    @NonNull
    @Override
    public GuessLikeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_guess_like, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mLlayoutGuessLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点到了我", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.mImgHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.isSelected()) {
                    v.setSelected(false);
                } else {
                    v.setSelected(true);
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GuessLikeAdapter.ViewHolder viewHolder, int i) {
        GuessLikeModel guessLikeModel = mGuessLikeModelList.get(i);
        viewHolder.mTxtPrice.setText(String.valueOf(guessLikeModel.getPrice()));
        viewHolder.mTxtContent.setText(guessLikeModel.getContent());

        // 判断三个标签是否要展示
        if (guessLikeModel.isAuction()) {
            viewHolder.mImgAuction.setVisibility(View.VISIBLE);
        } else {
            viewHolder.mImgAuction.setVisibility(View.GONE);
        }
        if (guessLikeModel.isExchange()) {
            viewHolder.mImgExchange.setVisibility(View.VISIBLE);
        } else {
            viewHolder.mImgExchange.setVisibility(View.GONE);
        }
        if (guessLikeModel.isSell()) {
            viewHolder.mImgSell.setVisibility(View.VISIBLE);
        } else {
            viewHolder.mImgSell.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mGuessLikeModelList.size();
    }

}
