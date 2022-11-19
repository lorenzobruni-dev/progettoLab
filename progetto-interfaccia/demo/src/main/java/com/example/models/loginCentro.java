package com.example.models;

public class loginCentro {
    String user;
    String password;
    TipoRuolo tipoRuolo;
    
    public loginCentro(String user, String password, TipoRuolo tipoRuolo) {
        this.user = user;
        this.password = password;
        this.tipoRuolo = tipoRuolo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoRuolo getTipoRuolo() {
        return tipoRuolo;
    }

    public void setTipoRuolo(TipoRuolo tipoRuolo) {
        this.tipoRuolo = tipoRuolo;
    }
}
