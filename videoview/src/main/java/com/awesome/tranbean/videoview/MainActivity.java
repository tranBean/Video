package com.awesome.tranbean.videoview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = (VideoView) this.findViewById(R.id.vv_video);

        videoView.setVideoURI(Uri.parse("http://192.168.128.190:8080/carlock.mp4"));

        MediaController ctr = new MediaController(this);

        videoView.setMediaController(ctr);

        ctr.setMediaPlayer(videoView);
    }
}
