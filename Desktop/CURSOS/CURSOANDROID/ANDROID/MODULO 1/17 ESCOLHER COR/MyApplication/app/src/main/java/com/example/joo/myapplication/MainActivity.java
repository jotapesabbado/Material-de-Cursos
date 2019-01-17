package com.example.joo.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private Button btn;
    private RelativeLayout tela;
    private static final String ARQUIVO_PREFERENCIAS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tela = (RelativeLayout)findViewById(R.id.tela);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rg.getCheckedRadioButtonId()>0) {

                    if (rg.getCheckedRadioButtonId() == R.id.amarelo) {
                        trocarCor(0xFFFFEE00);
                    }
                    if (rg.getCheckedRadioButtonId() == R.id.vermelho) {
                        trocarCor(0xFFFF0004);
                    }
                    if (rg.getCheckedRadioButtonId() == R.id.verde) {
                        trocarCor(0xFF26FF00);
                    }

                }
            }
        });

        SharedPreferences sh = getSharedPreferences(ARQUIVO_PREFERENCIAS,0);
        if(sh.contains("cor")){
            tela.setBackgroundColor(sh.getInt("cor",0xfff));
        }else {
            tela.setBackgroundColor(0xfff);
        }

    }

    public void trocarCor(int x){
        SharedPreferences sh = getSharedPreferences(ARQUIVO_PREFERENCIAS,0);
        SharedPreferences.Editor edit = sh.edit();
        tela.setBackgroundColor(x);
        edit.putInt("cor",x);
        edit.commit();
    }
}
