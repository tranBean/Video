package com.awesome.tranbean.smartokyo.listener;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;

public class GuidePageListener
        implements ViewPager.OnPageChangeListener {

    private final int width;
    private final View redPoint;

    public GuidePageListener(int width, View redPoint) {
        this.width = width;
        this.redPoint = redPoint;
    }

    @Override
    public void onPageScrolled(int position
            , float positionOffset, int positionOffsetPixels) {
        int len = (int) (width * positionOffset) + position * width;

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout
                .LayoutParams) redPoint.getLayoutParams();
        layoutParams.leftMargin = len;

        redPoint.setLayoutParams(layoutParams);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
