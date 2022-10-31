package com.example;
import java.io.IOException;
import java.lang.reflect.Array;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class LoginOperatori {
    
    String utente;
    String password;
    @FXML
    TextField  UserIDOperatore = new TextField();
    @FXML
    PasswordField PasswordOperatori = new PasswordField();
    @FXML
    private void sceltaOp() throws IOException {
    try{
        String utenteCredenziali = "admin";
        String passwordCredenziali = "admin";
        UserIDOperatore.setOnAction(e->utente = UserIDOperatore.getText());
        PasswordOperatori.setOnAction(e->password = PasswordOperatori.getText());
        System.out.println(UserIDOperatore);
        System.out.println(PasswordOperatori);
        
        if(utente == utenteCredenziali && password == passwordCredenziali)
        App.setRoot("SceltaOperatore");
    }catch(Exception e)
    {
        System.out.println("Errore");
        System.out.println(UserIDOperatore);
        System.out.println(PasswordOperatori);
    }
        

    }
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }
}
