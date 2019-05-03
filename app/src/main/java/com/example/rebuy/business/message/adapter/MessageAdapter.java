package com.example.rebuy.business.message.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rebuy.R;
import com.example.rebuy.business.message.activity.MessageDetailActivity;
import com.example.rebuy.business.message.model.MessageModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author YangZhaoxin.
 * @since 2019/4/5 18:30.
 * email yangzhaoxin@hrsoft.net.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private Context mContext;
    private List<MessageModel> mMessageModelList = new ArrayList<MessageModel>();

    public MessageAdapter(Context context, List<MessageModel> messageModelList) {
        mContext = context;
        mMessageModelList = messageModelList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout mLlayout;
        CircleImageView mImgPortrait;
        TextView mTxtName;
        TextView mTxtContent;
        TextView mTxtData;
        TextView mTxtTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLlayout = (LinearLayout) itemView;
            mImgPortrait = itemView.findViewById(R.id.cirimg_portrait);
            mTxtName = itemView.findViewById(R.id.txt_name);
            mTxtContent = itemView.findViewById(R.id.txt_content);
            mTxtData = itemView.findViewById(R.id.txt_data);
            mTxtTime = itemView.findViewById(R.id.txt_time);
        }
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_message, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder viewHolder, int i) {
        final MessageModel messageModel = mMessageModelList.get(i);
        viewHolder.mImgPortrait.setImageResource(messageModel.getPortrait());
        viewHolder.mTxtName.setText(messageModel.getName());
        viewHolder.mTxtContent.setText(messageModel.getContent());
        viewHolder.mTxtData.setText(messageModel.getDate());
        viewHolder.mTxtTime.setText(messageModel.getTime());
        viewHolder.mLlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MessageDetailActivity.class);
                intent.putExtra(MessageDetailActivity.IMG, messageModel.getPortrait());
                intent.putExtra(MessageDetailActivity.NAME, messageModel.getName());
                intent.putExtra(MessageDetailActivity.TIME, messageModel.getTime());
                intent.putExtra(MessageDetailActivity.DATE, messageModel.getDate());
                intent.putExtra(MessageDetailActivity.CONTENT, messageModel.getContent());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMessageModelList.size();
    }

}
