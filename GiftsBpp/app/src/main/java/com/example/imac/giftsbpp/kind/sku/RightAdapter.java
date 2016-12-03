package com.example.imac.giftsbpp.kind.sku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.base.URLValues;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by dllo on 16/11/22.
 */
public class RightAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private SkuBean rightBean;
    private Context mContext;

    public void setRightBean(SkuBean rightBean) {
        this.rightBean = rightBean;
        notifyDataSetChanged();
    }

    public RightAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return rightBean != null ? rightBean.getData().getCategories().size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return rightBean != null ? rightBean.getData().getCategories().get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BodyViewHolder bodyViewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).
                    inflate(R.layout.item_right, viewGroup, false);
            bodyViewHolder = new BodyViewHolder(view);

            view.setTag(bodyViewHolder);
        } else {

            bodyViewHolder = (BodyViewHolder) view.getTag();
        }

        SkuRightGridAdapter skuRightGridAdapter = new SkuRightGridAdapter(mContext);
        skuRightGridAdapter.setSkuBean(rightBean);
        skuRightGridAdapter.setPosition(i);
        bodyViewHolder.gridView.setAdapter(skuRightGridAdapter);


        return view;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeadViewHolder headViewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_right_head, parent, false);
            headViewHolder = new HeadViewHolder(convertView);
            convertView.setTag(headViewHolder);
        } else {
            headViewHolder = (HeadViewHolder) convertView.getTag();
        }
        headViewHolder.tvHead.setText(rightBean.getData().getCategories().get(position).getName());
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return position;
    }

    class BodyViewHolder {
        private GridView gridView;


        public BodyViewHolder(View view) {
            gridView = (GridView) view.findViewById(R.id.grud_right);

        }
    }

    class HeadViewHolder {

        private TextView tvHead;

        public HeadViewHolder(View convertView) {
            tvHead = (TextView) convertView.findViewById(R.id.tv_right_head);


        }
    }
}
