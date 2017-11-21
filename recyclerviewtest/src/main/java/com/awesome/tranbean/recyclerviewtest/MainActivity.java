package com.awesome.tranbean.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActionSheet.ActionSheetListener {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showActionSheet();

        initData();

        initView();

        SimpleAdapter mAdapter = new SimpleAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"clicked position = "+position,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this,"longClicked position = "+position,Toast.LENGTH_LONG).show();

            }
        });
    }

    private void showActionSheet() {
        ActionSheet.createBuilder(this, getSupportFragmentManager())
                .setCancelButtonTitle("Cancel")
                .setOtherButtonTitles("Item1", "Item2", "Item3", "Item4")
                .setCancelableOnTouchOutside(true)
                .setListener(this).show();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for(int i = 'A' ;i <= 'z';i++){
            mDatas.add(""+(char)i);
        }
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {
        Toast.makeText(getApplicationContext(), "dismissed isCancle = " + isCancel, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {

        Toast.makeText(getApplicationContext(), "click item index = " + index,
                Toast.LENGTH_LONG).show();
    }
}
