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

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

/**
 * @author YangZhaoxin.
 * @since 2019/4/4 19:30.
 * email yangzhaoxin@hrsoft.net.
 */

public class GuessLikeAdapter extends RecyclerView.Adapter<GuessLikeAdapter.ViewHolder> {

    private Context mContext;
    private List<GuessLikeModel> mGuessLikeModelList;

    public GuessLikeAdapter(List<GuessLikeModel> guesslikeModels) {
        mGuessLikeModelList = guesslikeModels;
        Random random = new Random();
        int temp = random.nextInt(5000 - 800 + 1) + 800;    // 生成800-5000的随机整数
        double price_tmp = (double) temp / 10;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String price = decimalFormat.format(price_tmp);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView mLlayoutGuessLike;
        TextView mTxtPrice;
        TextView mTxtContent;
        ImageView mImgAuction;
        ImageView mImgExchange;
        ImageView mImgSell;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLlayoutGuessLike = (CardView) itemView;
            mTxtPrice = itemView.findViewById(R.id.txt_price);
            mTxtContent = itemView.findViewById(R.id.txt_content);
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
