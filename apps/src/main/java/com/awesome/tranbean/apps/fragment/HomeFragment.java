package com.awesome.tranbean.apps.fragment;

import android.view.View;

import com.awesome.tranbean.apps.view.LoadingBodyPage.LoadResult;

public class HomeFragment extends BaseFragment {



    @Override
    public LoadResult loadFromServer() {
        return LoadResult.success;
    }

    @Override
    public View createSuccessView() {
        return null;
    }
}
