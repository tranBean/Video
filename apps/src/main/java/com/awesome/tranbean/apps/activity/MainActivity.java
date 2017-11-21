package com.awesome.tranbean.apps.activity;

import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

import com.awesome.tranbean.apps.R;
import com.awesome.tranbean.apps.adapter.MainViewPagerAdpater;
import com.awesome.tranbean.apps.fragment.BaseFragment;
import com.awesome.tranbean.apps.fragment.FragmentFactory;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private PagerTabStrip mPagerTab;
    private String[] mTabNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabData();
        initView();
    }

    private void initTabData() {
        mTabNames = getResources()
                .getStringArray(R.array.tab_names);

    }

    /*画面初期化*/
    public void initView() {

        mViewPager = (ViewPager) findViewById(R.id.vp_main);
        mPagerTab = (PagerTabStrip) findViewById(R.id.ps_tab);
        MainViewPagerAdpater mainViewPagerAdpater
                = new MainViewPagerAdpater(getSupportFragmentManager(), mTabNames);
        mViewPager.setAdapter(mainViewPagerAdpater);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BaseFragment fragment = FragmentFactory.createFragment(position);
                fragment.show();
            }
        });

    }
}
