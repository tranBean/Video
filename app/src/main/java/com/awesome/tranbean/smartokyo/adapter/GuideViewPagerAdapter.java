package com.awesome.tranbean.smartokyo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class GuideViewPagerAdapter extends PagerAdapter {


    private final int count;
    private final ArrayList<ImageView> imageList;

    public GuideViewPagerAdapter(ArrayList<ImageView> imageList) {
        this.imageList = imageList;
        this.count = imageList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container
            , int position) {
        container.addView(imageList.get(position));
        return imageList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position
            , Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return count;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
