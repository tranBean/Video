package com.awesome.tranbean.smartokyo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by tranbean on 9/6/17.
 * ベースクラス、アプリ共通内容をこのクラスに共通化する
 */

public abstract class BaseActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Log.d(getLocalClassName(),)
        super.onCreate(savedInstanceState);
        setContentView(getInitContentViewId());
    }

    /**
     * layoutResauce
     */
    public abstract int getInitContentViewId();


    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }
}
