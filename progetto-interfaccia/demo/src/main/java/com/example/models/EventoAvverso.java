package com.example.models;

public class EventoAvverso {
    String evento;
    int severità;
    String noteOpzionali;
    
    public EventoAvverso(String evento, int severità, String noteOpzionali) {
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

    public int getSeverità() {
        return severità;
    }

    public void setSeverità(int severità) {
        this.severità = severità;
    }

    public String getNoteOpzionali() {
        return noteOpzionali;
    }

    public void setNoteOpzionali(String noteOpzionali) {
        this.noteOpzionali = noteOpzionali;
    }

    @Override
    public String toString() {
        return "EventoAvverso [evento=" + evento + ", severità=" + severità + ", noteOpzionali=" + noteOpzionali + "]";
    }
}
