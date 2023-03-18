package com.example.gesture;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;public class Two extends AppCompatActivity {
    private VideoView videoView;
    private Button button;
    private Button bp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        videoView = findViewById(R.id.videoView12);
        button = findViewById(R.id.button12);
        bp = findViewById(R.id.button0012);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.two);
        videoView.setVideoURI(videoUri);
        videoView.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.seekTo(0);
                videoView.start();
            }
        });
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Two.this, ThirdScreen.class);
                startActivity(intent);
            }
        });
    }
}