/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */

//package globale com.example.models
package com.example.models;

/**
Class che restituisce i metodi get and set per il CittadinoVaccinato
@author Team
@see CittadinoVaccinato
 */
public class CittadinoVaccinato extends Cittadino {

    String data; //dataVaccinazione
    TipoVaccino tipoVaccino; //riferimento all'enum TipoVaccino
    String nomeCentro; //nome del centro associato

     /**
    Costruttore della classe estesa
    @see CittadinoVaccinato
    */
    public CittadinoVaccinato(String nome, String cognome, String codiceFiscale, String idVaccinazione) {
        super(nome, cognome, codiceFiscale, idVaccinazione);
    }

     /**
    Costruttore classe
    @see CittadinoVaccinato
    */
    public CittadinoVaccinato(String nome, String cognome, String codiceFiscale, String idVaccinazione, String data, TipoVaccino tipoVaccino, String nomeCentro) {
        super(nome, cognome, codiceFiscale, idVaccinazione);
        this.data = data;
        this.tipoVaccino = tipoVaccino;
        this.nomeCentro = nomeCentro;
    }

    /**
    GetData
    @see CittadinoVaccinato
    */
    public String getData() {
        return data;
    }

     /**
    SetData
    @see CittadinoVaccinato
    */
    public void setData(String data) {
        this.data = data;
    }

     /**
    GetTipoVaccino
    @see CittadinoVaccinato
    */
    public TipoVaccino getTipoVaccino() {
        return tipoVaccino;
    }

    /**
    SetTipoVaccino
    @see CittadinoVaccinato
    */
    public void setTipoVaccino(TipoVaccino tipoVaccino) {
        this.tipoVaccino = tipoVaccino;
    }

     /**
    GetNomeCentro
    @see CittadinoVaccinato
    */
    public String getNomeCentro() {
        return nomeCentro;
    }
    /**
    SetNomeCentro
    @see CittadinoVaccinato
    */
    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }
}
