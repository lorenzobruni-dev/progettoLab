package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void apriSezioneOperatoreSanitario() throws IOException {
        App.setRoot("secondary");
    }
}
