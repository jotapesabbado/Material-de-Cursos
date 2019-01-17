package com.example.joo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = (TextView)findViewById(R.id.textview);
        Bundle extra = getIntent().getExtras();

        if(extra != null){
            String texto = extra.getString("nome");
            txt.setText(texto);

        }
    }
}
