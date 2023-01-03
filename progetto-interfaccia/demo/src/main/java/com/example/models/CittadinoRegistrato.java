/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */

//package globale com.example.models
package com.example.models;

/**
Class che restituisce i metodi get and set per il CittadinoRegistrato
@author Team
@see CittadinoRegistrato
 */
public class CittadinoRegistrato extends Cittadino{

    String email; //email di registrazione
    String userid; //username di registrazione
    String password; // password di registrazione

    /**
    Costruttore della classe estesa
    @see CittadinoRegistrato
    */
    public CittadinoRegistrato(String nome, String cognome, String codiceFiscale, String idVaccinazione) {
        super(nome, cognome, codiceFiscale, idVaccinazione);
    }

    /**
    Costruttore della classe
    @see CittadinoRegistrato
    */
    public CittadinoRegistrato(String nome, String cognome, String codiceFiscale, String idVaccinazione, String email,
            String userid, String password) {
        super(nome, cognome, codiceFiscale, idVaccinazione);
        this.email = email;
        this.userid = userid;
        this.password = password;
    }

    /**
    GetEmail
    @see CittadinoRegistrato
    */
    public String getEmail() {
        return email;
    }

    /**
    SetEmail
    @see CittadinoRegistrato
    */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
    GetUserid
    @see CittadinoRegistrato
    */
    public String getUserid() {
        return userid;
    }

    /**
    SetUserid
    @see CittadinoRegistrato
    */
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    /**
    GetPassword
    @see CittadinoRegistrato
    */
    public String getPassword() {
        return password;
    }

    /**
    SetPassword
    @see CittadinoRegistrato
    */
    public void setPassword(String password) {
        this.password = password;
    }

     /**
    Metodo toString per la stampa dei dati del CittadinoRegistrato
    @see CittadinoRegistrato
    @return valore in toString del Cittadino
    */
    @Override
    public String toString() {
        return "CittadinoRegistrato: [nome=" + nome + ", cognome=" + cognome + ", codice fiscale=" + codiceFiscale + ", id=" + idVaccinazione + 
        ", email=" + email + ", userid=" + userid + ", password=" + password + "]";
    }
}
