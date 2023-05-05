package com.example.ch6mediaplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity3 extends AppCompatActivity {
    public SeekBar seekBar;
    private SurfaceView surfaceView;
    private    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button play = findViewById(R.id.som);
        Button pause = findViewById(R.id.sum1);
        //using remort source
        surfaceView = findViewById(R.id.surfaceView);

        mediaPlayer =   MediaPlayer.create(this,R.raw.video);
        surfaceView.getKeepScreenOn();
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mediaPlayer.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
//        media-player.start();

//                    mp.start();
                seekBar= findViewById(R.id.seekBar);
                seekBar.setMax(mediaPlayer.getDuration());
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser){
                            mediaPlayer.seekTo(progress);
                        }

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });


//        mediaPlayer.prepareAsync();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
    }
    public void openAct(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        mediaPlayer.stop();
    }

}