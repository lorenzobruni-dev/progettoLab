package com.example;

import java.io.IOException;
import java.util.ArrayList;

import com.example.models.CentroVaccinale;
import com.example.models.CentroVaccinaleSimple;
import com.example.models.TipoCentro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    TableView<CentroVaccinaleSimple> tabellaCentri;
    @FXML
    TableColumn<CentroVaccinaleSimple, String> colonnaNome;
    @FXML
    TableColumn<CentroVaccinaleSimple, String> colonnaQualificatore;
    @FXML
    TableColumn<CentroVaccinaleSimple, String> colonnaIndirizzo;
    @FXML
    TableColumn<CentroVaccinaleSimple, Integer> colonnaNumCivico;
    @FXML
    TableColumn<CentroVaccinaleSimple, String> colonnaComune;
    @FXML
    TableColumn<CentroVaccinaleSimple, String> colonnaProvincia;
    @FXML
    TableColumn<CentroVaccinaleSimple, Integer> colonnaCAP;
    @FXML
    TableColumn<CentroVaccinaleSimple, String> colonnaTipologia;

    private ObservableList<CentroVaccinaleSimple> datiCentri = FXCollections.observableArrayList();
 
    public void initialize() {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
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
                tipologiaCentroVaccinale.setItems(FXCollections.observableArrayList("HUB", "OSPEDALIERO", "AZIENDALE"));
            }
        });

        colonnaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        colonnaQualificatore.setCellValueFactory(new PropertyValueFactory<>("Qualificatore"));
        colonnaIndirizzo.setCellValueFactory(new PropertyValueFactory<>("Indirizzo"));
        colonnaNumCivico.setCellValueFactory(new PropertyValueFactory<>("NumCivico"));
        colonnaComune.setCellValueFactory(new PropertyValueFactory<>("Comune"));
        colonnaProvincia.setCellValueFactory(new PropertyValueFactory<>("Provincia"));
        colonnaCAP.setCellValueFactory(new PropertyValueFactory<>("CAP"));
        colonnaTipologia.setCellValueFactory(new PropertyValueFactory<>("Tipologia"));

        tabellaCentri.setItems(datiCentri);
    }

    @FXML
    private void backToHub() throws IOException {
        App.setRoot("SceltaCittadino");
    }

    @FXML
    private void cercaCentri() throws IOException {

        tabellaCentri.getItems().clear();
        ArrayList<CentroVaccinale> centriVaccinali = new ArrayList<>();
        ArrayList<CentroVaccinaleSimple> centriVaccinaliSimple = new ArrayList<>();

        if (slider.getValue() == 0) {
            centriVaccinali = istanzaServer.server.getCentriVaccinaliByName(nomeCentroVaccinale.getText());
        } else if (slider.getValue() == 1) {
            comuneCentroVaccinale.setVisible(true);
            tipologiaCentroVaccinale.setVisible(true);
            centriVaccinali = istanzaServer.server.getCentriVaccinaliByType(comuneCentroVaccinale.getText(), TipoCentro.valueOf(tipologiaCentroVaccinale.getValue().toString()));
        }

        centriVaccinali.forEach((c) -> {
            CentroVaccinaleSimple centro = new CentroVaccinaleSimple(c.getNome(), c.getIndirizzo().getQualificatore().toString(), c.getIndirizzo().getNome(), 
            Integer.valueOf(c.getIndirizzo().getNumeroCivico()), c.getIndirizzo().getComune(), c.getIndirizzo().getProvincia(), Integer.valueOf(c.getIndirizzo().getCap()), c.getTipoCentro().toString());
            centriVaccinaliSimple.add(centro);
        });

        System.out.println("centri trovati " + centriVaccinaliSimple);
        datiCentri.addAll(centriVaccinaliSimple);
    }
}
