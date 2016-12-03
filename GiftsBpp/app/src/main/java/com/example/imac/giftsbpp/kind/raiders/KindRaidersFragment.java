package com.example.imac.giftsbpp.kind.raiders;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.base.BaseFragment;
import com.example.imac.giftsbpp.base.URLValues;
import com.example.imac.giftsbpp.volley.NetHelper;
import com.example.imac.giftsbpp.volley.NetListener;
import com.google.gson.Gson;

/**
 * Created by imac on 16/11/30.
 */

public class KindRaidersFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private GridView gridViewone,gridViewtwo,gridViewthree;
    private KindGridViewAdapter kindGridViewAdapter;
    private KindGridViewAdapter2 kindGridViewAdapter2;
    private KindGridViewAdapter3 kindGridViewAdapter3;

    //private KindGridViewBean kindGridViewBean;


    @Override
    public int setlayout() {
        return R.layout.kind_raiders_fragment;
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.kind_raiders_rv);
        gridViewone = (GridView) view.findViewById(R.id.grud_view1);
        gridViewtwo = (GridView) view.findViewById(R.id.grud_view2);
        gridViewthree = (GridView) view.findViewById(R.id.grud_view3);

    }

    @Override
    public void initData() {

        request();
        MyGridView();
        kindGridViewAdapter = new KindGridViewAdapter(getContext());
        kindGridViewAdapter2 = new KindGridViewAdapter2(getContext());
        kindGridViewAdapter3 = new KindGridViewAdapter3(getContext());


    }

    private void MyGridView() {
        NetHelper.MyRequest(URLValues.KIND_GRID, KindGridViewBean.class, new NetListener<KindGridViewBean>() {
            @Override
            public void successListener(KindGridViewBean response) {
                kindGridViewAdapter.setBean(response);
                kindGridViewAdapter2.setBean(response);
                kindGridViewAdapter3.setBean(response);
                gridViewone.setAdapter(kindGridViewAdapter);
                gridViewtwo.setAdapter(kindGridViewAdapter2);
                gridViewthree.setAdapter(kindGridViewAdapter3);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

//        RequestQueue reqmuestQueue = Volley.newRequestQueue(getContext());
//        StringRequest stringRequest = new StringRequest(URLValues.KIND_GRID, new Response.Listener<String>() {
//
//
//
//
//            @Override
//            public void onResponse(String response) {
//
//                Gson gson = new Gson();
//                kindGridViewBean = gson.fromJson(response,KindGridViewBean.class);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        reqmuestQueue.add(stringRequest);
//
  }

    private void request() {

        NetHelper.MyRequest(URLValues.KIND_RECY, KRecyclerBean.class, new NetListener<KRecyclerBean>() {
            @Override
            public void successListener(KRecyclerBean response) {
                KAdapterRecyclerView adapter = new KAdapterRecyclerView(getContext());
                adapter.setData(response);
                GridLayoutManager manager = new GridLayoutManager(getContext(),3, LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });

//        RequestQueue mReqmuestQueue = Volley.newRequestQueue(getContext());
//        StringRequest mStringRequest = new StringRequest(URLValues.KIND_RECY, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Gson gson = new Gson();
//                KRecyclerBean bean = gson.fromJson(response,KRecyclerBean.class);
//                adapter.setData(bean);
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        mReqmuestQueue.add(mStringRequest);
    }
}
