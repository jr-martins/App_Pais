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

import static br.com.teste.app_paises.views.ConstantesActivities.CHAVE_PAIS;


public class FormularioPaisActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR_NOVO_PAIS = "Adiciona País";
    private static final String TITULO_APPBAR_EDITA_PAIS = "Edita País" ;
    private EditText campoPais;
    private EditText campoContinente;
    private Pais pppais;

    private final PaisDao dao = new PaisDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pais);
        inicializacaoCampos();
        configuraBotaoSalvar();
        carregaPais();


    }

    private void carregaPais() {
        Intent dados = getIntent();
        if(dados.hasExtra(CHAVE_PAIS)){
            setTitle(TITULO_APPBAR_EDITA_PAIS);

            pppais = (Pais) dados.getSerializableExtra(CHAVE_PAIS);
            preencheCampos();

        }else{
            setTitle(TITULO_APPBAR_NOVO_PAIS);
            pppais = new Pais();
        }
    }

    private void preencheCampos() {
        campoPais.setText(pppais.getPais());
        campoContinente.setText(pppais.getContinente());
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_pais_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizaFormulario();
            }
        });
    }

    private void finalizaFormulario() {
        preenchePais();

        if(pppais.temIdValido()){
            dao.edita(pppais);

        }else {
            dao.salva(pppais);

        }
        finish();
    }

    private void inicializacaoCampos() {
        campoPais = findViewById(R.id.activity_formulario_pais_nome);
        campoContinente = findViewById(R.id.activity_formulario_continente);
    }




    private void preenchePais() {
        String pais = campoPais.getText().toString();
        String continente = campoContinente.getText().toString();

        pppais.setPais(pais);
        pppais.setContinente(continente);





    }
}
