package com.example.imac.giftsbpp.reus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.home.choice.HomeChoiceBean;
import com.squareup.picasso.Picasso;

/**
 * Created by imac on 16/11/25.
 */

public class ReusViewAdapter extends BaseAdapter {
    private ReusBean reusBean;
    private Context context;

    public ReusViewAdapter(Context context) {
        this.context = context;
    }

    public void setReusBean(ReusBean reusBean) {
        this.reusBean = reusBean;
    }

    @Override
    public int getCount() {
        return reusBean!=null&& reusBean.getData().getItems().size()>0 ? reusBean.getData().getItems().size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return reusBean != null? reusBean.getData().getItems().get(i) :null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHodler hodler = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.reus_item,viewGroup,false);
            hodler = new ViewHodler(view);
            view.setTag(hodler);
        }else {
            hodler= (ViewHodler) view.getTag();
        }
        if (reusBean.getData().getItems().get(i).getContent_type()!=1){
                     hodler.texta.setText(reusBean.getData().getItems().get(i).getColumn().getTitle());

        }
        Picasso.with(context).load(reusBean.getData().getItems().get(i).getAuthor().getAvatar_url()).into(hodler.avatar);
        Picasso.with(context).load(reusBean.getData().getItems().get(i).getCover_image_url()).into(hodler.cover_image_url);
        hodler.nickname.setText(reusBean.getData().getItems().get(i).getAuthor().getNickname());
        hodler.introduction.setText(reusBean.getData().getItems().get(i).getAuthor().getIntroduction());
        hodler.title.setText(reusBean.getData().getItems().get(i).getTitle());
        hodler.introduction2.setText(reusBean.getData().getItems().get(i).getIntroduction());
        return view;
    }
    class ViewHodler{
        private ImageView avatar;
        private TextView nickname,introduction;
        private ImageView cover_image_url;
        private TextView title,introduction2,texta;

        public ViewHodler(View view){
            avatar = (ImageView) view.findViewById(R.id.avatar);
            nickname = (TextView) view.findViewById(R.id.nickname);
            introduction = (TextView) view.findViewById(R.id.introduction);
            cover_image_url = (ImageView) view.findViewById(R.id.cover_image_url);
            title = (TextView) view.findViewById(R.id.title_z);
            introduction2 = (TextView) view.findViewById(R.id.introduction2);
            texta = (TextView) view.findViewById(R.id.text_a);
        }
    }
}
