package com.example;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.models.loginCentro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginOperatori{
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
        ArrayList <loginCentro> loginOperatoriCentro = new ArrayList<>();
        loginOperatoriCentro = istanzaServer.server.getDatiLogin();
        System.out.println(loginOperatoriCentro.toString());
        System.out.println("Username: " + user + " - " + "Password : " + pwd);
        validateLogin(user,pwd,loginOperatoriCentro);        
    }

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }

    
    private void validateLogin(String user, String pwd, ArrayList<loginCentro> loginOperatoriCentro)
    {   
        if(!loginOperatoriCentro.isEmpty())
        {loginOperatoriCentro.forEach((e)->{
            if(e.getUser().toString().equals("{"+ user + "}") && e.getPassword().toString().equals("{"+ pwd + "}"))
                try {
                    App.setRoot("SceltaOperatore");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            else CheckPassword.setVisible(true);
    });}
        
    }
}
