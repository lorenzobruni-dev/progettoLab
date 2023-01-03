/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */
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

public class RegistrationFormCentroVaccinale implements Initializable {

    boolean controlloCampoProvincia = false;
    boolean controlloCampoCentro = false;
    boolean controlloCampoQualificatore = false;
    boolean controlloCampoTipoCentro = false;
    boolean controlloTipo = false;

    Alert a = new Alert(AlertType.INFORMATION);
    @FXML
    private ComboBox<SigleProvince> ProvinciaCentroVaccinale;
    @FXML
    private ComboBox<TipoCentro> TipologiaCentroVaccinale;
    @FXML
    private ComboBox<Qualificatore> ViaCentro;

    @FXML
    private TextField NomeCentroVaccinale;
    @FXML
    private TextField ComuneCentroVaccinale;
    @FXML
    private TextField IndirizzoCentroVaccinale;
    @FXML
    private TextField CAPCentroVaccinale;
    @FXML
    private TextField CivicoCentro;


    @FXML
    private Label CheckCampi;

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("SceltaOperatore");
    }

    @FXML
    private void registraCentroVaccinale() throws IOException {
        ArrayList<String> datiCentro = new ArrayList<>();
        ArrayList<SigleProvince> datiCentroProvincia = new ArrayList<>();
        ArrayList<TipoCentro> datiTipoCentro = new ArrayList<>();
        ArrayList<Qualificatore> datiQualificatore = new ArrayList<>();

        datiCentroProvincia = getDatiProvincia();
        datiCentro = getDati();
        datiTipoCentro = getDatoTipoCentro();
        datiQualificatore = getDatoQualificatore();

        try {
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
                        datiTipoCentro.get(0));
                App.setRoot("HubIniziale");

            }
        } catch (Exception e) {
            System.out.print("Errore : " + e);
        }
    }

    public ArrayList<SigleProvince> getDatiProvincia() {

        ArrayList<SigleProvince> dati = new ArrayList<>();

        dati.add(ProvinciaCentroVaccinale.getValue());
        return dati;
    }

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

    public ArrayList<Qualificatore> getDatoQualificatore() {

        ArrayList<Qualificatore> datiTemp = new ArrayList<>();

        datiTemp.add(ViaCentro.getValue());
        return datiTemp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProvinciaCentroVaccinale.setItems(FXCollections.observableArrayList(SigleProvince.values()));
        ViaCentro.setItems(FXCollections.observableArrayList(Qualificatore.values()));
        TipologiaCentroVaccinale.setItems(FXCollections.observableArrayList(TipoCentro.values()));
    }
}

