package com.example;
import java.io.IOException;
import java.net.InetAddress;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

import com.example.server.interfacciaServer;
import com.example.server.istanzaServer;

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
        InetAddress address = InetAddress.getByName("13.49.141.18");
        Registry registro = LocateRegistry.getRegistry("13.49.141.18",5432);
        istanzaServer.server = (interfacciaServer) registro.lookup("ServerCentro");
        istanzaServer.server.ApriConnessioneDB("mouse.db.elephantsql.com","czofsewc","sK90CQy9Jjx3gA_En10TfRZbquo33E62");
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
