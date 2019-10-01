package br.com.teste.app_paises.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.app_paises.model.Pais;

public class PaisDao {

    private final static List<Pais> ppaises = new ArrayList<>();

    public void salva(Pais pais) {

        ppaises.add(pais);

    }

    public List<Pais> todos(){

        return new ArrayList<>(ppaises);

    }

}
