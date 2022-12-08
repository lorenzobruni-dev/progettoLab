package com.example.models;

import java.io.Serializable;

public class Cittadino implements Serializable{
    String nome;
    String cognome;
    String codiceFiscale;
    String idVaccinazione;

    public Cittadino(String nome, String cognome, String codiceFiscale, String idVaccinazione) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.idVaccinazione = idVaccinazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getIdVaccinazione() {
        return idVaccinazione;
    }

    public void setIdVaccinazione(String idVaccinazione) {
        this.idVaccinazione = idVaccinazione;
    }
}
