/*
 * BRUNI LORENZO - MATRICOLA 744455 - VA 
 * CLARY FRANCESCO - MATRICOLA 744768 - VA
 * LUTSYSHYNA ANNA - MATRICOLA 745509 - VA
 * PANARESE ALESSIO - MATRICOLA 750887 - VA
 */

//package globale com.example
package com.example;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.models.loginCentro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
Classe per operazioni di Login da parte dell'operatore sanitario
(Gli FXML sono stati eseguiti dai designer Francesco e Anna)
@author Team
@see LoginOperatori
 */
public class LoginOperatori{

    /** @param Label label di checkCredenziali */
    @FXML
     Label CheckPassword = new Label();

     /** @param TextField textBox per username */
    @FXML
     TextField usernameOperatore = new TextField();

     /** @param TextField textBox per password */
    @FXML
     TextField password = new TextField();

    /**
    Metodo che permette di far loggare un operatore ai servizi di creazione del centro vaccinale e di registrazione del Vaccinato
    @author Lorenzo
    @see LoginOperatori 
    */
    @FXML
    private void sceltaOp() throws IOException, SQLException, ClassNotFoundException, NotBoundException {       
        String user = usernameOperatore.getText(); //user - TextField
        String pwd = password.getText(); //pwd - TextField
        ArrayList <loginCentro> loginOperatoriCentro = new ArrayList<>(); 
        loginOperatoriCentro = istanzaServer.server.getDatiLogin(); //chiamata al server per prelevare dati login
        System.out.println(loginOperatoriCentro.toString());
        System.out.println("Username: " + user + " - " + "Password : " + pwd);
        validateLogin(user,pwd,loginOperatoriCentro); //metodo che valida il login       
    }

    /**
    Metodo che permette di far tornare indietro all'HubIniziale
    @author Lorenzo
    @see LoginOperatori 
    */
    @FXML
    private void backToHub() throws IOException {
        App.setRoot("HubIniziale");
    }

    /**
    Metodo che valida il login
    @author Lorenzo
    @see LoginOperatori 
    */
    private void validateLogin(String user, String pwd, ArrayList<loginCentro> loginOperatoriCentro)
    {   
        if(!loginOperatoriCentro.isEmpty())
        {loginOperatoriCentro.forEach((e)->{
            if(e.getUser().toString().equals("{"+ user + "}") && e.getPassword().toString().equals("{"+ pwd + "}"))
                try {
                    App.setRoot("SceltaOperatore");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            else CheckPassword.setVisible(true);
    });}
        
    }
}
