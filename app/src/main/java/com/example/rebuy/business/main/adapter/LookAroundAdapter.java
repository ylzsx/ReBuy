package com.example.rebuy.business.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.rebuy.R;
import com.example.rebuy.business.main.activity.GoodsDetailActivity;
import com.example.rebuy.business.main.model.LookAroundModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangZhaoxin.
 * @since 2019/4/7 9:36.
 * email yangzhaoxin@hrsoft.net.
 */

public class LookAroundAdapter extends RecyclerView.Adapter<LookAroundAdapter.ViewHolder> {

    private Context mContext;
    private List<LookAroundModel> mLookAroundModelList = new ArrayList<LookAroundModel>();

    public LookAroundAdapter(Context context, List<LookAroundModel> lookAroundModelList) {
        mContext = context;
        mLookAroundModelList = lookAroundModelList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout mLlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLlayout = (LinearLayout) itemView;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_look_around, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

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
        return mLookAroundModelList.size();
    }

}
