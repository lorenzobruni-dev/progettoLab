package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class EventiAvversi {

     @FXML
     private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
     }
}