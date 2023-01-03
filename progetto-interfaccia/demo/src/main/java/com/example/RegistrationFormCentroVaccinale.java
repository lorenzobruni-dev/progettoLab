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
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.models.Qualificatore;
import com.example.models.SigleProvince;
import com.example.models.TipoCentro;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

    /**
    Classe che specifica la form di registrazione del vaccinato ad un dato centro
    @author Team
    @see RegistrationFormCentroVaccinale
    */
public class RegistrationFormCentroVaccinale implements Initializable {

    //boolean di controllo sui campi inseriti

    boolean controlloCampoProvincia = false; 
    boolean controlloCampoCentro = false;
    boolean controlloCampoQualificatore = false;
    boolean controlloCampoTipoCentro = false;
    boolean controlloTipo = false;

    Alert a = new Alert(AlertType.INFORMATION); //alert che notifica se la richiesta di registrazione è stata processato con successo

    /** @param ComboBox combobox dedicata alla visualizzazione della provincia del centro*/
    @FXML
    private ComboBox<SigleProvince> ProvinciaCentroVaccinale;

    /** @param ComboBox combobox dedicata alla visualizzazione della tipologia del centro*/
    @FXML
    private ComboBox<TipoCentro> TipologiaCentroVaccinale;

    /** @param ComboBox combobox dedicata alla visualizzazione della via del centro*/
    @FXML
    private ComboBox<Qualificatore> ViaCentro;

    /** @param TextField textfield dedicata alla visualizzazione del nome del centro vaccinale*/
    @FXML
    private TextField NomeCentroVaccinale;

    /** @param TextField textfield dedicata alla visualizzazione del comune del centro vaccinale*/
    @FXML
    private TextField ComuneCentroVaccinale;

    /** @param TextField textfield dedicata alla visualizzazione del nome indirizzo del centro vaccinale*/
    @FXML
    private TextField IndirizzoCentroVaccinale;

    /** @param TextField textfield dedicata alla visualizzazione del cap del centro vaccinale*/
    @FXML
    private TextField CAPCentroVaccinale;

    /** @param TextField textfield dedicata alla visualizzazione del civico del centro vaccinale*/
    @FXML
    private TextField CivicoCentro;

    /** @param Label label che notifica se presenti campi non compilati*/
    @FXML
    private Label CheckCampi;
    
    /**
    Metodo che permette di far tornare indietro alla SceltaOperatore
    @see RegistrationFormCentroVaccinale
    */
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("SceltaOperatore");
    }

    /**
    Metodo che permette di registrare un centroVaccinale
    @see RegistrationFormCentroVaccinale
    */
    @FXML
    private void registraCentroVaccinale() throws IOException {
        ArrayList<String> datiCentro = new ArrayList<>(); // ArrayList contenente tutti i dati di registrazione
        ArrayList<SigleProvince> datiCentroProvincia = new ArrayList<>(); //ArrayList contenente la sigla della provincia
        ArrayList<TipoCentro> datiTipoCentro = new ArrayList<>(); //ArrayList contenente il tipo di centro
        ArrayList<Qualificatore> datiQualificatore = new ArrayList<>(); //ArrayList contenente il qualificatore della via del centro

        datiCentroProvincia = getDatiProvincia();
        datiCentro = getDati();
        datiTipoCentro = getDatoTipoCentro();
        datiQualificatore = getDatoQualificatore();

        try {
            
            //verifica campi non compilati
            datiCentroProvincia.forEach((e) -> {
                if (e == null || e.equals(""))
                    controlloCampoProvincia = true;
            });
            datiCentro.forEach((e) -> {
                if (e == null || e.equals(""))
                    controlloCampoCentro = true;
            });
            datiTipoCentro.forEach((e) -> {
                if (e == null || e.equals(""))
                    controlloCampoTipoCentro = true;
            });
            datiQualificatore.forEach((e) -> {
                if (e == null || e.equals(""))
                    controlloCampoQualificatore = true;
            });
            
            //if che abilita alla scrittura a DB dei dati del CentroVaccinale
            if(controlloCampoProvincia || controlloCampoCentro || controlloCampoTipoCentro ||controlloCampoQualificatore)
                CheckCampi.setVisible(true);
            else {
                // System.out.print("Dati Centro :");
                // datiCentro.forEach((d.) -> System.out.println(d));

                System.out.print("Client : " + (datiCentro.get(0))
                        + " - " + datiCentro.get(1)
                        + " - " + datiQualificatore.get(0)
                        + " - " + datiCentro.get(2)
                        + " - " + datiCentro.get(3)
                        + " - " + datiCentroProvincia.get(0)
                        + " - " + datiCentro.get(4)
                        + " - " + datiTipoCentro.get(0));
                System.out.println(datiCentroProvincia.get(0));
                a.setContentText("Centro Registrato con successo!");
                a.show();
                istanzaServer.server.setCentroVaccinale(datiCentro.get(0), datiCentro.get(1), datiCentro.get(2),
                        datiCentro.get(3), datiCentro.get(4), datiQualificatore.get(0), datiCentroProvincia.get(0),
                        datiTipoCentro.get(0)); //chiamata a DB che abilita la insert di un CentroVaccinale
                App.setRoot("HubIniziale");

            }
        } catch (Exception e) {
            System.out.print("Errore : " + e);
        }
    }

    /**
    Metodo che permette di inserire i dati della provincia del centro in un ArrayList
    @see RegistrationFormCentroVaccinale
    */
    public ArrayList<SigleProvince> getDatiProvincia() {

        ArrayList<SigleProvince> dati = new ArrayList<>();

        dati.add(ProvinciaCentroVaccinale.getValue());
        return dati;
    }
    /**
    Metodo che permette di inserire i dati del tipo centro in un ArrayList
    @see RegistrationFormCentroVaccinale
    */
    public ArrayList<String> getDati() {

        ArrayList<String> datiTemp = new ArrayList<>();

        datiTemp.add(NomeCentroVaccinale.getText());
        datiTemp.add(ComuneCentroVaccinale.getText());
        datiTemp.add(IndirizzoCentroVaccinale.getText());
        datiTemp.add(CivicoCentro.getText());
        datiTemp.add(CAPCentroVaccinale.getText());
        return datiTemp;
    }

    public ArrayList<TipoCentro> getDatoTipoCentro() {

        ArrayList<TipoCentro> datiTemp = new ArrayList<>();

        datiTemp.add(TipologiaCentroVaccinale.getValue());
        return datiTemp;
    }

    /**
    Metodo che permette di inserire i dati del qualificatore della via del centro in un ArrayList
    @see RegistrationFormCentroVaccinale
    */
    public ArrayList<Qualificatore> getDatoQualificatore() {

        ArrayList<Qualificatore> datiTemp = new ArrayList<>();

        datiTemp.add(ViaCentro.getValue());
        return datiTemp;
    }

    /**
    Metodo che permette di istanziare le varie combobox con gli opportuni campi
    @see RegistrationFormCentroVaccinale
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProvinciaCentroVaccinale.setItems(FXCollections.observableArrayList(SigleProvince.values()));
        ViaCentro.setItems(FXCollections.observableArrayList(Qualificatore.values()));
        TipologiaCentroVaccinale.setItems(FXCollections.observableArrayList(TipoCentro.values()));
    }
}

