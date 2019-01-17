package com.example.joo.caracoroa;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView moeda;
    private ImageView botaovoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        moeda = (ImageView)findViewById(R.id.imageView3);
        botaovoltar = (ImageView)findViewById(R.id.botaovoltar);


        Bundle extra =  getIntent().getExtras();



        if(extra !=null){
            String op = extra.getString("opcao");

            if(op.equals("cara")){
                moeda.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara));
            }else{
                moeda.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_coroa));
            }
        }


        botaovoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
