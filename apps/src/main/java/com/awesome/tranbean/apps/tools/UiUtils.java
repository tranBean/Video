package com.awesome.tranbean.apps.tools;

import android.content.Context;

import com.awesome.tranbean.apps.BaseApplication;

public class UiUtils {

    /**
     * 把Runnable 方法提交到主线程运行
     * @param runnable
     */
    public static void runOnUiThread(Runnable runnable) {
        // 在主线程运行
        if(android.os.Process.myTid()==BaseApplication.getMainTid()){
            runnable.run();
        }else{
            //获取handler
            BaseApplication.getHandler().post(runnable);
        }
    }


    public static Context getContext(){
        return BaseApplication.getApplication();
    }
}
