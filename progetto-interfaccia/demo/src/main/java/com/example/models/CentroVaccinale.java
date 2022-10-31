package com.example.models;

public class CentroVaccinale {
    String nome;
    Indirizzo indirizzo;
    TipoCentro tipoCentro;
    
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
}
