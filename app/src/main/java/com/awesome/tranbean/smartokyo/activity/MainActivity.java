package com.awesome.tranbean.smartokyo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.awesome.tranbean.smartokyo.R;
import com.awesome.tranbean.smartokyo.fragment.MainContentFragment;
import com.awesome.tranbean.smartokyo.fragment.SideMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    private static final String MAINCONTENTFRAGMENT = "maincontentfragment";
    private static final String SIDEMENUFRAGMENT = "sidemenufragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //メニューレイアウト
        setBehindContentView(R.layout.right_side_menu);
        //フルスクリーン、右から表示を設置する
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setMode(SlidingMenu.RIGHT);
        //メニューライアウトに対して余裕スペースを設置する
        int width = getWindowManager().getDefaultDisplay().getWidth();
        slidingMenu.setBehindOffset((int) (width * 0.45f));


        initFragment();
    }

    /**
     * 画面初期設定
     */
    private void initFragment() {

        FragmentTransaction fragmentTransaction
                = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content_fl
                , new MainContentFragment(), MAINCONTENTFRAGMENT);
        fragmentTransaction.replace(R.id.right_side_fl
                ,new SideMenuFragment(),SIDEMENUFRAGMENT);

        fragmentTransaction.commit();

    }
}
