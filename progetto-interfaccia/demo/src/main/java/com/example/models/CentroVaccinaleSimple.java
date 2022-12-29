package com.example.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CentroVaccinaleSimple {

    private SimpleStringProperty nome;
    private SimpleStringProperty qualificatore;
    private SimpleStringProperty indirizzo;
    private SimpleIntegerProperty numCivico;
    private SimpleStringProperty comune;
    private SimpleStringProperty provincia;
    private SimpleIntegerProperty cap;
    private SimpleStringProperty tipologia;

    public CentroVaccinaleSimple(String nome, String qualificatore,
            String indirizzo, Integer numCivico, String comune,
            String provincia, Integer cap, String tipologia) {
        this.nome = new SimpleStringProperty(nome);
        this.qualificatore = new SimpleStringProperty(qualificatore);
        this.indirizzo = new SimpleStringProperty(indirizzo);
        this.numCivico = new SimpleIntegerProperty(numCivico);
        this.comune = new SimpleStringProperty(comune);
        this.provincia = new SimpleStringProperty(provincia);
        this.cap = new SimpleIntegerProperty(cap);
        this.tipologia = new SimpleStringProperty(tipologia);
    }
    
    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome = new SimpleStringProperty(nome);
    }

    public String getQualificatore() {
        return qualificatore.get();
    }

    public void setQualificatore(String qualificatore) {
        this.qualificatore = new SimpleStringProperty(qualificatore);
    }

    public String getIndirizzo() {
        return indirizzo.get();
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = new SimpleStringProperty(indirizzo);
    }

    public int getNumCivico() {
        return numCivico.get();
    }

    public void setNumCivico(int numCivico) {
        this.numCivico = new SimpleIntegerProperty(numCivico);
    }

    public String getComune() {
        return comune.get();
    }

    public void setComune(String comune) {
        this.comune = new SimpleStringProperty(comune);
    }

    public String getProvincia() {
        return provincia.get();
    }

    public void setProvincia(String provincia) {
        this.provincia = new SimpleStringProperty(provincia);
    }

    public int getCAP() {
        return cap.get();
    }

    public void setCAP(int cap) {
        this.cap = new SimpleIntegerProperty(cap);
    }

    public String getTipologia() {
        return tipologia.get();
    }

    public void setTipologia(String tipologia) {
        this.tipologia = new SimpleStringProperty(tipologia);
    }
}
