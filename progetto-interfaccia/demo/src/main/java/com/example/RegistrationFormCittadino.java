package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class RegistrationFormCittadino {

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }
    @FXML
    private void registraCittadino() throws IOException {
        System.out.println("Registrato");
    }
}
