package com.awesome.tranbean.apps.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.awesome.tranbean.apps.fragment.FragmentFactory;

public class MainViewPagerAdpater extends FragmentStatePagerAdapter {

    private final String[] tabNames;

    public MainViewPagerAdpater(FragmentManager fm
            , String[] tabNames) {
        super(fm);
        this.tabNames = tabNames;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return tabNames.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }

}