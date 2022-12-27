package com.example.models;

import java.io.Serializable;

public class CentroVaccinale implements Serializable {
    String nome;
    Indirizzo indirizzo;
    TipoCentro tipoCentro;

    public CentroVaccinale(String nome) {
        this.nome = nome;
    }

    public CentroVaccinale(String nome, Indirizzo indirizzo, TipoCentro tipoCentro) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.tipoCentro = tipoCentro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public TipoCentro getTipoCentro() {
        return tipoCentro;
    }

    public void setTipoCentro(TipoCentro tipoCentro) {
        this.tipoCentro = tipoCentro;
    }

    @Override
    public String toString() {
        return "CentroVaccinale [nome=" + nome + ", indirizzo=" + indirizzo + ", tipoCentro=" + tipoCentro + "]";
    }
}
