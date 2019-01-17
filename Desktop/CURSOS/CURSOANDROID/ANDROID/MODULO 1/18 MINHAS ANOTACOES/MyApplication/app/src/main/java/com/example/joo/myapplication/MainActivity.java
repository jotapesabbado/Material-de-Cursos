package com.example.joo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText txt;
    private ImageView btn;
    private static final String ARQUIVO ="arquivo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText)findViewById(R.id.editText);
        btn = (ImageView)findViewById(R.id.salvar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gravarTexto(txt.getText().toString());
                Toast.makeText(MainActivity.this,"ANOTAÇÃO SALVA",Toast.LENGTH_SHORT).show();
            }
        });
        //RECUPERAR O QUE FOI GRAVADO
        if(lerArquivo()!=null){
            txt.setText(lerArquivo());
        }
    }



    public void gravarTexto(String texto){
        try{
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(ARQUIVO,MODE_PRIVATE));
            osw.write(texto);
            osw.close();

        }catch (IOException ex){
            Log.v("MainActivity", ex.toString());

        }
    }

    public String lerArquivo(){
        String resultado = "";

        try{
            //ABRIR ARQUIVO
            InputStream arquivo = openFileInput(ARQUIVO);
            if(arquivo!=null){

                //LER O ARQUIVO
                InputStreamReader isr = new InputStreamReader(arquivo);

                //GERAR BUFFER DO ARQUIVODE JÁ FOI LIDO
                BufferedReader br = new BufferedReader(isr);

                //RECUPERAR OS TEXTOS DO ARQUIVO
                String line ="";
                while((line=br.readLine())!=null){
                     resultado+=line;
                 }
                 arquivo.close();
            }

        }catch (IOException ex){
            Log.v("MainActivity", ex.toString());
        }
        return resultado;
    }
}
