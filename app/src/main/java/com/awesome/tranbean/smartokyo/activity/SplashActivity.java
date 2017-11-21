package com.awesome.tranbean.smartokyo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import com.awesome.tranbean.smartokyo.R;
import com.awesome.tranbean.smartokyo.manager.SharedPreferencesManager;

public class SplashActivity extends BaseActivity {

    private ConstraintLayout splushRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splushRoot = this.findViewById(R.id.splush_root);
        startAnima();
    }

    @Override
    public int getInitContentViewId() {
        return R.layout.activity_splush;
    }

    /**
     *アニメ起動
     */
    private void startAnima() {

        RotateAnimation rotate = new RotateAnimation(0
                ,360, Animation.RELATIVE_TO_SELF,0.5f
                ,Animation.RELATIVE_TO_SELF,0.5f);
        ScaleAnimation scale = new ScaleAnimation(0, 1
                , 0, 1, Animation.RELATIVE_TO_SELF, 0.5f
                , Animation.RELATIVE_TO_SELF, 0.5f);
        AlphaAnimation alpa = new AlphaAnimation(0, 1);

        AnimationSet set = new AnimationSet(false);

        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.addAnimation(alpa);

        set.setDuration(1000);
        set.setFillAfter(true);
        splushRoot.setAnimation(set);

        //アニメ終了か判断するリスナー
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                toGuideActivityOrMainActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    /**
     * チュートリアル画面かメイン画面かに遷移する
     */
    private void toGuideActivityOrMainActivity() {
        if(SharedPreferencesManager.isFirstTimeTutorial(SplashActivity.this)) {
            //メイン画面に遷移する
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        }else {
            //チュートリアル画面に遷移する
            startActivity(new Intent(SplashActivity.this,GuideActivity.class));
        }
        finish();
    }
}
