package com.example.imac.giftsbpp.kind;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.imac.giftsbpp.R;
import com.example.imac.giftsbpp.base.BaseFragment;
import com.example.imac.giftsbpp.kind.raiders.KindRaidersFragment;
import com.example.imac.giftsbpp.kind.sku.KindSKUFragment;

import java.util.ArrayList;

/**
 * Created by imac on 16/11/24.
 */
public class KindFragment extends BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragments;

    @Override
    public int setlayout() {
        return R.layout.fragment_kind;
    }

    @Override
    public void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.kind_vp);
        tabLayout = (TabLayout) view.findViewById(R.id.kind_tb);

    }

    @Override
    public void initData() {
        fragments = new ArrayList<>();
        fragments.add(new KindRaidersFragment());
        fragments.add(new KindSKUFragment());
        KindAdapter kindAdapter = new KindAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(kindAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
