package com.example.joo.caracoroa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView botaojogar;
    private String[] opcao = {"cara", "coroa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaojogar = (ImageView) findViewById(R.id.botaojogar);

        botaojogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //gerar numero aleatorio

                Random rand = new Random();
                int num = rand.nextInt(2);

                startActivity(new Intent(MainActivity.this,Main2Activity.class).putExtra("opcao",opcao[num]));

            }
        });
    }
}
