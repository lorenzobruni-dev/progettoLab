/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */

//package globale com.example.models
package com.example.models;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
Class che restituisce i metodi get and set per la visualizzazione dei dati dei centri nella table dedicata
@author Team
@see CentroVaccinaleSimple
 */
public class CentroVaccinaleSimple {

    private SimpleStringProperty nome; //nomeCentro
    private SimpleStringProperty qualificatore; //qualificatore viaCentro
    private SimpleStringProperty indirizzo; //nome viaCentro
    private SimpleIntegerProperty numCivico; //numCivico viaCentro
    private SimpleStringProperty comune; //comune viaCentro
    private SimpleStringProperty provincia; //provincia viaCentro
    private SimpleIntegerProperty cap; //cap viaCentro
    private SimpleStringProperty tipologia; //tipologia centro
    private SimpleIntegerProperty eventi; //eventiAvversi centro
    private SimpleDoubleProperty media; //mediaEventiAvversi centro

     /**
    Costruttore della classe
    @see CentroVaccinaleSimple
    */
    public CentroVaccinaleSimple(String nome, String qualificatore,
            String indirizzo, Integer numCivico, String comune,
            String provincia, Integer cap, String tipologia, Integer eventi, Double media) {
        this.nome = new SimpleStringProperty(nome);
        this.qualificatore = new SimpleStringProperty(qualificatore);
        this.indirizzo = new SimpleStringProperty(indirizzo);
        this.numCivico = new SimpleIntegerProperty(numCivico);
        this.comune = new SimpleStringProperty(comune);
        this.provincia = new SimpleStringProperty(provincia);
        this.cap = new SimpleIntegerProperty(cap);
        this.tipologia = new SimpleStringProperty(tipologia);
        this.eventi = new SimpleIntegerProperty(eventi);
        this.media = new SimpleDoubleProperty(media);
    }
    
    /**
    GetNome
    @see CentroVaccinaleSimple
    */
    public String getNome() {
        return nome.get();
    }

    /**
    SetNome
    @see CentroVaccinaleSimple
    */
    public void setNome(String nome) {
        this.nome = new SimpleStringProperty(nome);
    }

    /**
    GetQualificatore
    @see CentroVaccinaleSimple
    */
    public String getQualificatore() {
        return qualificatore.get();
    }

    /**
    SetQualificatore
    @see CentroVaccinaleSimple
    */
    public void setQualificatore(String qualificatore) {
        this.qualificatore = new SimpleStringProperty(qualificatore);
    }

    /**
    GetIndirizzo
    @see CentroVaccinaleSimple
    */
    public String getIndirizzo() {
        return indirizzo.get();
    }

    /**
    SetIndirizzo
    @see CentroVaccinaleSimple
    */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = new SimpleStringProperty(indirizzo);
    }

    /**
    GetNumCivico
    @see CentroVaccinaleSimple
    */
    public int getNumCivico() {
        return numCivico.get();
    }

    /**
    SetNumCivico
    @see CentroVaccinaleSimple
    */
    public void setNumCivico(int numCivico) {
        this.numCivico = new SimpleIntegerProperty(numCivico);
    }

    /**
    GetComune
    @see CentroVaccinaleSimple
    */
    public String getComune() {
        return comune.get();
    }

    /**
    SetComune
    @see CentroVaccinaleSimple
    */
    public void setComune(String comune) {
        this.comune = new SimpleStringProperty(comune);
    }

    /**
    GetProvincia
    @see CentroVaccinaleSimple
    */
    public String getProvincia() {
        return provincia.get();
    }

    /**
    SetProvincia
    @see CentroVaccinaleSimple
    */
    public void setProvincia(String provincia) {
        this.provincia = new SimpleStringProperty(provincia);
    }

    /**
    GetCAP
    @see CentroVaccinaleSimple
    */
    public int getCAP() {
        return cap.get();
    }

     /**
    SetCAP
    @see CentroVaccinaleSimple
    */
    public void setCAP(int cap) {
        this.cap = new SimpleIntegerProperty(cap);
    }

    /**
    GetTipologia
    @see CentroVaccinaleSimple
    */
    public String getTipologia() {
        return tipologia.get();
    }

    /**
    SetTipologia
    @see CentroVaccinaleSimple
    */
    public void setTipologia(String tipologia) {
        this.tipologia = new SimpleStringProperty(tipologia);
    }

    /**
    GetEventi
    @see CentroVaccinaleSimple
    */
    public int getEventi() {
        return eventi.get();
    }

    /**
    SetEventi
    @see CentroVaccinaleSimple
    */
    public void setEventi(int eventi) {
        this.eventi = new SimpleIntegerProperty(eventi);
    }

    /**
    GetMedia
    @see CentroVaccinaleSimple
    */
    public double getMedia() {
        return media.get();
    }

    /**
    SetMedia
    @see CentroVaccinaleSimple
    */
    public void setMedia(double media) {
        this.media = new SimpleDoubleProperty(media);
    }
}
