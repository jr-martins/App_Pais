package br.com.teste.app_paises.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.teste.app_paises.dao.PaisDao;
import br.com.teste.app_paises.R;
import br.com.teste.app_paises.model.Pais;

public class FormularioPaisActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo País";
    private EditText campoPais;
    private EditText campoContinente;
    private Pais pppais;

    private final PaisDao dao = new PaisDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pais);
        setTitle(TITULO_APPBAR);


        inicializacaoCampos();
        configuraBotaoSalvar();

        Intent dados = getIntent();
        pppais = (Pais) dados.getSerializableExtra("pais");
        campoPais.setText(pppais.getPais());
        campoContinente.setText(pppais.getContinente());














    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_pais_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Pais paisCriado = preenchePais();
//                salva(paisCriado);

                preenchePais();
                dao.edita(pppais);
                finish();

            }
        });
    }

    private void inicializacaoCampos() {
        campoPais = findViewById(R.id.activity_formulario_pais_nome);
        campoContinente = findViewById(R.id.activity_formulario_continente);
    }

    private void salva(Pais paisCriado) {
        dao.salva(paisCriado);
        finish();
    }


    private void preenchePais() {
        String pais = campoPais.getText().toString();
        String continente = campoContinente.getText().toString();

        pppais.setPais(pais);
        pppais.setContinente(continente);





    }
}
