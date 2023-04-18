package com.example.ch6mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
private Button play;
private Button pause;
public SeekBar seekBar;

private MediaPlayer mediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play= findViewById(R.id.button);
        pause= findViewById(R.id.button2);
        mediaplayer = MediaPlayer.create(this,R.raw.music);
//Uri uri = Uri.parse("R.raw.music");
//        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
//        mmr.setDataSource(this, uri);
//        String str = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
//            int mili = Integer.parseInt(str);
//        seekBar.setMax(mediaPlayer.getDuration());
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser){
//                    mediaplayer.seekTo(progress);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//        mediaplayer.start();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer.pause();
            }
        });


    }
    public void  openAct(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}