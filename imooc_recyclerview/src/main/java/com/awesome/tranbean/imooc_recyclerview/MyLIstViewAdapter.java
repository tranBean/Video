package com.awesome.tranbean.imooc_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;


public class MyLIstViewAdapter extends BaseAdapter {

    private final ArrayList<RecyclerView> mData;
    private final Context mContext;

    public MyLIstViewAdapter(Context context, ArrayList<RecyclerView> mData) {
        super();
        this.mData = mData;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return mData.get(i);
    }
}
