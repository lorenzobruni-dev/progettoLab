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
import com.example.models.TipoCentro;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    boolean checkPresenzaDB = false;

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
    ComboBox<TipoCentro> tipologiaCentroVaccinale;
    @FXML
    ComboBox<Qualificatore> ViaCentro;

    @FXML
    Label checkCampi;
    @FXML
    Button RegistraVaccinato;


    @FXML
    private void registraVaccinato() throws IOException {

        ArrayList<String> datiVaccinato = getDati();
        ArrayList<SigleProvince> datoSigla = getDatiProvincia();
        ArrayList<Qualificatore> datiQualificatore = getDatoQualificatore();
        ArrayList<TipoCentro> datiTipoCentro = getDatiTipoCentro();

        ArrayList <CentroVaccinale> datiCentroDB = new ArrayList<>();
        ArrayList <String> controlloDatiCentro = new ArrayList<>();

            
        try{
            if(datiVaccinato.get(0).equals("") || 
            datiVaccinato.get(1).equals("") || 
            datiVaccinato.get(2).equals("-" + "-" + "-") ||
            datiVaccinato.get(3).equals("") ||
            datiVaccinato.get(4).equals("") ||
            datiVaccinato.get(5).equals("-" + "-" + "-") ||
            datiVaccinato.get(6).equals("") ||
            datiVaccinato.get(7).equals("") ||
            datiVaccinato.get(8).equals("") ||
            datiVaccinato.get(9).equals("") ||
            datiVaccinato.get(10).equals("") ||
            datiVaccinato.get(11).equals("") ||
            datiVaccinato.get(12).equals("") ||
            datoSigla.get(0).toString().equals("")||
            datiQualificatore.get(0).toString().equals(""))
                controlloCampoDatiVaccinato = true;
            else
                controlloCampoDatiVaccinato = false;

                controlloDatiCentro.add(datiVaccinato.get(8)); //nomeCentro
                controlloDatiCentro.add(datiVaccinato.get(12)); //nomeVia
                controlloDatiCentro.add(datiVaccinato.get(10)); //numeroCivico
                controlloDatiCentro.add(datiVaccinato.get(9)); //comuneCentro
                controlloDatiCentro.add(datiVaccinato.get(11)); //capCentro

                //chiamata DB per getDatiCentro
                datiCentroDB = istanzaServer.server.getCentriVaccinali();
                
                checkPresenzaDB = validateCentro(controlloDatiCentro,datiCentroDB,datoSigla,datiQualificatore,datiTipoCentro);
    
            if(controlloCampoDatiVaccinato || !checkPresenzaDB)
                checkCampi.setVisible(true);
            else {
                istanzaServer.server.createTableDinamica(datiVaccinato);
                istanzaServer.server.setVaccinato(datiVaccinato);
                RegistraVaccinato.setDisable(true);
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
    private boolean validateCentro(ArrayList<String> controlloDatiCentro, ArrayList<CentroVaccinale> datiCentroDB, ArrayList<SigleProvince> datoSigla, ArrayList<Qualificatore> datiQualificatore, ArrayList<TipoCentro> datiTipoCentro) {
        
        if(!datiCentroDB.isEmpty()){
            datiCentroDB.forEach((datiDB)->{
                if(datiDB.getNome().equals(controlloDatiCentro.get(0))&&
                datiDB.getIndirizzo().getQualificatore().equals(datiQualificatore.get(0))&&
                datiDB.getIndirizzo().getNome().equals(""+controlloDatiCentro.get(1))&&
                datiDB.getIndirizzo().getNumeroCivico().equals(""+controlloDatiCentro.get(2))&&
                datiDB.getIndirizzo().getComune().equals(""+controlloDatiCentro.get(3))&&
                datiDB.getIndirizzo().getProvincia().equals(""+datoSigla.get(0))&&
                datiDB.getIndirizzo().getCap().equals(""+controlloDatiCentro.get(4))&&
                datiDB.getTipoCentro().equals(datiTipoCentro.get(0)))
                    checkPresenzaDB = true;
                });
        }
        return checkPresenzaDB;
    }

    public ArrayList <TipoCentro> getDatiTipoCentro(){

        ArrayList<TipoCentro> datiTemp = new ArrayList<>();

        datiTemp.add(tipologiaCentroVaccinale.getValue());
        return datiTemp;
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
            datiTemp.add(dataVaccinato.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        datiTemp.add(genereVaccinato.getValue());
        datiTemp.add(cfVaccinato.getText());

        if (dataSommVaccinato.getValue() == null)
            datiTemp.add("");
        else
            datiTemp.add(dataSommVaccinato.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        datiTemp.add(nomeVaccino.getValue());
        datiTemp.add(generazioneIDUnivoco());
        datiTemp.add(nomeCentroVaccinale.getText()); //8
        datiTemp.add(comuneCentroVaccinale.getText()); //9
        datiTemp.add(CivicoCentro.getText()); //10
        datiTemp.add(capCentroVaccinale.getText()); //11
        datiTemp.add(indirizzoCentroVaccinale.getText()); //12
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
        tipologiaCentroVaccinale.setItems(FXCollections.observableArrayList(TipoCentro.values()));
        ViaCentro.setItems(FXCollections.observableArrayList(Qualificatore.values()));
    }

}
