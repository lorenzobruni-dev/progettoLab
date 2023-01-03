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
Class che restituisce i metodi get and set per il CentroVaccinale
@author Team
@see CentroVaccinale
 */
public class CentroVaccinale implements Serializable {
    String nome; //nomeCentro
    Indirizzo indirizzo; //riferimento all'enum Indirizzo
    TipoCentro tipoCentro; //riferimento all'enum TipoCentro

    /**
    Costruttore della classe
    @see CentroVaccinale
    */
    public CentroVaccinale(String nome) {
        this.nome = nome;
    }

    /**
    Costruttore della classe
    @see CentroVaccinale
    */
    public CentroVaccinale(String nome, Indirizzo indirizzo, TipoCentro tipoCentro) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.tipoCentro = tipoCentro;
    }

    /**
    GetNome
    @see CentroVaccinale
    */
    public String getNome() {
        return nome;
    }

    /**
    SetNome
    @see CentroVaccinale
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    GetIndirizzo
    @see CentroVaccinale
    */
    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    /**
    SetIndirizzo
    @see CentroVaccinale
    */
    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
    GetTipoCentro
    @see CentroVaccinale
    */
    public TipoCentro getTipoCentro() {
        return tipoCentro;
    }   

    /**
    SetTipoCentro
    @see CentroVaccinale
    */
    public void setTipoCentro(TipoCentro tipoCentro) {
        this.tipoCentro = tipoCentro;
    }

     /**
    Metodo toString per la stampa dei dati del CentroVaccinale
    @see CentroVaccinale
    @return valore in toString del Centro
    */
    @Override
    public String toString() {
        return "CentroVaccinale [nome=" + nome + ", indirizzo=" + indirizzo + ", tipoCentro=" + tipoCentro + "]";
    }
}
