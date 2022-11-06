package com.example;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import url.urlConnessione;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private void sceltaOp() throws IOException {
        
        String user = usernameOperatore.getText();
        String pwd = password.getText();
        System.out.println("Username: " + user + " - " + "Password : " + pwd);
        loginConfirm = validateLogin(user,pwd);
        if(loginConfirm == true)
        App.setRoot("SceltaOperatore");
        else 
        CheckPassword.setVisible(true);
    }
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }
    private boolean validateLogin(String user, String pwd)
    {
        if((user == userCredential)&&(pwd == passwordCredential)||(user!="" || pwd !=""))
        return true;
        else return false;
    }
}
