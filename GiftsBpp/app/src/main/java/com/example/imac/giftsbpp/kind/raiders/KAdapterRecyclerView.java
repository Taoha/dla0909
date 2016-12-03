package com.example.imac.giftsbpp.kind.raiders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imac.giftsbpp.R;
import com.squareup.picasso.Picasso;

/**
 * Created by imac on 16/11/30.
 */

public class KAdapterRecyclerView extends RecyclerView.Adapter<KAdapterRecyclerView.RecyclerHodler>{
    private KRecyclerBean data;
    private Context context;

    public KAdapterRecyclerView(Context context) {
        this.context = context;
    }

    public void setData(KRecyclerBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public KAdapterRecyclerView.RecyclerHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.kind_raiders_fragment_item,parent,false);
        RecyclerHodler hodler = new RecyclerHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(KAdapterRecyclerView.RecyclerHodler holder, int position) {
        Picasso.with(context).load(data.getData().getColumns().get(position).getBanner_image_url()).into(holder.imageView);
        holder.tv1.setText(data.getData().getColumns().get(position).getTitle());
        holder.tv2.setText(data.getData().getColumns().get(position).getAuthor());

    }

    @Override
    public int getItemCount() {
        return data != null ? data.getData().getColumns().size() : 0;
    }

    public class RecyclerHodler extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tv1, tv2;
        public RecyclerHodler(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.krft_iv);
            tv1 = (TextView) itemView.findViewById(R.id.krft_tv_two);
            tv2 = (TextView) itemView.findViewById(R.id.krft_tv_three);
        }
    }
}
