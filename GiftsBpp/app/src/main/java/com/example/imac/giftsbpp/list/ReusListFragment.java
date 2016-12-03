package com.example.imac.giftsbpp.list;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.base.BaseFragment;
import com.example.imac.giftsbpp.base.URLValues;
import com.example.imac.giftsbpp.reus.ReusBean;
import com.example.imac.giftsbpp.reus.ReusFragment;
import com.example.imac.giftsbpp.reus.ViewpagerAdapter;
import com.example.imac.giftsbpp.volley.NetHelper;
import com.example.imac.giftsbpp.volley.NetListener;
import com.google.gson.Gson;

/**
 * Created by imac on 16/11/29.
 */

public class ReusListFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private String path;

    @Override
    public int setlayout() {
        return R.layout.list_reus_fragment;
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_list_use);

    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        Log.d("傻逼数据快出来", getArguments() + "");
        String msg = bundle.get("key").toString();
        path = "http://api.liwushuo.com/v2/ranks_v3/ranks/" +
                msg +
                "?limit=20&offset=0";
        request();


    }

    public static ReusListFragment newInstance(int pos) {

        Bundle args = new Bundle();
        String message = ListAdapter.getMessage(pos);
        args.putString("key", message);
        ReusListFragment fragment = new ReusListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void request() {
        NetHelper.MyRequest(path, ReusListBean.class, new NetListener<ReusListBean>() {
            @Override
            public void successListener(ReusListBean response) {
                final ReusListAdapter adapter = new ReusListAdapter(getContext());
                adapter.setData(response);
                final GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
                manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return (adapter.isHeadView(position) ? manager.getSpanCount() : 1);
                    }
                });
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
//        RequestQueue mRequestQueue = Volley.newRequestQueue(getContext());
//        StringRequest mStringRequest = new StringRequest(path, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Gson gson = new Gson();
//                ReusListBean bean = gson.fromJson(response, ReusListBean.class);
//
//
//
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        mRequestQueue.add(mStringRequest);


    }
}
