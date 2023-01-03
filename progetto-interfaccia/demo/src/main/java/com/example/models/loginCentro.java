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
Class che restituisce i metodi get and set per la parte dei loginOperatori
@author Team
@see loginCentro
 */
public class loginCentro implements Serializable{
    String user; // username
    String password; //password
    
    /**
    Costruttore classe
    @see loginCentro
    */
    public loginCentro(String user, String password) {
        this.user = user;
        this.password = password;
    }

     /**
    GetUsername
    @see loginCentro
    */
    public String getUser() {
        return user;
    }

     /**
    Metodo toString per la stampa dei dati del loginCentro nella sezione Server
    @see loginCentro
    @return valore in toString dell'indirizzo
    */
    @Override
    public String toString() {
        return "loginCentro [user=" + user + ", password=" + password + "]";
    }

    /**
    SetUsername
    @see loginCentro
    */
    public void setUser(String user) {
        this.user = user;
    }

    /**
    GetPassword
    @see loginCentro
    */
    public String getPassword() {
        return password;
    }
    /**
    SetPassword
    @see loginCentro
    */
    public void setPassword(String password) {
        this.password = password;
    }
}
