package com.example.gesture;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.gesture.R;

public class TurnOffLightsActivity extends AppCompatActivity {
    private VideoView videoView;
    private Button button;
    private Button bp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_off_lights);
        videoView = findViewById(R.id.videoView70);
        button = findViewById(R.id.button70);
        bp = findViewById(R.id.button002);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lightoff);
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
                Intent intent = new Intent(TurnOffLightsActivity.this, ThirdScreen.class);
                startActivity(intent);
            }
        });
    }
}