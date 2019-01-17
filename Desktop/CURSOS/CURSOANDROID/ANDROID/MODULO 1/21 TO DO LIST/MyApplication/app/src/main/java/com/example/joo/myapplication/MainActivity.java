package com.example.joo.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {


    private EditText et;
    private Button btn;
    private ListView list;
    private SQLiteDatabase banco;
    private ArrayAdapter<String> adapter;
    private ArrayList<String>itens;
    private ArrayList<Integer>ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            list = (ListView) findViewById(R.id.list);
            et = (EditText) findViewById(R.id.editText2);
            btn = (Button) findViewById(R.id.button2);
            banco = openOrCreateDatabase("app", MODE_PRIVATE, null);

            banco.execSQL("CREATE TABLE IF NOT EXISTS tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   salvarTarefa(et.getText().toString());
                    et.setText("");
                }
            });
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    removerTarefa(ids.get(position));
                }
            });

            recuperarTarefas();

        }catch (Exception ex){ex.printStackTrace();}

    }


    public void salvarTarefa(String texto){
        try{
            if(texto.isEmpty()){
                Toast.makeText(this, "DIGITE UMA TAREFA", Toast.LENGTH_SHORT).show();
            }else {
                banco.execSQL("INSERT INTO tarefas(tarefa) VALUES ('" + texto + "')");
                recuperarTarefas();
                Toast.makeText(this, "TAREFA SALVA!", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    private void recuperarTarefas(){
        try{
            ids= new ArrayList<>();
            itens = new ArrayList<String>();
            adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_2, android.R.id.text1,itens);
            list.setAdapter(adapter);

            Cursor cursor = banco.rawQuery("SELECT * FROM tarefas ORDER BY id DESC",null);

            cursor.moveToFirst();
            while (cursor!=null) {

                itens.add(cursor.getString(cursor.getColumnIndex("tarefa")));
                ids.add(cursor.getInt(cursor.getColumnIndex("id")));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void removerTarefa(Integer id){
        try{

            banco.execSQL("DELETE FROM tarefas WHERE id="+id+"");
            recuperarTarefas();
            Toast.makeText(this, "TAREFA REMOVIDA!", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
