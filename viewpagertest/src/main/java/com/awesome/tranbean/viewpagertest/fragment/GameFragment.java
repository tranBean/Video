package com.awesome.tranbean.viewpagertest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awesome.tranbean.viewpagertest.R;

public class GameFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater
            , ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragemt_app, null);
        return view;
    }
}
