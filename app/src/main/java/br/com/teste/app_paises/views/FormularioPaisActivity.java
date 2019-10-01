package br.com.teste.app_paises.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.teste.app_paises.dao.PaisDao;
import br.com.teste.app_paises.R;
import br.com.teste.app_paises.model.Pais;

public class FormularioPaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pais);

        final PaisDao dao = new PaisDao();

        Button botaoSalvar = findViewById(R.id.activity_formulario_pais_botao_salvar);
        final EditText campoPais = findViewById(R.id.activity_formulario_pais);
        final EditText campoContinente = findViewById(R.id.activity_formulario_continente);


        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pais = campoPais.getText().toString();
                String continente = campoContinente.getText().toString();

                Pais paisCriado = new Pais(pais, continente);

                dao.salva(paisCriado);

                finish();






            }
        });
    }
}
