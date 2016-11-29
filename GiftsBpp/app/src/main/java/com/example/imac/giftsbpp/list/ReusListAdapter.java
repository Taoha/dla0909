package com.example.imac.giftsbpp.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by imac on 16/11/29.
 */

public class ReusListAdapter extends RecyclerView.Adapter{
    private Context context;
    private ListBean data;
    private static final int ONE = 1;
    private static final int TWO = 2;
    
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class OneViewHolder extends RecyclerView.ViewHolder{
        public OneViewHolder(View itemView) {
            super(itemView);
        }
    }
    class TwoViewHolder extends RecyclerView.ViewHolder{
        public TwoViewHolder(View itemView) {
            super(itemView);
        }
    }

}
