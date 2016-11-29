package com.example.imac.giftsbpp.reus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.imac.giftsbpp.home.choice.HomeChoiceFragment;
import com.example.imac.giftsbpp.home.TitleBean;

import java.util.List;

/**
 * Created by imac on 16/11/22.
 */

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    private static List<TitleBean.DataBean.ChannelsBean> data;

    public static void setData(List<TitleBean.DataBean.ChannelsBean> data) {
        ViewpagerAdapter.data = data;
    }

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeChoiceFragment();
        } else {
            return ReusFragment.newInstance(position);

        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getName();
    }

    public static String getMessage(int pos) {
        return data.get(pos).getId() + "";
    }
}
