package com.awesome.tranbean.testviewpagerfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.awesome.tranbean.testviewpagerfragments.fragment.FragmentFactory;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private String[] mTabNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    private void initView() {
        mTabNames = getResources().getStringArray(R.array.tab_names);
        ArrayList<View> views = new ArrayList<>();
        ViewPager viewPager = findViewById(R.id.vp_viewpager);

        for (int i = 0; i < mTabNames.length; i++) {
            views.add(FragmentFactory.createFragment(i).getView());
        }

        if (views != null) {
            MyPagerAdapter myPagerAdapter = new MyPagerAdapter(views);
            viewPager.setAdapter(myPagerAdapter);
        }
    }

    class MyPagerAdapter extends PagerAdapter {

        private final ArrayList<View> views;

        public MyPagerAdapter(ArrayList<View> views) {
            this.views = views;

        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


    }

    @Override
    protected void onResume() {
        initView();
        super.onResume();
    }
}
