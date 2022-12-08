package com.example.models;

import java.io.Serializable;

public class loginCentro implements Serializable{
    String user;
    String password;
    
    public loginCentro(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "loginCentro [user=" + user + ", password=" + password + "]";
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
}
