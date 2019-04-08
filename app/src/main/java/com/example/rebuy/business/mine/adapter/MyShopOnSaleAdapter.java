package com.example.rebuy.business.mine.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rebuy.R;
import com.example.rebuy.business.mine.model.MyShopOnSaleModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangZhaoxin.
 * @since 2019/4/8 15:39.
 * email yangzhaoxin@hrsoft.net.
 */

public class MyShopOnSaleAdapter extends RecyclerView.Adapter<MyShopOnSaleAdapter.ViewHolder> {

    private Context mContext;
    private List<MyShopOnSaleModel> mMyShopOnSaleModels = new ArrayList<MyShopOnSaleModel>();

    public MyShopOnSaleAdapter(Context context, List<MyShopOnSaleModel> myShopOnSaleModels) {
        mContext = context;
        mMyShopOnSaleModels = myShopOnSaleModels;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public MyShopOnSaleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_myshop_onsale, viewGroup ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyShopOnSaleAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mMyShopOnSaleModels.size();
    }

}
