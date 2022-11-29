package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrationFormCentroVaccinale implements Initializable{
    
    @FXML 
    private ComboBox<String> ProvinciaCentroVaccinale;
    @FXML
    private ComboBox<String> TipologiaCentroVaccinale;
    @FXML
    private TextField NomeCentroVaccinale;
    @FXML
    private TextField ComuneCentroVaccinale;
    @FXML
    private TextField IndirizzoCentroVaccinale;
    @FXML
    private TextField CAPCentroVaccinale;
    @FXML
    private Label CheckCampi;
    
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("SceltaOperatore");
    }
    
    @FXML
    private void registraCentroVaccinale() throws IOException {
        String []datiCentro = getDati();
        try{
            if(datiCentro[0].equals("") || datiCentro[1].equals("")|| datiCentro[2].equals("")|| 
            datiCentro[3].equals("")|| datiCentro[4].equals("")|| datiCentro[5].equals(""))
                CheckCampi.setVisible(true);
            else{
                System.out.print("Dati Centro :");
                System.out.print(datiCentro[0] +" - " + datiCentro[1] +" - " + datiCentro[2] +" - " + datiCentro[3] +" - " + datiCentro[4] +" - " + datiCentro[5] +" - ");
            }
        }catch(Exception e){
            System.out.print("Errore : " +e);
        }
    }


    public String[] getDati(){
        String nomecentro =  NomeCentroVaccinale.getText();
        String comuneCentro = ComuneCentroVaccinale.getText();
        String provinciaCentro = ProvinciaCentroVaccinale.getValue();
        String indirizzoCentro = IndirizzoCentroVaccinale.getText();
        String capCentro = CAPCentroVaccinale.getText();
        String tipologiaCentro = TipologiaCentroVaccinale.getValue();
        String [] arrayCentro = {nomecentro,comuneCentro,provinciaCentro,indirizzoCentro,capCentro,tipologiaCentro};
        return arrayCentro;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProvinciaCentroVaccinale.setItems(FXCollections.observableArrayList("VA","MI","BE"));
        TipologiaCentroVaccinale.setItems(FXCollections.observableArrayList("Hub","Ospedale","Centro"));
        
    }
}

