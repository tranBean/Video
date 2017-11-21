package com.awesome.tranbean.imooc_recyclerview;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private List<String> mData;
    private SimpleAdapter mAdapter;
    private ListView listView;
    private ArrayList<RecyclerView> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //リサイクルビュー初期化
        initRecyclerView();

        //リストビュー初期化
        initListView();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.action_listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_staggered:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.action_hor_gridview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager
                        (5, StaggeredGridLayoutManager.HORIZONTAL));
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void initListView() {
        listView = (ListView) findViewById(R.id.list_view);
        initListViewData();
        MyLIstViewAdapter mylistViewAdapter = new MyLIstViewAdapter(this, datas);
        listView.setAdapter(mylistViewAdapter);
    }

    private void initListViewData() {
        datas = new ArrayList<RecyclerView>();

        for (int i = 0; i < mData.size(); i++) {
            RecyclerView itemRecyclerView
                    = (RecyclerView) initRecyclerView();
            datas.add(itemRecyclerView);
        }
    }

    private View initRecyclerView() {
        initData();

        initView();

        mAdapter = new SimpleAdapter(this, mData);
        mRecyclerView.setAdapter(mAdapter);

        //リサイクルビューレイアウト管理
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //リサイクルビューのアイテム間の線
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));


        return mRecyclerView;
    }

    private void initView() {

        View inflate = View.inflate(this, R.layout.item_listview, null);
        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerview);
    }

    private void initData() {
        mData = new ArrayList<String>();
        for (int i = 'A'; i <= 'z'; i++) {
            mData.add("" + (char) i);
            System.out.println(i);
        }
    }

}
