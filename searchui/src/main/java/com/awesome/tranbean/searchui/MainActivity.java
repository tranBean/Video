package com.awesome.tranbean.searchui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.awesome.tranbean.searchui.fragment.AppFragment;
import com.awesome.tranbean.searchui.fragment.BaseFragment;
import com.awesome.tranbean.searchui.fragment.FragmentFactory;
import com.awesome.tranbean.searchui.tool.UiUtils;

public class MainActivity extends AppCompatActivity {

    private String[] tab_names;
    private ViewPager mViewPager;
    private PagerTabStrip pager_tab_strip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        initView();
    }

    protected void init() {
        tab_names = UiUtils.getStringArray(R.array.tab_names);
    }

    protected void initView() {
        //setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_search_view_pager);
        pager_tab_strip = (PagerTabStrip) findViewById(R.id.pager_tab_strip);
        //  设置标签下划线的颜色
        pager_tab_strip.setTabIndicatorColor(getResources().getColor(R.color.indicatorcolor));

        mViewPager.setAdapter(new MainAdpater(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BaseFragment createFragment = FragmentFactory.createFragment(position);
                createFragment.show();//  当切换界面的时候 重新请求服务器
            }

        });
        // 添加菜单
        //fl_menu = (FrameLayout) findViewById(R.id.fl_menu);
        //MenuHolder holder = new MenuHolder();
        //  之前已经登录过了
        //holder.setData(data)
        //fl_menu.addView(holder.getContentView());
    }

    private class MainAdpater extends FragmentStatePagerAdapter {
        public MainAdpater(FragmentManager fm) {
            super(fm);
        }

        // 每个条目返回的fragment
        //  0
        @Override
        public Fragment getItem(int position) {
            //  通过Fragment工厂  生产Fragment
            AppFragment app = new AppFragment();

            return app;//FragmentFactory.createFragment(position);
        }

        // 一共有几个条目
        @Override
        public int getCount() {
            return tab_names.length;
        }

        // 返回每个条目的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return tab_names[position];
        }

    }
}
