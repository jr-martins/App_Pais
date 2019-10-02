package br.com.teste.app_paises.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.List;

import br.com.teste.app_paises.R;
import br.com.teste.app_paises.dao.PaisDao;
import br.com.teste.app_paises.model.Pais;

import static br.com.teste.app_paises.views.ConstantesActivities.CHAVE_PAIS;

public class ListaPaisesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Países";

    private final PaisDao dao = new PaisDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        setTitle(TITULO_APPBAR);

        setUpFabNewCountry();

        //inicio com um item na lista
        dao.toSave(new Pais("Brasil", "Sul"));

    }

    private void setUpFabNewCountry() {
        FloatingActionButton botaoNovoPais = findViewById(R.id.activity_lista_fab_novo_pais);
        botaoNovoPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFormInsertsCountry();
            }
        });
    }

    private void openFormInsertsCountry() {
        startActivity(new Intent(this, FormularioPaisActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpList();
    }

    private void setUpList() {
        ListView listaDePaises = findViewById(R.id.activity_lista_paises_listview);
        final List<Pais> paises = dao.all();
        configuraAdapter(listaDePaises, paises);
        clickListenerPerItemConfiguration(listaDePaises);

    }

    private void clickListenerPerItemConfiguration(ListView listaDePaises) {
        listaDePaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Pais paisEscolhido = (Pais) adapterView.getItemAtPosition(posicao);
                openFormEditModeCountry(paisEscolhido);


            }
        });
    }

    private void openFormEditModeCountry(Pais paisEscolhido) {
        Intent vaiParaFormularioActivity = new Intent(ListaPaisesActivity.this, FormularioPaisActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_PAIS, paisEscolhido);
        startActivity(vaiParaFormularioActivity);
    }

    private void configuraAdapter(ListView listaDePaises, List<Pais> paises) {
        listaDePaises.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                paises));
    }

}
