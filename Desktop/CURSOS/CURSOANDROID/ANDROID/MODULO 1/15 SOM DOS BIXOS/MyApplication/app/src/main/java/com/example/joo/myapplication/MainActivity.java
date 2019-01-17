package com.example.joo.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView cao;
    private ImageView leao;
    private ImageView ovelha;
    private ImageView gato;
    private ImageView macaco;
    private ImageView vaca;
    private MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cao = (ImageView)findViewById(R.id.cao);
        leao = (ImageView)findViewById(R.id.leao);
        ovelha = (ImageView)findViewById(R.id.ovelha);
        gato = (ImageView)findViewById(R.id.gato);
        macaco = (ImageView)findViewById(R.id.macaco);
        vaca = (ImageView)findViewById(R.id.vaca);

        cao.setOnClickListener(this);
        leao.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        gato.setOnClickListener(this);
        macaco.setOnClickListener(this);
        vaca.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cao:
                mp = MediaPlayer.create(this,R.raw.cao);
                tocarSom();
                break;
            case R.id.leao:
                mp = MediaPlayer.create(this,R.raw.leao);
                tocarSom();
                break;
            case R.id.ovelha:
                mp = MediaPlayer.create(this,R.raw.ovelha);
                tocarSom();
                break;
            case R.id.gato:
                mp = MediaPlayer.create(this,R.raw.gato);
                tocarSom();
                break;
            case R.id.macaco:
                mp = MediaPlayer.create(this,R.raw.macaco);
                tocarSom();
                break;
            case R.id.vaca:
                mp = MediaPlayer.create(this,R.raw.vaca);
                tocarSom();
                break;
        }

    }

    public void tocarSom(){
        if(mp != null){
            mp.start();
        }
    }

    @Override
    protected void onDestroy() {
        if(mp!= null){
            mp.release();
            mp=null;
        }
        super.onDestroy();
    }
}
