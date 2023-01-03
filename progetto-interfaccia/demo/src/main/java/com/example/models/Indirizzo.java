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
Class che restituisce i metodi get and set per la parte dell'Indirizzo
@author Team
@see Indirizzo
 */
public class Indirizzo implements Serializable {
    Qualificatore qualificatore; //qualificatore - indirizzo
    String nome; //nome - indirizzo
    String numeroCivico; //numeroCivico - indirizzo
    String comune; //comune - indirizzo
    String provincia; //provincia - indirizzo
    String cap; //cap - indirizzo
    
    /**
    Costruttore classe
    @see Indirizzo
    */
    public Indirizzo(Qualificatore qualificatore, String nome, String numeroCivico, String comune, String provincia,
            String cap) {
        this.qualificatore = qualificatore;
        this.nome = nome;
        this.numeroCivico = numeroCivico;
        this.comune = comune;
        this.provincia = provincia;
        this.cap = cap;
    }

    /**
    GetQualificatore
    @see Indirizzo
    */
    public Qualificatore getQualificatore() {
        return qualificatore;
    }

    /**
    SetQualificatore
    @see Indirizzo
    */
    public void setQualificatore(Qualificatore qualificatore) {
        this.qualificatore = qualificatore;
    }

    /**
    GetNome
    @see Indirizzo
    */
    public String getNome() {
        return nome;
    }

    /**
    SetNome
    @see Indirizzo
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    GetNumeroCivico
    @see Indirizzo
    */
    public String getNumeroCivico() {
        return numeroCivico;
    }

    /**
    SetNumeroCivico
    @see Indirizzo
    */
    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    /**
    GetComune
    @see Indirizzo
    */
    public String getComune() {
        return comune;
    }

    /**
    SetComune
    @see Indirizzo
    */
    public void setComune(String comune) {
        this.comune = comune;
    }

    /**
    GetProvincia
    @see Indirizzo
    */
    public String getProvincia() {
        return provincia;
    }

    /**
    SetProvincia
    @see Indirizzo
    */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
    GetCap
    @see Indirizzo
    */
    public String getCap() {
        return cap;
    }

    /**
    SetCap
    @see Indirizzo
    */
    public void setCap(String cap) {
        this.cap = cap;
    }

     /**
    Metodo toString per la stampa dei dati dell'Indirizzo
    @see Indirizzo
    @return valore in toString dell'indirizzo
    */
    @Override
    public String toString() {
        return "Indirizzo [qualificatore=" + qualificatore + ", nome=" + nome + ", numeroCivico=" + numeroCivico
                + ", comune=" + comune + ", provincia=" + provincia + ", cap=" + cap + "]";
    }
}

