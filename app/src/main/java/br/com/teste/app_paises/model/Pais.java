package br.com.teste.app_paises.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Pais implements Serializable {


    private int id = 0;
    private  String pais;
    private  String continente;

    public Pais() {

    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

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


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return id > 0;

    }
}
