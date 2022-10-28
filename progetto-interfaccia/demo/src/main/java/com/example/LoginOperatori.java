package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginOperatori {

    @FXML
    private void sceltaOp() throws IOException {
        App.setRoot("SceltaOperatore");
    }
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }
}
