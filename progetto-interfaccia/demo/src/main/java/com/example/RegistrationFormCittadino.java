/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */

//package globale com.example
package com.example;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.models.CittadinoRegistrato;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * Classe che permette al cittadino di registrarsi al sistema in modo da poter segnalare eventi avversi
 */
public class RegistrationFormCittadino {

    boolean isInvalid = false;
    boolean isIdValid = false;
    CittadinoRegistrato cittadino;
    Alert a = new Alert(AlertType.INFORMATION);

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

     /**
     * Questo metodo si occupa di far tornare l'utente alla pagina iniziale alla pressione del bottone opportuno.
     *
     * @throws IOException In caso di eccezioni dovute a un input.
     */
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }

    /**
     * Questo metodo si occupa, tramite apposita chiamata al server, di registrare un cittadino al sistema dopo aver effettuato controlli di nullità dei campi e un controllo specifico sul codice univoco di vaccinazione.
     *
     * @throws IOException In caso di eccezioni dovute a un input.
     */
    @FXML
    private void registraCittadino() throws IOException {

        isInvalid = false;
        isIdValid = false;

        ArrayList<String> dati = getDati();

        dati.forEach((d) -> {
            if (d.equals("") || d == null) {
                isInvalid = true;
            }
        });

        if ((!dati.get(6).equals("") && !dati.get(7).equals(""))) {
            if (!dati.get(6).equals(dati.get(7))) {
                isInvalid = true;
            }
        }

        istanzaServer.server.getCentriVaccinali().forEach((c) -> {
            try {
                istanzaServer.server.getCittadiniVaccinatiId(c.getNome()).forEach((id) -> {
                    System.out.println(id);
                    System.out.println(dati.get(3));
                    if (id.substring(1).equals(dati.get(3)))
                        isIdValid = true;
                });;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });;

        System.out.println(isInvalid);
        System.out.println(isIdValid);

        if (isInvalid || !isIdValid) {
            campoCheckRegUtente.setVisible(true);
        } else {
            campoCheckRegUtente.setVisible(false);

            cittadino = new CittadinoRegistrato(dati.get(0), dati.get(1), dati.get(2), dati.get(3), dati.get(4), dati.get(5), dati.get(6));

            istanzaServer.server.registraCittadino(cittadino);
            
            dati.forEach((d) -> System.out.println(d));

            a.setContentText("Registrato con successo!");
            a.show();

            App.setRoot("HubIniziale");
        }
    }

    /**
     * Questo metodo si occupa di leggere i dati inseriti in input dall'utente e inserirli all'interno di una lista per facilitarne il successivo controllo.
     *
     * @return Una lista di stringhe rappresentante tutti i dati inseriti dall'utente.
     */
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