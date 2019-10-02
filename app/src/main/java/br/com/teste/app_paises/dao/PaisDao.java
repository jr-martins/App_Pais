package br.com.teste.app_paises.dao;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.app_paises.model.Pais;

public class PaisDao {

    private final static List<Pais> npaises = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void toSave(Pais pais) {
        pais.setId(contadorDeIds);
        npaises.add(pais);
        updateId();
    }

    private void updateId() {
        contadorDeIds++;
    }

    public void edit(Pais pais){
        Pais paisEncontrado = searchCountryId(pais);
        if(paisEncontrado != null){

           int posicaoDoPais = npaises.indexOf(paisEncontrado);
           npaises.set(posicaoDoPais, pais);

        }
    }

    @Nullable
    private Pais searchCountryId(Pais pais) {
        Pais paisEncontrado = null;
        for(Pais p : npaises){

            if(p.getId() == pais.getId()){
                return p;
            }
        }
        return null;
    }

    public List<Pais> all(){
        return new ArrayList<>(npaises);
    }

}
