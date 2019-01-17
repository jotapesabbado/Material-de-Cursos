package com.firabase.joo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth= FirebaseAuth.getInstance();

        //CADASTRO
        //OBS: quando um usuario é cadastrado automaticamente ele esta logado

        /*firebaseAuth.createUserWithEmailAndPassword("batata@gmail.com","batata123")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){//sucesso no cadastro
                            Log.i("BATATA","SUCESSO");
                        }else {//erro no cadastro
                            Log.i("BATATA","ERRO");
                        }
                    }
                });
        */
        //LOGAR UM USUARIO
        /*firebaseAuth.signInWithEmailAndPassword("batata@gmail.com","batata123")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){//sucesso no cadastro
                            Log.i("BATATA","SUCESSO");
                        }else {//erro no cadastro
                            Log.i("BATATA","ERRO");
                        }
                    }
                });
        */

        //DESLOGAR O USUARIO
        firebaseAuth.signOut();

        //VERIFICAR SE USUARIO ESTA LOGADO
        if(firebaseAuth.getCurrentUser()!=null){
            Log.i("BATATA","SUCESSO");
        }else {//erro no cadastro
            Log.i("BATATA","ERRO");
        }



    }
}
