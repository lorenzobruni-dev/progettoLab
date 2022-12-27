package com.example.models;

import java.io.Serializable;

public class Indirizzo implements Serializable {
    Qualificatore qualificatore;
    String nome;
    String numeroCivico;
    String comune;
    String provincia;
    String cap;
    
    public Indirizzo(Qualificatore qualificatore, String nome, String numeroCivico, String comune, String provincia,
            String cap) {
        this.qualificatore = qualificatore;
        this.nome = nome;
        this.numeroCivico = numeroCivico;
        this.comune = comune;
        this.provincia = provincia;
        this.cap = cap;
    }

    public Qualificatore getQualificatore() {
        return qualificatore;
    }

    public void setQualificatore(Qualificatore qualificatore) {
        this.qualificatore = qualificatore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return "Indirizzo [qualificatore=" + qualificatore + ", nome=" + nome + ", numeroCivico=" + numeroCivico
                + ", comune=" + comune + ", provincia=" + provincia + ", cap=" + cap + "]";
    }
}
