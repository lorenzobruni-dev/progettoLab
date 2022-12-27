package com.example;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.ResourceBundle;

import com.example.models.CentroVaccinale;
import com.example.models.Qualificatore;
import com.example.models.SigleProvince;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrationFormVaccinato implements Initializable {

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("SceltaOperatore");
    }

    boolean controlloCampoDatiVaccinato = false;
    boolean controlloCampoSigla = false;
    boolean controlloCampoQualificatore = false;
    @FXML
    TextField nomeVaccinato;
    @FXML
    TextField cognomeVaccinato;
    @FXML
    TextField cfVaccinato;
    @FXML
    TextField idUnivocoVaccinato;
    @FXML
    TextField nomeCentroVaccinale;
    @FXML
    TextField comuneCentroVaccinale;
    @FXML
    TextField capCentroVaccinale;
    @FXML
    TextField indirizzoCentroVaccinale;
    @FXML
    TextField CivicoCentro;

    @FXML
    DatePicker dataVaccinato;
    @FXML
    DatePicker dataSommVaccinato;

    @FXML
    ComboBox<String> genereVaccinato;
    @FXML
    ComboBox<String> nomeVaccino;
    @FXML
    ComboBox<SigleProvince> provinciaCentroVaccinale;
    @FXML
    ComboBox<String> tipologiaCentroVaccinale;
    @FXML
    ComboBox<Qualificatore> ViaCentro;

    @FXML
    Label checkCampi;


    @FXML
    private void registraVaccinato() throws IOException {

        ArrayList<String> datiVaccinato = getDati();
        ArrayList<SigleProvince> datoSigla = getDatiProvincia();
        ArrayList<Qualificatore> datiQualificatore = getDatoQualificatore();

        try{
            datiVaccinato.forEach((e) -> {
                if (e == null || e.equals(""))
                    controlloCampoDatiVaccinato = true;
            });
            datoSigla.forEach((e) -> {
                if (e == null || e.equals(""))
                    controlloCampoSigla = true;
            });
            datiQualificatore.forEach((e) -> {
                if (e == null || e.equals(""))
                    controlloCampoQualificatore = true;
            });
    
            if(controlloCampoDatiVaccinato || controlloCampoSigla || controlloCampoQualificatore)
                checkCampi.setVisible(true);
            else {
                checkCampi.setVisible(false);
                idUnivocoVaccinato.setVisible(true);
                idUnivocoVaccinato.setText(datiVaccinato.get(7).toString());
                System.out.println("Dati Centro :");
                System.out.println(datiVaccinato);
                System.out.println(datoSigla);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        

    }

    public ArrayList<Qualificatore> getDatoQualificatore() {

        ArrayList<Qualificatore> datiTemp = new ArrayList<>();

        datiTemp.add(ViaCentro.getValue());
        return datiTemp;
    }

    public ArrayList<SigleProvince> getDatiProvincia() {

        ArrayList<SigleProvince> dati = new ArrayList<>();

        dati.add(provinciaCentroVaccinale.getValue());
        return dati;
    }

    public ArrayList<String> getDati() {

        ArrayList<String> datiTemp = new ArrayList<>();

        datiTemp.add(nomeVaccinato.getText());
        datiTemp.add(cognomeVaccinato.getText());

        if (dataVaccinato.getValue() == null)
            datiTemp.add("");
        else
            datiTemp.add(dataVaccinato.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        datiTemp.add(genereVaccinato.getValue());
        datiTemp.add(cfVaccinato.getText());

        if (dataSommVaccinato.getValue() == null)
            datiTemp.add("");
        else
            datiTemp.add(dataSommVaccinato.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        datiTemp.add(nomeVaccino.getValue());
        datiTemp.add(generazioneIDUnivoco());
        datiTemp.add(nomeCentroVaccinale.getText());
        datiTemp.add(comuneCentroVaccinale.getText());
        datiTemp.add(CivicoCentro.getText());
        datiTemp.add(capCentroVaccinale.getText());
        datiTemp.add(indirizzoCentroVaccinale.getText());
        datiTemp.add(comuneCentroVaccinale.getText());
        datiTemp.add(tipologiaCentroVaccinale.getValue());
        return datiTemp;
    }

    private String generazioneIDUnivoco() {
        String carId = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String randString = " ";
        int length = 20;
        Random rand = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
            text[i] = carId.charAt(rand.nextInt(carId.length()));
        for (int i = 0; i < text.length; i++)
            randString += text[i];
        return randString;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genereVaccinato.setItems(FXCollections.observableArrayList("Male", "Female", "Altro/a", "MUCCA"));
        nomeVaccino.setItems(FXCollections.observableArrayList("AstraZeneca", "J&J", "Pfizer", "Moderna"));
        provinciaCentroVaccinale.setItems(FXCollections.observableArrayList(SigleProvince.values()));
        tipologiaCentroVaccinale.setItems(FXCollections.observableArrayList("OSPEDALIERO", "AZIENDALE", "HUB"));
        ViaCentro.setItems(FXCollections.observableArrayList(Qualificatore.values()));
    }

}
