package com.example.joo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ListView lista;
    private String[] signos = {"Aries","Toro","Câncer","Leão","Virjem","Libra","Escorpião","sagitario"
    ,"Capricornio","Aqario","Peixes"};
    private String[] perfil = {"Ariesp","Torop","Câncerp","Leãop","Virjemp","Librap","Escorpiãop","sagitariop"
            ,"Capricorniop","Aqariop","Peixesp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.lista);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,
                android.R.id.text1, signos);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),perfil[position],Toast.LENGTH_SHORT).show();

            }
        });



    }
}
