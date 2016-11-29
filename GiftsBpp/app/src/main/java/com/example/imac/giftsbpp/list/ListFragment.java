package com.example.imac.giftsbpp.list;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.base.BaseFragment;
import com.example.imac.giftsbpp.base.URLValues;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imac on 16/11/24.
 */
public class ListFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ListAdapter listAdapter;

    @Override
    public int setlayout() {
        return R.layout.list_viewpager;
    }

    @Override
    public void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.tb_list_top);
        viewPager = (ViewPager) view.findViewById(R.id.vp_list_top);

    }

    @Override
    public void initData() {
        listAdapter = new ListAdapter(getChildFragmentManager());


        request();


    }

    //获取网络数据
    private void request() {
        //创建网络请求
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(URLValues.LIST_TITLE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                ListBean listBean = gson.fromJson(response, ListBean.class);
                listAdapter = new ListAdapter(getChildFragmentManager());
                viewPager.setAdapter(listAdapter);
                listAdapter.setData(listBean);
                tabLayout.setupWithViewPager(viewPager);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

    }

}
