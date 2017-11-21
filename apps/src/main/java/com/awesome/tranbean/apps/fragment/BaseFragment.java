package com.awesome.tranbean.apps.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awesome.tranbean.apps.view.LoadingBodyPage;


public abstract class BaseFragment extends Fragment {

    private LoadingBodyPage mLoadingBodyPage;

    @Override
    public View onCreateView(LayoutInflater inflater
            , ViewGroup container, Bundle savedInstanceState) {

        if (mLoadingBodyPage == null) {
            mLoadingBodyPage = new LoadingBodyPage(getActivity()) {
                @Override
                protected LoadResult loadFromServer() {
                    return BaseFragment.this.loadFromServer();
                }

                @Override
                public View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }
            };
        }

        return mLoadingBodyPage;
    }

    public abstract View createSuccessView();

    public abstract LoadingBodyPage.LoadResult loadFromServer();

    public void show() {
        mLoadingBodyPage.show();
    }
}
