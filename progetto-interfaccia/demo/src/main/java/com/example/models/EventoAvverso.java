package com.example.models;

public class EventoAvverso {
    String evento;
    short severità;
    String noteOpzionali;
    
    public EventoAvverso(String evento, short severità, String noteOpzionali) {
        this.evento = evento;
        this.severità = severità;
        this.noteOpzionali = noteOpzionali;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public short getSeverità() {
        return severità;
    }

    public void setSeverità(short severità) {
        this.severità = severità;
    }

    public String getNoteOpzionali() {
        return noteOpzionali;
    }

    public void setNoteOpzionali(String noteOpzionali) {
        this.noteOpzionali = noteOpzionali;
    }
}
