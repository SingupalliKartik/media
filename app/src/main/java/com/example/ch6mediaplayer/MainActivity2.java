package com.example.ch6mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    public SeekBar seekBar;
private    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(this, "Wait till the music loads", Toast.LENGTH_SHORT).show();

        Button play = findViewById(R.id.button);
        Button pause = findViewById(R.id.button2);
  //using remort source
            mediaPlayer= new MediaPlayer();
        try {
            mediaPlayer.setDataSource("http://socialdance.stanford.edu/music/Momento_Tango.m4a");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        media-player.start();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(MainActivity2.this, "Ready to play", Toast.LENGTH_SHORT).show();
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
            }
        });
        mediaPlayer.prepareAsync();
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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}