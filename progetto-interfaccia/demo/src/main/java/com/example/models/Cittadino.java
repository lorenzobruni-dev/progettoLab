package com.example.models;

public class Cittadino {
    String nome;
    String cognome;
    String codiceFiscale;
    String email;
    String userid;
    String password;
    int idVaccinazione;
    boolean isVaccinato;
    boolean isRegistrato;

    public Cittadino(String nome, String cognome, String codiceFiscale, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
        this.userid = "";
        this.password = "";
        this.isVaccinato = false;
        this.isRegistrato = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdVaccinazione() {
        return idVaccinazione;
    }

    public void setIdVaccinazione(int idVaccinazione) {
        this.idVaccinazione = idVaccinazione;
    }

    public boolean isVaccinato() {
        return isVaccinato;
    }

    public void setVaccinato(boolean isVaccinato) {
        this.isVaccinato = isVaccinato;
    }

    public boolean isRegistrato() {
        return isRegistrato;
    }

    public void setRegistrato(boolean isRegistrato) {
        this.isRegistrato = isRegistrato;
    }

    @Override
    public String toString() {
        return "Cittadino [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", email="
                + email + ", userid=" + userid + ", password=" + password + ", idVaccinazione=" + idVaccinazione
                + ", isVaccinato=" + isVaccinato + ", isRegistrato=" + isRegistrato + "]";
    }
}
