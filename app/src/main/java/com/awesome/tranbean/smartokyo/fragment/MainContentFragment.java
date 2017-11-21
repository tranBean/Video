package com.awesome.tranbean.smartokyo.fragment;

import android.view.View;

import com.awesome.tranbean.smartokyo.R;

public class MainContentFragment extends BaseFragment {
    @Override
    protected View initView() {
        return View.inflate(mActivity, R.layout.fragment_main_content,null);
    }
}
