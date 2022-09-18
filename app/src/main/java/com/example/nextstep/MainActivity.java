package com.example.nextstep;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nextstep.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        videoView = findViewById(R.id.videoVw);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.nextstep;
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent signupIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(signupIntent);
                finish();
            }
        }, 4000);
    }
}