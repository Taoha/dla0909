package com.example.imac.giftsbpp.reus;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.base.BaseFragment;
import com.example.imac.giftsbpp.volley.NetHelper;
import com.example.imac.giftsbpp.volley.NetListener;
import com.google.gson.Gson;

/**
 * Created by imac on 16/11/24.
 */
public class ReusFragment extends BaseFragment {
    private ListView listView;
    private String path;

    @Override
    public int setlayout() {
        return R.layout.fragment_reus;
    }

    @Override
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.reus_lv);

    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        Log.d("少死机", getArguments()+"");
        String msg = bundle.get("key").toString();
        path = "http://api.liwushuo.com/v2/channels/" +
                msg +
                "/items_v2?gender=1&limit=20&offset=0&generation=2";

        request();

    }


    public static ReusFragment newInstance(int pos) {

        Bundle args = new Bundle();
        String message = ViewpagerAdapter.getMessage(pos);
        args.putString("key", message);
        ReusFragment fragment = new ReusFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void request() {
        NetHelper.MyRequest(path, ReusBean.class, new NetListener<ReusBean>() {
            @Override
            public void successListener(ReusBean response) {
                ReusViewAdapter reusViewAdapter = new ReusViewAdapter(getContext());
                reusViewAdapter.setReusBean(response);
                listView.setAdapter(reusViewAdapter);

            }

            @Override
            public void errorListener(VolleyError error) {

            }
        });
        //创建网络请求
//        RequestQueue mRequestQueue = Volley.newRequestQueue(getContext());
//        StringRequest mStringRequest = new StringRequest(path, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.d("大傻逼", response);
//
//                Gson gson = new Gson();
//                ReusBean reusBean = gson.fromJson(response, ReusBean.class);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        //把网络请求添加到请求队列中
//        mRequestQueue.add(mStringRequest);

    }
}
