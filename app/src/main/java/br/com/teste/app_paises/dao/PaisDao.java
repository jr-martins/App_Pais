package br.com.teste.app_paises.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.app_paises.model.Pais;

public class PaisDao {

    private final static List<Pais> ppaises = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva(Pais pais) {


        pais.setId(contadorDeIds);
        ppaises.add(pais);
        contadorDeIds++;

    }

    public void edita(Pais pais){
        Pais paisEncontrado = null;
        for(Pais p : ppaises){

            if(p.getId() == pais.getId()){
                paisEncontrado = p;


            }

        }
        if(paisEncontrado != null){

           int posicaoDoPais = ppaises.indexOf(paisEncontrado);
           ppaises.set(posicaoDoPais, pais);

        }

    }

    public List<Pais> todos(){

        return new ArrayList<>(ppaises);

    }

}
