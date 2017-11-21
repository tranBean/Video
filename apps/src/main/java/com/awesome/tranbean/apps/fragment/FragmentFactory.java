package com.awesome.tranbean.apps.fragment;

import java.util.HashMap;
import java.util.Map;

public class FragmentFactory {

    private static Map<Integer, BaseFragment> mFragments
            = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int position) {

        BaseFragment fragment;
        fragment = mFragments.get(position);
        if (fragment == null) {
            if (position == 0) {
                fragment = new HomeFragment();
            } else if (position == 1) {
                fragment = new AppFragment();
            } else if (position == 2) {
                fragment = new GameFragment();
            } else if (position == 3) {
                fragment = new SubjectFragment();
            } else if (position == 4) {
                fragment = new CategoryFragment();
            } else if (position == 5) {
                fragment = new TopFragment();
            }
            if (fragment != null) {
                mFragments.put(position, fragment);
            }
        }
        return fragment;

    }
}
