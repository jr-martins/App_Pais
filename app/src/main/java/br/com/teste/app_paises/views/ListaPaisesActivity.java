package br.com.teste.app_paises.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.teste.app_paises.R;

public class ListaPaisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        setTitle("Lista de Países");
        List<String> paises = new ArrayList<>(
                Arrays.asList("Brasil", "Argentina", "Chile"));

        ListView listaDePaises = findViewById(R.id.activity_lista_paises_listview);

        listaDePaises.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                paises));

    }
}
