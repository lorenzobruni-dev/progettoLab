package com.example.models;

public class CittadinoRegistrato extends Cittadino{

    String email;
    String userid;
    String password;

    public CittadinoRegistrato(String nome, String cognome, String codiceFiscale, String idVaccinazione) {
        super(nome, cognome, codiceFiscale, idVaccinazione);
    }

    public CittadinoRegistrato(String nome, String cognome, String codiceFiscale, String idVaccinazione, String email,
            String userid, String password) {
        super(nome, cognome, codiceFiscale, idVaccinazione);
        this.email = email;
        this.userid = userid;
        this.password = password;
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

    @Override
    public String toString() {
        return "CittadinoRegistrato: [nome=" + nome + ", cognome=" + cognome + ", codice fiscale=" + codiceFiscale + ", id=" + idVaccinazione + 
        ", email=" + email + ", userid=" + userid + ", password=" + password + "]";
    }
}
