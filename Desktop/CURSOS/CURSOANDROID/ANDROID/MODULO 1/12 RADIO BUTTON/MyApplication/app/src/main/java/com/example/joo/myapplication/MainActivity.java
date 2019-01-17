package com.example.joo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rd;
    Button botao;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup)findViewById(R.id.radioGroup);;
        botao = (Button) findViewById(R.id.button);
        txt = (TextView) findViewById(R.id.textView2);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idescolhido = rg.getCheckedRadioButtonId();

                if(idescolhido>0){
                  rd = (RadioButton)findViewById(idescolhido);
                    txt.setText(rd.getText());
                }

            }
        });

    }
}
