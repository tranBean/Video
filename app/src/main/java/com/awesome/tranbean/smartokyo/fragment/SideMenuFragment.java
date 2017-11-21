package com.awesome.tranbean.smartokyo.fragment;

import android.view.View;

import com.awesome.tranbean.smartokyo.R;

/**
 * Created by tranbean on 9/16/17.
 */

public class SideMenuFragment extends BaseFragment {
    @Override
    protected View initView() {
        return View.inflate(mActivity, R.layout.fragment_side_menu,null);
    }
}
