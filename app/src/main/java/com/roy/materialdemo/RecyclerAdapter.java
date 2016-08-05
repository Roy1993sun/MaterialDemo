package com.roy.materialdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Roy Sun on 2016/8/4.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private Context             mContext;
    private ArrayList<ItemBean> mDatas;

    public RecyclerAdapter(Context context, ArrayList<ItemBean> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext())
                            .inflate(R.layout.item_card, parent, false);

        ItemViewHolder holder = new ItemViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        final ItemBean itemBean = mDatas.get(position);
        Picasso.with(mContext)
               .load(itemBean.img)
               .placeholder(R.mipmap.ic_launcher)
               .error(android.R.drawable.stat_notify_error)
               .into(holder.mCardImage);

        holder.mCardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("bean",itemBean);
                mContext.startActivity(intent);
                Toast.makeText(mContext, "Clicked" + position, Toast.LENGTH_SHORT)
                     .show();
            }
        });

        holder.mCardText.setText(itemBean.text);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public CardView  mCardView;
        public ImageView mCardImage;
        public TextView  mCardText;

        public ItemViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            mCardImage = (ImageView) itemView.findViewById(R.id.card_image);
            mCardText = (TextView) itemView.findViewById(R.id.card_text);

        }
    }
}
