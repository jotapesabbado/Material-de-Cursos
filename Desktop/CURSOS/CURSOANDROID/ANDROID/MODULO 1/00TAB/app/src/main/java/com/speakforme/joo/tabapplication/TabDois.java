package com.speakforme.joo.tabapplication;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabDois extends Fragment{



    @SuppressLint("ValidFragment")
    public TabDois(SQLiteDatabase sqLiteDatabase) {

    }

    public TabDois() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_dois,container,false);



        return view;
    }



}
