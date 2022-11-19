package com.example;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrationFormVaccinato implements Initializable{

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("SceltaOperatore");
    }
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
    DatePicker dataVaccinato;
    @FXML
    DatePicker dataSommVaccinato;

    @FXML
    ComboBox <String> genereVaccinato;
    @FXML
    ComboBox <String> nomeVaccino;
    @FXML
    ComboBox <String> provinciaCentroVaccinale;
    @FXML
    ComboBox <String> tipologiaCentroVaccinale;
    @FXML
    Label checkCampi;


    
    @FXML
    private void registraVaccinato() throws IOException {
        
        Object [] datiVaccinato = getDati();
            if(datiVaccinato[0].equals("") || datiVaccinato[1].equals("")|| datiVaccinato[2].equals("")|| 
            datiVaccinato[3].equals("")|| datiVaccinato[4].equals("")|| datiVaccinato[5].equals("")|| datiVaccinato[6].equals("")
            || datiVaccinato[7].equals("")|| datiVaccinato[8].equals("")|| datiVaccinato[9].equals("")|| datiVaccinato[10].equals("")|| datiVaccinato[11].equals("")
            || datiVaccinato[12].equals("")|| datiVaccinato[13].equals("")|| datiVaccinato[14].equals("")){
                checkCampi.setVisible(true);
            }else{                
                idUnivocoVaccinato.setVisible(true);
                checkCampi.setVisible(false);
                idUnivocoVaccinato.setText(datiVaccinato[3].toString());
                System.out.print("Dati Centro :");
                System.out.print(datiVaccinato[0] +" - " + datiVaccinato[1] +" - " + datiVaccinato[2] +" - " + datiVaccinato[3] +" - " + datiVaccinato[4] +" - " + datiVaccinato[5] +" - " +
                datiVaccinato[6] +" - " +datiVaccinato[7] +" - " +datiVaccinato[8] +" - " +datiVaccinato[9] +" - " +datiVaccinato[10] +" - " +datiVaccinato[11] +" - " +datiVaccinato[12] +" - "+datiVaccinato[13]+" - "+
                datiVaccinato[14]);
            }
    }
    private Object [] getDati(){
        String nomeVaccinato = this.nomeVaccinato.getText();
        String cognomeVaccinato = this.cognomeVaccinato.getText();
        String cfVaccinato = this.cfVaccinato.getText();
        String idUnivocoVaccinato = generazioneIDUnivoco();
        String nomeCentroVaccinale = this.nomeCentroVaccinale.getText();
        String comuneCentroVaccinale = this.comuneCentroVaccinale.getText();
        String capCentroVaccinale = this.capCentroVaccinale.getText();
        String indirizzoCentroVaccinale = this.indirizzoCentroVaccinale.getText();

        String dataVaccinato = this.dataVaccinato.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));;
        String dataSommVaccinato = this.dataSommVaccinato.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));;

        String genereVaccinato = this.genereVaccinato.getValue();
        String nomeVaccino = this.nomeVaccino.getValue();
        String tipologiaCentroVaccinale = this.tipologiaCentroVaccinale.getValue();
        String provinciaCentroVaccinale = this.provinciaCentroVaccinale.getValue();

        Object [] datiVaccinato = {nomeVaccinato,cognomeVaccinato,cfVaccinato,idUnivocoVaccinato,nomeCentroVaccinale,
        comuneCentroVaccinale,capCentroVaccinale,capCentroVaccinale,indirizzoCentroVaccinale,dataVaccinato,
        dataSommVaccinato,genereVaccinato,nomeVaccino,tipologiaCentroVaccinale,provinciaCentroVaccinale};

        return datiVaccinato;
    }

    private String generazioneIDUnivoco(){
				String carId = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String randString = " ";
				int length = 20;
				Random rand = new Random();
				char [] text = new char [length];
				for(int i=0;i < length ;i++)
					text[i] = carId.charAt(rand.nextInt(carId.length()));
				for(int i=0 ; i<text.length ; i++)
					randString += text[i];
                return randString;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genereVaccinato.setItems(FXCollections.observableArrayList("Male","Female","Altro/a","MUCCA"));
        nomeVaccino.setItems(FXCollections.observableArrayList("AstraZeneca","J&J","Pfizer", "Moderna"));
        provinciaCentroVaccinale.setItems(FXCollections.observableArrayList("VA","MI","BE"));
        tipologiaCentroVaccinale.setItems(FXCollections.observableArrayList("Hub","Ospedale","Centro"));
    }

}
