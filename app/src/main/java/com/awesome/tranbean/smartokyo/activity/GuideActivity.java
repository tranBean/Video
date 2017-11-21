package com.awesome.tranbean.smartokyo.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.awesome.tranbean.smartokyo.R;
import com.awesome.tranbean.smartokyo.adapter.GuideViewPagerAdapter;
import com.awesome.tranbean.smartokyo.listener.GuidePageListener;
import com.awesome.tranbean.smartokyo.manager.SharedPreferencesManager;

import java.util.ArrayList;

public class GuideActivity extends BaseActivity {

    private ViewPager guideViewpager;
    private ArrayList<ImageView> imageList;
    private LinearLayout linearLayout;
    private int width;
    private View redPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initGrayPoints();
    }

    @Override
    public int getInitContentViewId() {
        return R.layout.activity_guide;
    }

    /**
     * グレーポイント初期化
     */
    private void initGrayPoints() {
        LinearLayout.LayoutParams params
                = new LinearLayout.LayoutParams(10, 10);
        for (int i = 0; i <= imageList.size() - 1; i++) {
            View grayPoint = new View(this);
            grayPoint.setBackgroundResource(R.drawable.shape_point_gray);
            if (i > 0) params.leftMargin = 10;
            grayPoint.setLayoutParams(params);
            linearLayout.addView(grayPoint);
        }

        //レッドポイント初期化
        redPoint = this.findViewById(R.id.red_point);

        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    //システムがlayout動作完了次第に以下メソッドをコールバックする
                    @Override
                    public void onGlobalLayout() {
                        if (Build.VERSION.SDK_INT
                                >= Build.VERSION_CODES.JELLY_BEAN) {
                            linearLayout.getViewTreeObserver()
                                    .removeOnGlobalLayoutListener(this);

                            //グレーポイント間の距離を計算する
                            width = linearLayout.getChildAt(1).getLeft()
                                    - linearLayout.getChildAt(0).getLeft();

                            //ビューページャのページチャンージリスナーを設置する
                            guideViewpager.setOnPageChangeListener(
                                    new GuidePageListener(width, redPoint));
                        }
                    }
                });
    }


    /**
     * チュートリアル画像初期準備
     */
    private void initView() {
        guideViewpager = this.findViewById(
                R.id.viewpager_guide);
        int[] images = new int[]{R.drawable.guide_1
                , R.drawable.guide_2, R.drawable.guide_3};
        imageList = new ArrayList();
        for (int imageId : images
                ) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageId);
            imageList.add(imageView);
        }

        GuideViewPagerAdapter guideViewpagerAdapter
                = new GuideViewPagerAdapter(imageList);
        guideViewpager.setAdapter(guideViewpagerAdapter);

        linearLayout =
                this.findViewById(R.id.gray_points);

        Button guideButton = this.findViewById(R.id.button_guide);
        guideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //メイン画面に遷移する
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                //初回限定チュートリアル展示、データを保存する
                SharedPreferencesManager.setIsFirstTimeTutorial(GuideActivity.this,true);
                finish();
            }
        });
    }
}
