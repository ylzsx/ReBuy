package com.example.rebuy.business.mine.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rebuy.R;
import com.example.rebuy.business.mine.model.MyOrderWithFinishModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangZhaoxin.
 * @since 2019/4/8 16:36.
 * email yangzhaoxin@hrsoft.net.
 */

public class MyOrderWithFinishAdapter extends RecyclerView.Adapter<MyOrderWithFinishAdapter.ViewHolder> {

    private Context mContext;
    private List<MyOrderWithFinishModel> mMyOrderWithFinishModels = new ArrayList<>();

    public MyOrderWithFinishAdapter(Context context, List<MyOrderWithFinishModel> myOrderWithFinishModels) {
        mContext = context;
        mMyOrderWithFinishModels = myOrderWithFinishModels;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_myorder_with_finish, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mMyOrderWithFinishModels.size();
    }

}
