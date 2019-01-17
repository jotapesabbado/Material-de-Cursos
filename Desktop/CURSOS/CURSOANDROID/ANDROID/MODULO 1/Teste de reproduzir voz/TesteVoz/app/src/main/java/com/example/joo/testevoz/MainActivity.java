package com.example.joo.testevoz;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech mTTs;
    private EditText mEditText;
    private SeekBar mPich;
    private SeekBar mSpeed;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.button);



        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                  int result = mTTs.setLanguage(new Locale("pt", "POR"));

                  if(result== TextToSpeech.LANG_MISSING_DATA ||
                          result==TextToSpeech.LANG_NOT_SUPPORTED){
                      Log.e("TTS","linguagem não suportada");
                  } else{
                     mButton.setEnabled(true);
                  }
                }else{
                    Log.e("TTS","falha na inicialização");
                }
            }
        });

        mEditText =(EditText) findViewById(R.id.editText);
        mPich = (SeekBar) findViewById(R.id.seekBar);
        mSpeed = (SeekBar) findViewById(R.id.seekBar2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fale();
            }
        });
    }
    private void fale(){
        String text = mEditText.getText().toString();
        float pich = mPich.getProgress() / 50;
        if(pich < 0.1) pich = 0.1f;
        float speed = mSpeed.getProgress() / 50;
        if(speed < 0.1) speed = 0.1f;

        mTTs.setPitch(pich);
        mTTs.setSpeechRate(speed);
        mTTs.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    protected void onDestroy() {
        if(mTTs!= null){
            mTTs.stop();
            mTTs.shutdown();
        }

        super.onDestroy();
    }
}
