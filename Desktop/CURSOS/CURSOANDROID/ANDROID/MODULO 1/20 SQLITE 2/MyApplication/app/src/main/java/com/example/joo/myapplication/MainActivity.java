package com.example.joo.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private String linhas = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.textView);
        try {
            SQLiteDatabase banco = openOrCreateDatabase("nomedobanco", MODE_PRIVATE, null);
            banco.execSQL("DROP TABLE pessoas");
            banco.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR,idade INTEGER(3))");
            banco.execSQL("INSERT INTO pessoas (nome, idade) VALUES('JUDITI',10);");
            banco.execSQL("INSERT INTO pessoas (nome, idade) VALUES('VALMIR',46);");
            banco.execSQL("INSERT INTO pessoas (nome, idade) VALUES('ROBERVAL',98);");
            Cursor busca = banco.rawQuery("SELECT * FROM pessoas", null);

            busca.moveToFirst();
            while (busca != null) {
                linhas += ("NOME: " + busca.getString(busca.getColumnIndex("nome")) +
                        " // IDADE :" + busca.getString(busca.getColumnIndex("idade"))+"\n");

                busca.moveToNext();
            }
            txt.setText(linhas);
            Log.i("RESPOSTA", linhas);

        }catch (Exception e){

        }
    }
}
