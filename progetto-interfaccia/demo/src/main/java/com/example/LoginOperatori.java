package com.example;
import java.io.IOException;
import javafx.fxml.FXML;
import url.urlConnessione;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginOperatori {
    String passwordT = "ciao";
    String userT = "ciao";
    @FXML
    private void sceltaOp() throws IOException {
        App.setRoot("SceltaOperatore");
    }
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }
}
