package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class HubIniziale {

    @FXML
    private void apriSezioneOperatore() throws IOException {
        App.setRoot("LoginOperatori");
    }
    @FXML
    private void apriSezioneCittadino() throws IOException {
        App.setRoot("SceltaCittadino");
    }
}
