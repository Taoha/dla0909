package com.example.imac.giftsbpp.kind.raiders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.imac.giftsbpp.R;
import com.squareup.picasso.Picasso;

/**
 * Created by imac on 16/11/30.
 */

public class KindGridViewAdapter2 extends BaseAdapter {
    private KindGridViewBean bean;
    private Context context;

    public KindGridViewAdapter2(Context context) {
        this.context = context;
    }

    public void setBean(KindGridViewBean bean) {
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean == null ? 0:6;
    }

    @Override
    public Object getItem(int i) {
        return bean != null ? bean.getData().getChannel_groups().get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHodler hodler = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.kind_grid_item,viewGroup,false);
            hodler = new ViewHodler(view);
            view.setTag(hodler);
        }else {
            hodler = (ViewHodler) view.getTag();
        }
        //hodler.nickname.setText(bean.getData().getChannel_groups().get(i).getName());
        Picasso.with(context).load(bean.getData().getChannel_groups().get(1).getChannels().get(i).getCover_image_url()).into(hodler.avatar);

        return view;
    }

    class ViewHodler {
        private ImageView avatar;
        //private TextView nickname;

        public ViewHodler(View view){
            avatar = (ImageView) view.findViewById(R.id.grid_iv);
           // nickname = (TextView) view.findViewById(R.id.grid_tv);


        }
    }
}