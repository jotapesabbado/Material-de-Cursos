package com.example.joo.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase banco = openOrCreateDatabase("app", MODE_PRIVATE, null);
            //criando tabela
            banco.execSQL("create table if not exists pessoas(nome varchar,idade int(3))");
            //incerindo valores
            banco.execSQL("insert into pessoas(nome,idade) values('João',20)");
            banco.execSQL("insert into pessoas(nome,idade) values('Ana',30)");
            //ONDE GUARDA A BUSCA
            Cursor cursor = banco.rawQuery("select nome,idade from pessoas where idade=20;", null);

            int indicenome = cursor.getColumnIndex("nome");
            int indiceidade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("res NOME:", cursor.getString(indicenome));
                Log.i("res IDADE:", cursor.getString(indiceidade));
                cursor.moveToNext();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
