package com.example;

import java.io.IOException;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HubIniziale implements Initializable{

    @FXML
    private void apriSezioneOperatore() throws IOException {
        App.setRoot("LoginOperatori");
    }
    @FXML
    private void apriSezioneCittadino() throws IOException {
        App.setRoot("SceltaCittadino");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try{
            Registry registro = LocateRegistry.getRegistry("localhost", 9090);
            istanzaServer.server = (interfacciaServer) registro.lookup("ServerCentro");
            istanzaServer.server.ApriConnessioneDB("jdbc:postgresql://mouse.db.elephantsql.com","czofsewc","sK90CQy9Jjx3gA_En10TfRZbquo33E62");
        }catch(Exception e){
            System.out.println("Errore : "+e);
        }
    }
}
