package com.example;

import java.io.IOException;
import java.util.ArrayList;

import com.example.models.CentroVaccinale;
import com.example.models.CittadinoRegistrato;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrationFormCittadino {

    boolean isInvalid = false;
    CittadinoRegistrato cittadino;
    CentroVaccinale centro;

    @FXML
    TextField campoNome;
    @FXML
    TextField campoCognome;
    @FXML
    TextField campoEmail;
    @FXML
    TextField campoCF;
    @FXML
    TextField campoIDUnivoco;
    @FXML
    TextField campoComuneCentroVaccinale;
    @FXML
    TextField campoNomeCentroVaccinale;
    @FXML
    TextField campoCAPCentroVaccinale;
    @FXML
    TextField campoUserID;
    @FXML
    TextField campoPassword;
    @FXML
    TextField campoRipetiPassword;

    @FXML
    ComboBox<String> campoProvinciaCentroVaccinale;

    @FXML
    Label campoCheckRegUtente;

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }
    @FXML
    private void registraCittadino() throws IOException { 

        isInvalid = false;

        ArrayList<String> dati = getDati();

        dati.forEach((d) -> {
            if(d.equals("")) {
                isInvalid = true;
            }
        });

        if((dati.get(6) != "" && dati.get(7) != "")){
            if (!(dati.get(6).equals(dati.get(7)))) {
                isInvalid = true;
            }
        }

        System.out.println(isInvalid);

        if (isInvalid) {
            campoCheckRegUtente.setVisible(true);
        } else {
            campoCheckRegUtente.setVisible(false);

            cittadino = new CittadinoRegistrato(dati.get(0), dati.get(1), dati.get(2), dati.get(3), dati.get(4), dati.get(5), dati.get(6));

            istanzaServer.server.registraCittadino(cittadino);
            
            dati.forEach((d) -> System.out.println(d));

            App.setRoot("HubIniziale");
        }
    }

    private ArrayList<String> getDati() {
        ArrayList<String> dati = new ArrayList<>();

        dati.add(campoNome.getText());
        dati.add(campoCognome.getText());
        dati.add(campoCF.getText());
        dati.add(campoIDUnivoco.getText());
        dati.add(campoEmail.getText());
        dati.add(campoUserID.getText());
        dati.add(campoPassword.getText());
        dati.add(campoRipetiPassword.getText());

        return dati;
    }
}
