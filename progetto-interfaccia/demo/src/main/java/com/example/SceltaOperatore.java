/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */

//package globale com.example
package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

/**
Classe per scegliere operazione di registrazione centro o registrazione vaccinato
(Gli FXML sono stati eseguiti dai designer Francesco e Anna)
@author Team
@see SceltaOperatore
 */
public class SceltaOperatore {

     /**
    Metodo che permette di far loggare un operatore ai servizi di creazione del centro vaccinale e di registrazione del Vaccinato
    @see SceltaOperatore 
    */
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale"); //il setRoot permette di switchare da un fxml page ad un'altra
    }
     /**
    Metodo che permette di accedere alla sezione RegistrationFormCentroVaccinale
    @see SceltaOperatore 
    */
    @FXML
    private void regCentroVaccinale() throws IOException {

        App.setRoot("RegistrationFormCentroVaccinale"); //il setRoot permette di switchare da un fxml page ad un'altra
    }
     /**
    Metodo che permette di accedere alla sezione RegistrationFormVaccinato
    @see SceltaOperatore 
    */
    @FXML
    private void regVaccinato() throws IOException {
        App.setRoot("RegistrationFormVaccinato"); //il setRoot permette di switchare da un fxml page ad un'altra
    }
    
}

