package com.awesome.tranbean.apps.fragment;

import android.view.View;

import com.awesome.tranbean.apps.view.LoadingBodyPage.LoadResult;


public class AppFragment extends BaseFragment {
    @Override
    public View createSuccessView() {
        return null;
    }

    @Override
    public LoadResult loadFromServer() {

        return LoadResult.empty;
    }
}
