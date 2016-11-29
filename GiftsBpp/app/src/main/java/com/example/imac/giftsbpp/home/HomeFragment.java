package com.example.imac.giftsbpp.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.reus.ViewpagerAdapter;
import com.example.imac.giftsbpp.base.BaseFragment;
import com.example.imac.giftsbpp.base.URLValues;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by imac on 16/11/24.
 */
public class HomeFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<TitleBean.DataBean.ChannelsBean> data;
    @Override
    public int setlayout() {
        return R.layout.tab_viewpager;
    }

    @Override
    public void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tb_home_top);
        viewPager = (ViewPager) view.findViewById(R.id.vp_home_top);

    }

    @Override
    public void initData() {

        request();
    }

    //标题的网络获取
    private void request() {
        //创建网络请求
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(URLValues.HOME_TITLE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("数据", response);
                ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getChildFragmentManager());
                //解析
                Gson gson = new Gson();
                TitleBean titleBean = gson.fromJson(response, TitleBean.class);
                data = titleBean.getData().getChannels();
                viewpagerAdapter.setData(data);
                viewPager.setAdapter(viewpagerAdapter);

                tabLayout.setupWithViewPager(viewPager);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        //把网络数据添加到请求队列中
        requestQueue.add(stringRequest);

        }

}
