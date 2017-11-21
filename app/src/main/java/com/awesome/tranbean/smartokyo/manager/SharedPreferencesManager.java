package com.awesome.tranbean.smartokyo.manager;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String IS_FIRST_TIME_TUTORIAL = "isFirstTimeTutorial";

    /**
     * ユーザーに初回展示であるかどうか
     */
    public static boolean isFirstTimeTutorial(Context context) {
        SharedPreferences sharedPreferences = context
                .getSharedPreferences(IS_FIRST_TIME_TUTORIAL, -1);
        return sharedPreferences.getBoolean(IS_FIRST_TIME_TUTORIAL, false);
    }

    /**
     * ユーザーに初回展示である場合はデータを保存する
     */
    public static void setIsFirstTimeTutorial(Context context
            ,boolean isFirstTimeTutorial) {
        SharedPreferences sharedPreferences
                = context.getSharedPreferences(IS_FIRST_TIME_TUTORIAL,-1);
        sharedPreferences.edit().putBoolean(IS_FIRST_TIME_TUTORIAL
                ,isFirstTimeTutorial).commit();
    }
}
