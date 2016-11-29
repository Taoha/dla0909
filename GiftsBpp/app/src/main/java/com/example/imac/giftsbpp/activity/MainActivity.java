package com.example.imac.giftsbpp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.example.imac.giftsbpp.My.MyFragment;
import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.base.BaseActivity;
import com.example.imac.giftsbpp.home.HomeFragment;
import com.example.imac.giftsbpp.kind.KindFragment;
import com.example.imac.giftsbpp.list.ListFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton Rbtn_home, Rbtn_hotspot,
            Rbtn_classify, Rbtn_me;


    @Override
    public int setlayou() {
        return R.layout.activity_main;

    }

    @Override
    public void initView() {
//        mRbtn_home = (RadioButton) findViewById(R.id.main_Group);
       Rbtn_home = (RadioButton) findViewById(R.id.Rbtn_home);
        Rbtn_home.setOnClickListener(this);
        Rbtn_hotspot = (RadioButton) findViewById(R.id.Rbtn_hotspot);
        Rbtn_hotspot.setOnClickListener(this);
        Rbtn_classify = (RadioButton) findViewById(R.id.Rbtn_classify);
        Rbtn_classify.setOnClickListener(this);
        Rbtn_me = (RadioButton) findViewById(R.id.Rbtn_me);
        Rbtn_me.setOnClickListener(this);
//        replace(new HomeFragment());
        Rbtn_home.setChecked(true);


    }


    @Override
    public void initData() {

        replace(new HomeFragment());

    }
    public void replace(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.replace, fragment);
        transaction.commit();
    }


    @Override
    public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();


        switch (view.getId()) {
            case R.id.Rbtn_home:
                transaction.replace(R.id.replace, new HomeFragment());
                break;
            case R.id.Rbtn_hotspot:
                transaction.replace(R.id.replace, new ListFragment());
                break;
            case R.id.Rbtn_classify:
                transaction.replace(R.id.replace, new KindFragment());
                break;
            case R.id.Rbtn_me:
                transaction.replace(R.id.replace, new MyFragment());
                break;
        }
        transaction.commit();


    }
}
