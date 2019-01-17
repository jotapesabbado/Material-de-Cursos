package com.example.joo.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText et;
    private TextView txt;
    // CRIANDO CONSTANTE
    private static final String ARQIVO_PREFERENCIA = "Arqivo Preferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button2);
        et = (EditText)findViewById(R.id.editText);
        txt = (TextView)findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sh = getSharedPreferences(ARQIVO_PREFERENCIA,0);
                SharedPreferences.Editor edit = sh.edit();

                if(txt.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"DIGITE ALGO",Toast.LENGTH_SHORT);

                }else {
                    edit.putString("nome",et.getText().toString());
                    edit.commit();
                    txt.setText("Olá "+et.getText().toString());
                }
            }
        });

        //REUPERAR DADOS SALVOS
        SharedPreferences sh = getSharedPreferences(ARQIVO_PREFERENCIA,0);
        if(sh.contains("nome")){
            String nome = sh.getString("nome","nome não encontrado");
            txt.setText("Olá "+nome);
        }else {
            txt.setText("ola usuario não definido");
        }



    }
}
