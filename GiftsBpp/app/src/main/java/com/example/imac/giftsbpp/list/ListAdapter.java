package com.example.imac.giftsbpp.list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imac on 16/11/28.
 */

public class ListAdapter extends FragmentStatePagerAdapter {
    private static ListBean data;

    public void setData(ListBean data) {
        this.data = data;
        notifyDataSetChanged();

    }

    public ListAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ReusListFragment().newInstance(position);
    }

    @Override
    public int getCount() {
        return data != null? data.getData().getRanks().size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.getData().getRanks().get(position).getName();
    }
    public static String getMessage(int pos) {
        return data.getData().getRanks().get(pos).getId() + "";
    }
}
