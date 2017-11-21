package com.awesome.tranbean.searchui.tool;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ViewUtils {
	public static void removeParent(View v){
		//  ���ҵ��� ��ͨ����ȥ�Ƴ�����
		ViewParent parent = v.getParent();
		//���еĿؼ� ���е�  ��һ������� ����ViewGoup
		if(parent instanceof ViewGroup){
			ViewGroup group=(ViewGroup) parent;
			group.removeView(v);
		}
	}
}
