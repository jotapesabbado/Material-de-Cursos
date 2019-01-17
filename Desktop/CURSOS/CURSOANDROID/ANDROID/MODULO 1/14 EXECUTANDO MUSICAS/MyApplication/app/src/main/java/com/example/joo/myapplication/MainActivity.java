package com.example.joo.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton tg;
    private MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tg = (ToggleButton)findViewById(R.id.toggleButton);
        mp = MediaPlayer.create(this,R.raw.musica);

        tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mp != null) {
                    if (isChecked) {
                        mp.start();
                    } else {
                        mp.pause();
                    }
                }
            }
        });
    }
    //LIBERAR OS RECURSOS DE MEMORIO SEMPRE QUE NÃO ESTIVER UTILIZANDO!!
    @Override
    protected void onDestroy() {
        if(mp !=null && mp.isPlaying()){
            mp.stop();
            mp.release();
            mp = null;
        }

        super.onDestroy();
    }
}
