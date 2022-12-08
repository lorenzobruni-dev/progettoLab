package com.example;

import java.io.IOException;
import java.util.ArrayList;

import com.example.models.CittadinoRegistrato;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SceltaCittadino {

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
        ArrayList<CittadinoRegistrato> registrati = new ArrayList<>();
        String id = userid.getText();
        String psw = password.getText();

        System.out.println("id: " + id + " | password: " + psw);

        registrati = istanzaServer.server.getCittadiniRegistrati();
        
        if(!registrati.isEmpty()){
            registrati.forEach((r) -> {
                System.out.println(r);

                if(r.getUserid().toString().equals("{" + id + "}") && r.getPassword().toString().equals("{" + psw + "}")){
                    try {
                        App.setRoot("EventiAvversi");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("wrong credentials");
                    checkCredentials.setVisible(true);
                    accountText.setVisible(true);
                    registrationButton.setVisible(true);
                }
            });
        } else {
            System.out.println("nessun cittadino registrato");
        }

        System.out.println("Pressed");
    }
}
