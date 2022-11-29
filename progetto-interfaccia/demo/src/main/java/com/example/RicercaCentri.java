package com.example;

import java.io.IOException;
import java.util.ArrayList;

import com.example.models.CentroVaccinale;
import com.example.models.Indirizzo;
import com.example.models.Qualificatore;
import com.example.models.TipoCentro;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RicercaCentri {

    @FXML
    TextField nomeCentroVaccinale;
    @FXML
    TextField comuneCentroVaccinale;
    @FXML
    ComboBox tipologiaCentroVaccinale;
    @FXML
    Button cercaCentri;
    @FXML
    Slider slider;
    @FXML
    TableView tabellaCentri;

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("SceltaCittadino");
    }

    @FXML
    private void valueChanged() throws IOException {
        System.out.println("slide");
        if (slider.getValue() == 0) {
            nomeCentroVaccinale.setVisible(true);
            comuneCentroVaccinale.setVisible(false);
            tipologiaCentroVaccinale.setVisible(false);
            cercaCentri.setLayoutY(299.0);
        } else if (slider.getValue() == 1) {
            nomeCentroVaccinale.setVisible(false);
            comuneCentroVaccinale.setVisible(true);
            tipologiaCentroVaccinale.setVisible(true);
            cercaCentri.setLayoutY(350.0);
        }
    }

    @FXML
    private void cercaCentri() throws IOException {

        ArrayList<CentroVaccinale> centriVaccinali = new ArrayList<>();

        if (slider.getValue() == 0) {
            //centriVaccinali = istanzaServer.server.getCentriVaccinaliByName(nomeCentroVaccinale.getText());
        } else if (slider.getValue() == 1) {
            comuneCentroVaccinale.setVisible(true);
            tipologiaCentroVaccinale.setVisible(true);
            //centriVaccinali = istanzaServer.server.getCentriVaccinaliByType(comuneCentroVaccinale.getText(), TipoCentro.valueOf(tipologiaCentroVaccinale.getValue().toString()));
        }

        centriVaccinali.add(new CentroVaccinale("nome"));
        System.out.println("centri trovati " + centriVaccinali);
        centriVaccinali.forEach((c) -> {
            tabellaCentri.getItems().add(c);
        });
    }
}
