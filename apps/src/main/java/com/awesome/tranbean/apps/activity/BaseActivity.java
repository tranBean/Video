package com.awesome.tranbean.apps.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;


public class BaseActivity extends AppCompatActivity {

    //appのアクティビティを管理する
    List<BaseActivity> mActivitys = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitys.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivitys.remove(this);
    }

    public void logout() {
        List<BaseActivity> copy = new LinkedList<BaseActivity>(mActivitys);
        for (BaseActivity activity : copy) {
            activity.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
