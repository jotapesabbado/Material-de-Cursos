package com.firabase.joo.firebaseapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //acesso ao banco do firebase fazendo referencia(quando não tem nada ele aponta pra raiz)
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    //REFERENCIA DO 001 EM USUARIOS(SE QUISER QUE SEJA PRA TODOS OS USUARIOS É SÓ TIRAR O .CHILD())
    private DatabaseReference userdatabaseReference = databaseReference.child("usuarios").child("001");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*AULA 1
        //cria um nó e seta valor
        databaseReference.child("pontos").setValue("100");
        */
        /*
        //AULA 2
        Usuario user1 =new Usuario();
        user1.setNome("batata");
        user1.setSobrenome("crua");
        user1.setIdade(1);
        user1.setSexo("gostoso");

        userdatabaseReference.child("003").setValue(user1);
        */
        //AULA 3 RECUPERAR DADOS EM TEMPO REAL, SEMPRE QUE HOUVER ALGUMA MUDANÇA (ADD UM LISTNER)
        userdatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
