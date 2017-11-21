package com.awesome.tranbean.myapplication;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();
    private ProgressBar mProgress1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgress1 = (ProgressBar) findViewById(R.id.pb_bar);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus++;
                    SystemClock.sleep(1*1000);
                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress1.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
    }
}
