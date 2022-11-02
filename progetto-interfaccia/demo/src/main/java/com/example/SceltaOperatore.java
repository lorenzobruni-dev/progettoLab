
package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class SceltaOperatore {

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }
    @FXML
    private void regCentroVaccinale() throws IOException {

        App.setRoot("RegistrationFormCentroVaccinale");
    }
    @FXML
    private void regVaccinato() throws IOException {
        App.setRoot("RegistrationFormVaccinato");
    }
    
}

