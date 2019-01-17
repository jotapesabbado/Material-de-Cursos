package com.example.joo.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button botao;
    private AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("TITULO DO DIALOGO");
                dialog.setMessage("MENSAGEM");
                dialog.setCancelable(false);
                dialog.setIcon(android.R.drawable.btn_dropdown);

                dialog.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"APERTOU NÃO",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"APERTOU SIM",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.create();
                dialog.show();
            }

        });

    }
}
