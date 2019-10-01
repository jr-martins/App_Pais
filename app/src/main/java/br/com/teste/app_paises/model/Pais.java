package br.com.teste.app_paises.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Pais implements Serializable {


    private final String pais;
    private final String continente;

    public Pais(String pais, String continente) {

        this.pais = pais;
        this.continente = continente;
    }

    public String getPais() {
        return pais;
    }

    public String getContinente() {
        return continente;
    }

    @NonNull
    @Override
    public String toString(){

        return pais;
    }

}
