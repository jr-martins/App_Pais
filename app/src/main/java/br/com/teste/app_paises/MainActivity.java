package br.com.teste.app_paises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> paises = new ArrayList<>(
                Arrays.asList("Brasil", "Argentina", "Chile"));

        ListView listaDePaises = findViewById(R.id.activity_main_lista_de_paises);

        listaDePaises.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                paises));

    }
}
