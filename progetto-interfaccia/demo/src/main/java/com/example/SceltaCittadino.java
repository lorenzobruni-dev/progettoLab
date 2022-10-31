package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class SceltaCittadino {

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
        App.setRoot("EventiAvversi");
        System.out.println("Pressed");
    }
}
