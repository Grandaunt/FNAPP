package com.bcm.havoc.fnapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author misolamiso.
 * @Date 2018/8/17-16:47
 */
public class BottomViewAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public BottomViewAdapter(FragmentManager manager, List<Fragment> mFragmentList) {
        super(manager);
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }


}