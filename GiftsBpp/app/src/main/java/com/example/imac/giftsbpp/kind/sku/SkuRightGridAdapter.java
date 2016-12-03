package com.example.imac.giftsbpp.kind.sku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imac.giftsbpp.R;
import com.squareup.picasso.Picasso;

/**
 * Created by imac on 16/12/1.
 */

public class SkuRightGridAdapter extends BaseAdapter {
    private SkuBean itemskuBean;
    private Context context;
    private int position;

    public SkuRightGridAdapter(Context context) {
        this.context = context;
    }

    public void setSkuBean(SkuBean skuBean) {
        this.itemskuBean = skuBean;
        notifyDataSetChanged();
    }

    public void setPosition(int position) {
        this.position = position;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return itemskuBean != null ? itemskuBean.getData().getCategories().get(position).getSubcategories().size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return itemskuBean != null ? itemskuBean.getData().getCategories().get(position).getSubcategories().get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_right_item,viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(itemskuBean.getData().getCategories().get(position).getSubcategories().get(i).getName());
        Picasso.with(context).load(itemskuBean.getData().getCategories().get(position).getSubcategories().get(i).getIcon_url()).into(viewHolder.imageView);
        return view;
    }
    class ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public ViewHolder (View view){
            imageView = (ImageView) view.findViewById(R.id.iv_single_left_photo);
            textView = (TextView) view.findViewById(R.id.tv_single_left_name);
        }
    }
}
