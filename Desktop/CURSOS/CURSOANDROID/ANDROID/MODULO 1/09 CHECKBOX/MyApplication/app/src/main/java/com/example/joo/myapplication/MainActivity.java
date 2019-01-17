package com.example.joo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;
    Button botao;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch1 = (CheckBox)findViewById(R.id.checkBox1);
        ch2 = (CheckBox)findViewById(R.id.checkBox2);
        ch3 = (CheckBox)findViewById(R.id.checkBox3);
        botao = (Button)findViewById(R.id.button);
        txt = (TextView)findViewById(R.id.textView);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt.setText("ITENS: "+"\n"+ ch1.getText()+": "+ch1.isChecked()+
                        "\n"+ch2.getText()+": "+ch2.isChecked()+
                        "\n"+ch3.getText()+": "+ch3.isChecked());

            }
        });
    }
}
