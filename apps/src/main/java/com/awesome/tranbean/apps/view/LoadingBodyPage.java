package com.awesome.tranbean.apps.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.awesome.tranbean.apps.R;
import com.awesome.tranbean.apps.tools.UiUtils;

import static com.awesome.tranbean.apps.view.LoadingBodyPage.Status.Empty;
import static com.awesome.tranbean.apps.view.LoadingBodyPage.Status.Error;
import static com.awesome.tranbean.apps.view.LoadingBodyPage.Status.Loading;
import static com.awesome.tranbean.apps.view.LoadingBodyPage.Status.Success;

public abstract class LoadingBodyPage extends FrameLayout {

    public static final int STATE_UNKOWN = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_ERROR = 2;
    public static final int STATE_EMPTUY = 3;
    public static final int STATE_SUCCESS = 4;
    public int curState = STATE_UNKOWN;

    public LoadingBodyPage(Context context) {
        super(context);

        init();
    }

    public LoadingBodyPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingBodyPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initView();
        //サーバからのデータに従って、ステータスを置き換える
        show();
    }


    private View loadingView;
    private View errorView;
    private View emptyView;
    private View successView;

    private void initView() {
        loadingView = createBodyView(Loading);
        if (loadingView != null) {
            this.addView(loadingView,
                    new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
                            , FrameLayout.LayoutParams.MATCH_PARENT));
        }
        errorView = createBodyView(Error);
        if (errorView != null) {
            this.addView(errorView,
                    new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
                            , FrameLayout.LayoutParams.MATCH_PARENT));
        }
        emptyView = createBodyView(Empty);
        if (emptyView != null) {
            this.addView(emptyView,
                    new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
                            , FrameLayout.LayoutParams.MATCH_PARENT));
        }

        //ステータスにり、四つ画面を置き換える
        initStatus();
    }

    private void initStatus() {
        if (loadingView != null) {
            loadingView.setVisibility(curState == STATE_UNKOWN
                    || curState == STATE_LOADING ? View.VISIBLE : View.INVISIBLE);
        }
        if (errorView != null) {
            errorView.setVisibility(curState == STATE_ERROR
                    ? View.VISIBLE : View.INVISIBLE);
        }
        if (emptyView != null) {
            emptyView.setVisibility(curState == STATE_EMPTUY
                    ? View.VISIBLE : View.INVISIBLE);
        }

        if (curState == STATE_SUCCESS) {
            successView = createBodyView(Success);
            if (successView != null) {
                this.addView(successView,
                        new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
                                , FrameLayout.LayoutParams.MATCH_PARENT));

                successView.setVisibility(curState == STATE_SUCCESS
                        ? View.VISIBLE : View.INVISIBLE);
            }
        } else {
            if (successView != null) {
                successView.setVisibility(View.INVISIBLE);
            }
        }

    }

    private View createBodyView(Status status) {
        View view = null;
        switch (status) {
            case Success:
                view = createSuccessView();
                break;
            case Error:
                view = View.inflate(UiUtils.getContext(), R.layout.body_error, null);
                break;
            case Loading:
                view = View.inflate(UiUtils.getContext(), R.layout.body_loading, null);
                break;
            case Empty:
                view = View.inflate(UiUtils.getContext(), R.layout.body_empty, null);
                break;
            default:
                break;
        }
        return view;
    }

    public void show() {

        if (curState == STATE_ERROR ||
                curState == STATE_EMPTUY
                || curState == STATE_SUCCESS) {
            curState = STATE_UNKOWN;
        }

        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                final LoadResult result = loadFromServer();

                UiUtils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result != null) {
                            curState = result.getValue();
                            //curState = 2 + new Random().nextInt(3);
                            //ステータス更新されているので
                            initStatus();
                        }
                    }
                });


            }
        }.start();

        initStatus();
    }

    public enum LoadResult {

        error(2), empty(3), success(4);
        int value;

        LoadResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public enum Status {
        Success, Error, Loading, Empty
    }

    protected abstract LoadResult loadFromServer();

    public abstract View createSuccessView();

}
