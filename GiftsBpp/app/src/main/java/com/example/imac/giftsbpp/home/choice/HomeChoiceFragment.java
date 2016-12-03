package com.example.imac.giftsbpp.home.choice;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.base.BaseFragment;
import com.example.imac.giftsbpp.base.URLValues;
import com.example.imac.giftsbpp.home.six.SixAdapter;
import com.example.imac.giftsbpp.home.six.SixBean;
import com.example.imac.giftsbpp.volley.NetHelper;
import com.example.imac.giftsbpp.volley.NetListener;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imac on 16/11/24.
 */
public class HomeChoiceFragment extends BaseFragment {
    private ListView choice_lv;
    private GridView mGridView;
    private ArrayList<SixBean> dada;
    private Banner banner;
    private RequestQueue mRequestQueue;

    @Override
    public int setlayout() {
        return R.layout.fragment_choice;
    }

    @Override
    public void initView(View view) {
        choice_lv = (ListView) view.findViewById(R.id.choice_lv);
       // mGridView = (GridView) view.findViewById(R.id.grud_view);
        //banner = (com.youth.banner.BannerImageLoader) view.findViewById(R.id.choic_banner);

    }

    @Override
    public void initData() {
        mRequestQueue = Volley.newRequestQueue(getContext());

        bannern();
        request();
        gridView();

        dada = new ArrayList<>();
    }

   private void bannern() {
        final View bannerView = LayoutInflater.from(getContext()).inflate(R.layout.my_banner_shabi,null);
        banner = (Banner) bannerView.findViewById(R.id.choic_banner);
       StringRequest mStringRequest = new StringRequest(URLValues.HOME_BANNER,  new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
                Gson gson = new Gson();
                List<String> databanner = new ArrayList<>();

                Bannerbean bannerBean = gson.fromJson(response,Bannerbean.class);
               for (int i = 0; i < bannerBean.getData().getBanners().size(); i++) {
                   databanner.add(bannerBean.getData().getBanners().get(i).getImage_url());

                }
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                banner.setImageLoader(new BannerImageLoader());
                banner.setImages(databanner);
                banner.setBannerAnimation(Transformer.DepthPage);
                banner.isAutoPlay(true);
                banner.setDelayTime(2000);
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.start();
                choice_lv.addHeaderView(bannerView);



           }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(mStringRequest);

    }


    //获取精选的网络数据
    private void request() {
        NetHelper.MyRequest(URLValues.HOME_CHOICE, HomeChoiceBean.class, new NetListener<HomeChoiceBean>() {
            @Override
            public void successListener(HomeChoiceBean response) {
                HomeChoiceListViewAdapter  HCadapter = new HomeChoiceListViewAdapter(getContext());
                HCadapter.setHomeChoiceBeen(response);
                choice_lv.setAdapter(HCadapter);


            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
        //创建网络请求
//        StringRequest mStringRequest = new StringRequest(URLValues.HOME_CHOICE, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Gson gson = new Gson();
//                HomeChoiceBean homeChoiceBean = gson.fromJson(response,HomeChoiceBean.class);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        //把网络数据添加到请求队列中
//        mRequestQueue.add(mStringRequest);

    }
    private void gridView() {
        final View handView = LayoutInflater.from(getContext()).inflate(R.layout.choic_squared,null);
        mGridView = (GridView) handView.findViewById(R.id.grud_view);
        StringRequest mStringRequest = new StringRequest(URLValues.HOME_SIX, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                SixAdapter sixAdapter = new SixAdapter(getContext());
                Gson gson = new Gson();
                SixBean sixBean = gson.fromJson(response,SixBean.class);
                sixAdapter.setSixBean(dada);
                dada.add(sixBean);
                mGridView.setAdapter(sixAdapter);
                choice_lv.addHeaderView(handView);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(mStringRequest);

    }
}


