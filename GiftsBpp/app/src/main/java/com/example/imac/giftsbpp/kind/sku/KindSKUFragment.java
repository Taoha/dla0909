package com.example.imac.giftsbpp.kind.sku;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.base.BaseFragment;
import com.example.imac.giftsbpp.base.URLValues;
import com.google.gson.Gson;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by imac on 16/11/30.
 */

public class KindSKUFragment extends BaseFragment {
    private ListView lvLeft;
    private StickyListHeadersListView lvRight;

    @Override
    public int setlayout() {
        return R.layout.kind_sku_fragment;
    }

    @Override
    public void initView(View view) {
        lvLeft = (ListView) view.findViewById(R.id.lv_left_single);
        lvRight = (StickyListHeadersListView) view.findViewById(R.id.lv_right);


    }

    @Override
    public void initData() {

        //获取分类单品左边的数据
        inif();
    }


    private void inif() {
        RequestQueue mRequestQueue = Volley.newRequestQueue(getContext());
        StringRequest mStringRequest = new StringRequest(URLValues.SKU_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                LeftAdapter adapter = new LeftAdapter(getContext());
                Gson gson = new Gson();
                SkuBean skubean = gson.fromJson(response, SkuBean.class);
                adapter.setBean(skubean);
                lvLeft.setAdapter(adapter);


                RightAdapter rightadapter = new RightAdapter(getContext());
                rightadapter.setRightBean(skubean);
                lvRight.setAdapter(rightadapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(mStringRequest);

        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lvRight.setSelection(i);

            }
        });
        lvRight.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                lvLeft.smoothScrollToPositionFromTop(i,0);

            }
        });
    }


}
