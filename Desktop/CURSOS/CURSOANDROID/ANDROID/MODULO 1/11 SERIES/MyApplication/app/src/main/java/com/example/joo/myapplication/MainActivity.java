package com.example.joo.myapplication;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    SeekBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.imageView2);
        bar = (SeekBar)findViewById(R.id.seekBar);
        img.setImageResource(R.drawable.pouco);


        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(bar.getProgress()==0){
                    img.setImageResource(R.drawable.pouco);
                }
                if(bar.getProgress()==1){
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.medio));
                }
                if(bar.getProgress()==2){
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.muito));}
                if(bar.getProgress()==3){
                    img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.susto));

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
}
