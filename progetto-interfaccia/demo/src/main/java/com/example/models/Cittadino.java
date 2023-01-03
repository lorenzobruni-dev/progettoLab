/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */

//package globale com.example.models
package com.example.models;
import java.io.Serializable;

/**
Class che restituisce i metodi get and set per il Cittadino
@author Team
@see Cittadino
 */
public class Cittadino implements Serializable{
    String nome; //nome - cittadino
    String cognome; //cognome - cittadino
    String codiceFiscale; //codice_fiscale - cittadino
    String idVaccinazione; //id_vaccinazione - cittadino

     /**
    Costruttore della classe
    @see Cittadino
    */
    public Cittadino(String nome, String cognome, String codiceFiscale, String idVaccinazione) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.idVaccinazione = idVaccinazione;
    }

     /**
    GetNome
    @see Cittadino
    */
    public String getNome() {
        return nome;
    }

    /**
    SetNome
    @see Cittadino
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    GetCognome
    @see Cittadino
    */
    public String getCognome() {
        return cognome;
    }

    /**
    SetCognome
    @see Cittadino
    */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
    GetCodiceFiscale
    @see Cittadino
    */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
    SetCodiceFiscale
    @see Cittadino
    */
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    /**
    GetIdVaccinazione
    @see Cittadino
    */
    public String getIdVaccinazione() {
        return idVaccinazione;
    }
    /**
    SetIdVaccinazione
    @see Cittadino
    */
    public void setIdVaccinazione(String idVaccinazione) {
        this.idVaccinazione = idVaccinazione;
    }
}
