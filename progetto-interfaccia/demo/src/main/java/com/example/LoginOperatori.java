package com.example;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;

import com.example.models.TipoRuolo;
import com.example.models.loginCentro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginOperatori {
    String userCredential = "admin";
    String passwordCredential = "admin";
    boolean loginConfirm = false;

    @FXML
    Label CheckPassword = new Label();
    @FXML
    TextField usernameOperatore = new TextField();
    @FXML
    TextField password = new TextField();

    @FXML
    private void sceltaOp() throws IOException, SQLException, ClassNotFoundException, NotBoundException {        
        String user = usernameOperatore.getText();
        String pwd = password.getText();
        loginCentro login = new loginCentro(user, pwd ,TipoRuolo.OPERATORE);
        System.out.println("Username: " + user + " - " + "Password : " + pwd);
        loginConfirm = validateLogin(user,pwd);
        if(loginConfirm)
        {App.setRoot("SceltaOperatore");}
        else 
        CheckPassword.setVisible(true);
    }

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }

    //Metodi integrati all'FXML
    private boolean validateLogin(String user, String pwd)
    {   
        if(userCredential.equals(user) && passwordCredential.equals(pwd))
        return true;
        else return false;
    }
}

