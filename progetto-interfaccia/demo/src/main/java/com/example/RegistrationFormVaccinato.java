/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */

//package globale com.example
package com.example;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import com.example.models.CentroVaccinale;
import com.example.models.Qualificatore;
import com.example.models.SigleProvince;
import com.example.models.TipoCentro;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

    /**
    Classe che specifica la form di registrazione del vaccinato ad un dato centro
    @author Team
    @see RegistrationFormVaccinato
    */
public class RegistrationFormVaccinato implements Initializable {

    /**
    Metodo che permette di far tornare indietro alla SceltaOperatore
    @see RegistrationFormVaccinato
    */
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("SceltaOperatore");
    }

    boolean controlloCampoDatiVaccinato = false; //variabile di controllo sui campi del vaccinato
    boolean checkPresenzaDB = false; //variabile booleana che controlla se a DB è presente il centroSelezionato
    Alert a = new Alert(AlertType.INFORMATION); //alert di information che avvisa che il Vaccinato è stato registrato con successo

    /** @param TextField textfield dedicata al nome del vaccinato*/
    @FXML
    TextField nomeVaccinato;

    /** @param TextField textfield dedicata al cognome del vaccinato*/
    @FXML
    TextField cognomeVaccinato;

    /** @param TextField textfield dedicata al codice fiscale del vaccinato*/
    @FXML
    TextField cfVaccinato;

    /** @param TextField textfield dedicata alla visualizzazione dell'id univoco del vaccinato*/
    @FXML
    TextField idUnivocoVaccinato;

    /** @param TextField textfield dedicata alla visualizzazione del nome del centro vaccinale*/
    @FXML
    TextField nomeCentroVaccinale;

    /** @param TextField textfield dedicata alla visualizzazione del comune del centro vaccinale*/
    @FXML
    TextField comuneCentroVaccinale;

     /** @param TextField textfield dedicata alla visualizzazione del cap del centro vaccinale*/
    @FXML
    TextField capCentroVaccinale;

     /** @param TextField textfield dedicata alla visualizzazione dell'indirizzo del centro vaccinale*/
    @FXML
    TextField indirizzoCentroVaccinale;

     /** @param TextField textfield dedicata alla visualizzazione del civico del centro vaccinale*/
    @FXML
    TextField CivicoCentro;

     /** @param DatePicker datepicker dedicata alla visualizzazione della data di nascita del vaccinato*/
    @FXML
    DatePicker dataVaccinato;
    
    /** @param DatePicker datepicker dedicata alla visualizzazione della data di somministrazione del vaccinato*/
    @FXML
    DatePicker dataSommVaccinato;

    /** @param ComboBox combobox dedicata alla visualizzazione del genere del vaccinato*/
    @FXML
    ComboBox<String> genereVaccinato;

    /** @param ComboBox combobox dedicata alla visualizzazione del genere del vaccinato*/
    @FXML
    ComboBox<String> nomeVaccino;

    /** @param ComboBox combobox dedicata alla visualizzazione della provincia del centro*/
    @FXML
    ComboBox<SigleProvince> provinciaCentroVaccinale;

    /** @param ComboBox combobox dedicata alla visualizzazione della tipologia del centro*/
    @FXML
    ComboBox<TipoCentro> tipologiaCentroVaccinale;

    /** @param ComboBox combobox dedicata alla visualizzazione della via del centro*/
    @FXML
    ComboBox<Qualificatore> ViaCentro;

    /** @param Label label che informa se ci sono stati errori in fase di inserimento*/
    @FXML
    Label checkCampi;

    /** @param Button bottone di registrazione*/
    @FXML
    Button RegistraVaccinato;

    /**
    Metodo che permette di registrare un vaccinato
    @see RegistrationFormVaccinato
    */
    @FXML
    private void registraVaccinato() throws IOException {

        ArrayList<String> datiVaccinato = getDati(); // ArrayList contenente tutti i dati di registrazione
        ArrayList<SigleProvince> datoSigla = getDatiProvincia(); //ArrayList contenente la sigla della provincia
        ArrayList<Qualificatore> datiQualificatore = getDatoQualificatore(); //ArrayList contenente il qualificatore della via del centro
        ArrayList<TipoCentro> datiTipoCentro = getDatiTipoCentro(); //ArrayList contenente il tipo di centro

        ArrayList <CentroVaccinale> datiCentroDB = new ArrayList<>(); //ArrayList contenente i dati del centro , presente a DB
        ArrayList <String> controlloDatiCentro = new ArrayList<>();  //ArrayList temporanea utile per il controllo della presenza di un centro a DB

            
        try{

            //controllo di dati non compilati

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
                
                // metodo che controlla la presenza a DB -> valore ritorno il checkPresenzaDB il quale verifica la presenza a DB
                checkPresenzaDB = validateCentro(controlloDatiCentro,datiCentroDB,datoSigla,datiQualificatore,datiTipoCentro);
            
            //if che abilita alla scrittura a DB dei dati del Vaccinato
            if(controlloCampoDatiVaccinato || !checkPresenzaDB)
                checkCampi.setVisible(true);
            else {
                istanzaServer.server.createTableDinamica(datiVaccinato); //chiamata DB per createTableDinamica
                istanzaServer.server.setVaccinato(datiVaccinato); //chiamata DB per insert data
                a.setHeaderText("Registrato con successo!");
                a.setContentText(datiVaccinato.get(7).toString());
                a.show();
                RegistraVaccinato.setDisable(true);
                checkCampi.setVisible(false);
                idUnivocoVaccinato.setVisible(true);
                idUnivocoVaccinato.setText(datiVaccinato.get(7).toString());
                App.setRoot("HubIniziale");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
    Metodo che permette di validare il centro presente a DB con i dati del centro appena inseriti
    @see RegistrationFormVaccinato
    */

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

    /**
    Metodo che permette di inserire i dati del tipo centro in un ArrayList
    @see RegistrationFormVaccinato
    */
    public ArrayList <TipoCentro> getDatiTipoCentro(){

        ArrayList<TipoCentro> datiTemp = new ArrayList<>();

        datiTemp.add(tipologiaCentroVaccinale.getValue());
        return datiTemp;
    }
    /**
    Metodo che permette di inserire i dati del qualificatore della via del centro in un ArrayList
    @see RegistrationFormVaccinato
    */
    public ArrayList<Qualificatore> getDatoQualificatore() {

        ArrayList<Qualificatore> datiTemp = new ArrayList<>();

        datiTemp.add(ViaCentro.getValue());
        return datiTemp;
    }
    /**
    Metodo che permette di inserire i dati della provincia del centro in un ArrayList
    @see RegistrationFormVaccinato
    */
    public ArrayList<SigleProvince> getDatiProvincia() {

        ArrayList<SigleProvince> dati = new ArrayList<>();

        dati.add(provinciaCentroVaccinale.getValue());
        return dati;
    }
    /**
    Metodo che permette di inserire i dati del centro in un ArrayList
    @see RegistrationFormVaccinato
    */
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

    /**
    Metodo che permette di generare l'id univoco di registrazione
    @see RegistrationFormVaccinato
    */
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

     /**
    Metodo che permette di istanziare le varie combobox con gli opportuni campi
    @see RegistrationFormVaccinato
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genereVaccinato.setItems(FXCollections.observableArrayList("Male", "Female", "Altro/a", "MUCCA"));
        nomeVaccino.setItems(FXCollections.observableArrayList("AstraZeneca", "J&J", "Pfizer", "Moderna"));
        provinciaCentroVaccinale.setItems(FXCollections.observableArrayList(SigleProvince.values()));
        tipologiaCentroVaccinale.setItems(FXCollections.observableArrayList(TipoCentro.values()));
        ViaCentro.setItems(FXCollections.observableArrayList(Qualificatore.values()));
    }

}
