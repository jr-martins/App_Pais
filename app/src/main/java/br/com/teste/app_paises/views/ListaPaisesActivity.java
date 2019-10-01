package br.com.teste.app_paises.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.teste.app_paises.R;
import br.com.teste.app_paises.dao.PaisDao;

public class ListaPaisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);




        setTitle("Lista de Países");

       FloatingActionButton botaoNovoPais = findViewById(R.id.activity_lista_fab_novo_pais);
       botaoNovoPais.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               startActivity(new Intent(ListaPaisesActivity.this,
                       FormularioPaisActivity.class));
           }
       });




    }

    @Override
    protected void onResume() {
        super.onResume();

        PaisDao dao = new PaisDao();
        ListView listaDePaises = findViewById(R.id.activity_lista_paises_listview);
        listaDePaises.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }



}
