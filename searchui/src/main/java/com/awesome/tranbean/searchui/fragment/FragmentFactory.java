package com.awesome.tranbean.searchui.fragment;

import java.util.HashMap;
import java.util.Map;

import android.support.v4.app.Fragment;

public class FragmentFactory {

	private static Map<Integer, BaseFragment> mFragments = new HashMap<Integer, BaseFragment>();

	public static BaseFragment createFragment(int position) {
		BaseFragment fragment = null;
		fragment = mFragments.get(position);  //�ڼ�����ȡ����Fragment
		if (fragment == null) {  //����ټ�����û��ȡ���� ��Ҫ���´���
			if (position == 0) {
				fragment = new AppFragment();
			} else if (position == 1) {
				fragment = new TopFragment();
			} else if (position == 2) {
				fragment = new AppFragment();
			} else if (position == 3) {
				fragment = new TopFragment();
			} else if (position == 4) {
				fragment = new AppFragment();
			} else if (position == 5) {
				fragment = new TopFragment();
			}
			if (fragment != null) {
				mFragments.put(position, fragment);// �Ѵ����õ�Fragment��ŵ������л�������
			}
		}
		return fragment;

	}
}
