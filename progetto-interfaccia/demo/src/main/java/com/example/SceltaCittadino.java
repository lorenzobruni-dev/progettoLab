/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */

//package globale com.example
package com.example;

import java.io.IOException;
import java.util.ArrayList;

import com.example.models.CittadinoRegistrato;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Classe che permette al cittadino di effettuare il login o fare il redirect sulle pagine di ricerca centri o registrazione
 */
public class SceltaCittadino {

    public static String codice_fiscale;

    @FXML
    TextField userid = new TextField();
    @FXML
    TextField password = new TextField();
    @FXML
    Label checkCredentials = new Label();
    @FXML
    Label accountText = new Label();
    @FXML
    Button registrationButton = new Button();

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
     * Questo metodo si occupa di reindirizzare l'utente alla pagina di ricerca dei centri vaccinali.
     *
     * @throws IOException In caso di eccezioni dovute a un input.
     */
    @FXML
    private void ricercaCentroInfo() throws IOException {
        App.setRoot("RicercaCentri");
    }

     /**
     * Questo metodo si occupa di reindirizzare l'utente alla pagina di registrazione.
     *
     * @throws IOException In caso di eccezioni dovute a un input.
     */
    @FXML
    private void registrationButton() throws IOException{
        App.setRoot("RegistrationFormCittadino");
        System.out.println("Pressed");
    }

    /**
     * Questo metodo si occupa di effettuare il controllo sulle credenziali inserite in input e recuperate con chiamata al server per permettere all'utente di effettuare il login.
     *
     * @throws IOException In caso di eccezioni dovute a un input.
     */
    @FXML
    private void loginEventiAvversi() throws IOException {
        ArrayList<CittadinoRegistrato> registrati = new ArrayList<>();
        String id = userid.getText();
        String psw = password.getText();

        System.out.println("id: " + id + " | password: " + psw);

        registrati = istanzaServer.server.getCittadiniRegistrati();
        
        if(!registrati.isEmpty()){
            registrati.forEach((r) -> {
                System.out.println(r);

                if(r.getUserid().toString().equals(id) && r.getPassword().toString().equals(psw)){
                    codice_fiscale = r.getCodiceFiscale();
                    try {
                        App.setRoot("EventiAvversi");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("wrong credentials");
                    checkCredentials.setVisible(true);
                    accountText.setVisible(true);
                    registrationButton.setVisible(true);
                }
            });
        } else {
            System.out.println("nessun cittadino registrato");
        }

        System.out.println("Pressed");
    }
}
