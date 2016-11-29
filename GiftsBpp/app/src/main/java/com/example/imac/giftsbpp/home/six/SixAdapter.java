package com.example.imac.giftsbpp.home.six;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.imac.giftsbpp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imac on 16/11/25.
 */

public class SixAdapter extends BaseAdapter {
    private ArrayList<SixBean> sixBean;
    private Context context;

    public SixAdapter(Context context) {
        this.context = context;
    }

    public void setSixBean(ArrayList<SixBean> sixBean) {
        this.sixBean = sixBean;
    }

    @Override
    public int getCount() {
        return sixBean.get(0).getData().getSecondary_banners().size();
    }

    @Override
    public Object getItem(int i) {
        return sixBean != null?sixBean.get(0).getData().getSecondary_banners():null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHodler hodler = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.choic_squared_item,viewGroup,false);
            hodler = new ViewHodler(view);
            view.setTag(hodler);
        }else {
            hodler = (ViewHodler) view.getTag();
        }
        Picasso.with(context).load(sixBean.get(0).getData().getSecondary_banners().get(i).getImage_url()).into(hodler.imageView);

        return view;
    }
    class ViewHodler{
        private ImageView imageView;

        public ViewHodler(View view){
            imageView = (ImageView) view.findViewById(R.id.imageView);

        }
    }

}
