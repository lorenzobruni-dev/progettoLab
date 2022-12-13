package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.models.SigleProvince;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrationFormCentroVaccinale implements Initializable{
    
    @FXML 
    private ComboBox<SigleProvince> ProvinciaCentroVaccinale;
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
        ArrayList <String> datiCentro = new ArrayList<>();
        ArrayList <SigleProvince> datiCentroProvincia = new ArrayList<>();
        datiCentroProvincia = getDatiProvincia();
        datiCentro = getDati();
        try{
            if(datiCentro.get(0).equals("") || datiCentro.get(1).equals("")|| datiCentro.get(2).equals("")|| 
            datiCentro.get(3).equals("")|| datiCentro.get(4).equals("")|| datiCentroProvincia.get(0).toString().equals(""))
                CheckCampi.setVisible(true);
            else{
                // System.out.print("Dati Centro :");
                // datiCentro.forEach((d.) -> System.out.println(d));
                System.out.print("Client : " + (datiCentro.get(0).substring(0,1).toUpperCase() + datiCentro.get(0).substring(1).toLowerCase())
                                                +" - " + datiCentro.get(1).substring(0,1).toUpperCase() + datiCentro.get(1).substring(1).toLowerCase() 
                                                +" - " + datiCentroProvincia.get(0)
                                                +" - " + datiCentro.get(2)
                                                +" - " + datiCentro.get(3) 
                                                +" - " + datiCentro.get(4));
            }
        }catch(Exception e){
            System.out.print("Errore : " +e);
        }
    }

    public ArrayList<SigleProvince> getDatiProvincia(){

        ArrayList<SigleProvince> dati = new ArrayList<>();
        dati.add(ProvinciaCentroVaccinale.getValue());
        return dati;
    }

    public ArrayList<String> getDati(){

        ArrayList<String> dati = new ArrayList<>();

        dati.add(NomeCentroVaccinale.getText());
        dati.add(ComuneCentroVaccinale.getText());
        dati.add(IndirizzoCentroVaccinale.getText());
        dati.add(CAPCentroVaccinale.getText());
        dati.add(TipologiaCentroVaccinale.getValue());
        return dati;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProvinciaCentroVaccinale.setItems(FXCollections.observableArrayList(SigleProvince.values()));
        TipologiaCentroVaccinale.setItems(FXCollections.observableArrayList("Hub","Ospedale","Centro"));
        
    }
}

