package br.com.teste.app_paises.model;

import androidx.annotation.NonNull;

public class Pais {


    private final String pais;
    private final String continente;

    public Pais(String pais, String continente) {

        this.pais = pais;
        this.continente = continente;
    }

    @NonNull
    @Override
    public String toString(){

        return pais;
    }

}
