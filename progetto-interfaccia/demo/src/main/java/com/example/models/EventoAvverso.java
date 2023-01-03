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
Class che restituisce i metodi get and set per gli eventiAvversi
@author Team
@see EventoAvverso
 */
public class EventoAvverso implements Serializable {
    String evento; //eventoStringa
    int severità; // severità dell'evento avverso
    String noteOpzionali; // note aggiuntive all'evento avverso

    /**
    Costruttore classe
    @see EventoAvverso
    */
    public EventoAvverso(String evento, int severità, String noteOpzionali) {
        this.evento = evento;
        this.severità = severità;
        this.noteOpzionali = noteOpzionali;
    }

    /**
    GetEvento
    @see EventoAvverso
    */
    public String getEvento() {
        return evento;
    }

    /**
    SetEvento
    @see EventoAvverso
    */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
    GetSeverità
    @see EventoAvverso
    */
    public int getSeverità() {
        return severità;
    }

    /**
    SetSeverità
    @see EventoAvverso
    */
    public void setSeverità(int severità) {
        this.severità = severità;
    }

     /**
    GetNoteOpzionali
    @see EventoAvverso
    */
    public String getNoteOpzionali() {
        return noteOpzionali;
    }

    /**
    SetNoteOpzionali
    @see EventoAvverso
    */
    public void setNoteOpzionali(String noteOpzionali) {
        this.noteOpzionali = noteOpzionali;
    }

     /**
    Metodo toString per la stampa degli eventi avversi
    @see Indirizzo
    @return valore in toString degli eventi avversi
    */
    @Override
    public String toString() {
        return "EventoAvverso [evento=" + evento + ", severità=" + severità + ", noteOpzionali=" + noteOpzionali + "]";
    }
}
