package com.awesome.tranbean.smartokyo.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by tranbean on 9/21/17.
 */

public class customCheckedTextView extends android.support.v7.widget.AppCompatTextView {
    public customCheckedTextView(Context context) {
        super(context);
    initView();
    }

    public customCheckedTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    initView();
    }

    public customCheckedTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    initView();
    }

    private void initView() {

    }

}
