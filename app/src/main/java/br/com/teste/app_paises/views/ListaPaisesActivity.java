package br.com.teste.app_paises.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.List;

import br.com.teste.app_paises.R;
import br.com.teste.app_paises.dao.PaisDao;
import br.com.teste.app_paises.model.Pais;

public class ListaPaisesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Países";
    private final PaisDao dao = new PaisDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        setTitle(TITULO_APPBAR);

        configuraFabNovoPais();

    }

    private void configuraFabNovoPais() {
        FloatingActionButton botaoNovoPais = findViewById(R.id.activity_lista_fab_novo_pais);
        botaoNovoPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                abreFormularioPaisActivity();
            }
        });
    }

    private void abreFormularioPaisActivity() {
        startActivity(new Intent(this, FormularioPaisActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePaises = findViewById(R.id.activity_lista_paises_listview);
        final List<Pais> paises = dao.todos();
        listaDePaises.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                paises));

        listaDePaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Pais paisEscolhido = paises.get(posicao);
                Intent vaiParaFormularioActivity = new Intent(ListaPaisesActivity.this, FormularioPaisActivity.class);

                vaiParaFormularioActivity.putExtra("pais", paisEscolhido);

                startActivity(vaiParaFormularioActivity);


            }
        });

    }

}
