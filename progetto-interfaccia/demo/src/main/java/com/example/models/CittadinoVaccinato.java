package com.example.models;

public class CittadinoVaccinato extends Cittadino {

    String data;
    TipoVaccino tipoVaccino;
    String nomeCentro;

    public CittadinoVaccinato(String nome, String cognome, String codiceFiscale, String idVaccinazione) {
        super(nome, cognome, codiceFiscale, idVaccinazione);
    }

    public CittadinoVaccinato(String nome, String cognome, String codiceFiscale, String idVaccinazione, String data, TipoVaccino tipoVaccino, String nomeCentro) {
        super(nome, cognome, codiceFiscale, idVaccinazione);
        this.data = data;
        this.tipoVaccino = tipoVaccino;
        this.nomeCentro = nomeCentro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TipoVaccino getTipoVaccino() {
        return tipoVaccino;
    }

    public void setTipoVaccino(TipoVaccino tipoVaccino) {
        this.tipoVaccino = tipoVaccino;
    }

    public String getNomeCentro() {
        return nomeCentro;
    }

    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }
}
