package com.example;

import java.io.IOException;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import com.example.server.interfacciaServer;
import com.example.server.istanzaServer;

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
    public void initialize(URL location, ResourceBundle resources) {
        try{
            Registry registro = LocateRegistry.getRegistry("localhost",1099);
            istanzaServer.server = (interfacciaServer) registro.lookup("ServerCentro");
            istanzaServer.server.ApriConnessioneDB("mouse.db.elephantsql.com","czofsewc","sK90CQy9Jjx3gA_En10TfRZbquo33E62");
        }catch(Exception e){
            System.out.println("Errore : "+e);
        }
        
        
    }
}
