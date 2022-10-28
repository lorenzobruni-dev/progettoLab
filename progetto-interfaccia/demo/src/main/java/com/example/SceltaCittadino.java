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
}
