package com.example.imac.giftsbpp.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imac.giftsbpp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by imac on 16/11/29.
 */

public class ReusListAdapter extends RecyclerView.Adapter {
    private Context context;
    private ReusListBean data;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private int headCount = 1;

    public ReusListAdapter(Context context) {
        this.context = context;
    }

    public void setData(ReusListBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public boolean isHeadView(int position) {
        return headCount != 0 && position < headCount;
    }


    @Override
    public int getItemViewType(int position) {
        if (headCount != 0 && position < headCount) {
            return ONE;
        } else {
            return TWO;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case ONE:
                View one = LayoutInflater.from(context).inflate(R.layout.list_item_fragment, parent, false);
                holder = new OneViewHolder(one);
                break;
            case TWO:
                View two = LayoutInflater.from(context).inflate(R.layout.list_fragment_item, parent, false);
                holder = new TwoViewHolder(two);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case ONE:
                OneViewHolder oneViewHolder = (OneViewHolder) holder;
                Picasso.with(context).load(data.getData().getCover_image()).into(oneViewHolder.imageView);
                break;
            case TWO:
                TwoViewHolder twoViewHolder = (TwoViewHolder) holder;
                Picasso.with(context).load(data.getData().getItems().get(position).getCover_image_key()).into(twoViewHolder.iv);
                twoViewHolder.tv1.setText(data.getData().getItems().get(position).getShort_description());
                twoViewHolder.tv2.setText(data.getData().getItems().get(position).getName());
                twoViewHolder.tv3.setText("¥" + data.getData().getItems().get(position).getPrice());
                break;
        }

    }


    @Override
    public int getItemCount() {
        return data != null ? data.getData().getItems().size() : 0;
    }

    class OneViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public OneViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_item_fragment_list);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv1, tv2, tv3;

        public TwoViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_itemtwo_fragment_list);
            tv1 = (TextView) itemView.findViewById(R.id.tv_item_fragment_list_title);
            tv2 = (TextView) itemView.findViewById(R.id.tv_item_fragment_list_msg);
            tv3 = (TextView) itemView.findViewById(R.id.tv_item_fragment_list_money);

        }
    }

}
