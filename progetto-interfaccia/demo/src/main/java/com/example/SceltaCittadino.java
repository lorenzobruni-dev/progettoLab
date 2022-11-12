package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SceltaCittadino {

    final String idCredential = "user";
    final String pswCredential = "user";

    @FXML
    TextField userid = new TextField();
    @FXML
    TextField password = new TextField();
    @FXML
    Label checkCredentials = new Label();
    @FXML
    Label accountText = new Label();
    @FXML
    Button registrationButton = new Button();

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }
    
    @FXML
    private void ricercaCentroInfo() throws IOException {
        App.setRoot("RicercaCentri");
    }

    @FXML
    private void registrationButton() throws IOException{
        App.setRoot("RegistrationFormCittadino");
        System.out.println("Pressed");
    }

    @FXML
    private void loginEventiAvversi() throws IOException {
        String id = userid.getText();
        String psw = password.getText();

        System.out.println("id: " + id + " | password: " + psw);

        if(idCredential.equals(id) && pswCredential.equals(psw)){
            App.setRoot("EventiAvversi");
        } else {
            System.out.println("wrong credentials");
            checkCredentials.setVisible(true);
            accountText.setVisible(true);
            registrationButton.setVisible(true);
        }

        System.out.println("Pressed");
    }
}
