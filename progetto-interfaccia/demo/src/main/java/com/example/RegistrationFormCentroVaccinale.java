package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class RegistrationFormCentroVaccinale {

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("SceltaOperatore");
    }
    @FXML
    private void ricercaCentroInfo() throws IOException {
        App.setRoot("RicercaCentri");
    }
}

