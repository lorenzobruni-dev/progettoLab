package com.example;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.example.models.CentroVaccinale;
import com.example.models.CentroVaccinaleSimple;
import com.example.models.EventoAvverso;
import com.example.models.TipoCentro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
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
    @FXML
    TableColumn<CentroVaccinaleSimple, String> colonnaEventi;
    @FXML
    TableColumn<CentroVaccinaleSimple, String> colonnaMedia;

    private ObservableList<CentroVaccinaleSimple> datiCentri = FXCollections.observableArrayList();
    // private ObservableList<CentroVaccinaleSimple> selectedRow = FXCollections.observableArrayList();

    // TableViewSelectionModel<CentroVaccinaleSimple> selectionModel;

    ArrayList<EventoAvverso> eventiAvversi = new ArrayList<>();

    int somma = 0;
    double media = 0;
 
    public void initialize() {

        // selectionModel = tabellaCentri.getSelectionModel();
        // selectionModel.setSelectionMode(SelectionMode.SINGLE);

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

        // if (selectionModel != null)
        //     selectionModel.clearSelection();

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
            somma = 0;
            media = 0;

            try {
                istanzaServer.server.getCittadiniVaccinati(c.getNome()).forEach((cf) -> {
                    try {
                        eventiAvversi = istanzaServer.server.getEventiAvversi(cf);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            if (eventiAvversi.size() > 0) {
                eventiAvversi.forEach((ev) -> {
                    somma = somma + ev.getSeverità();
                });

                media = somma / eventiAvversi.size();
            }

            CentroVaccinaleSimple centro = new CentroVaccinaleSimple(c.getNome(), c.getIndirizzo().getQualificatore().toString(), c.getIndirizzo().getNome(), 
            Integer.valueOf(c.getIndirizzo().getNumeroCivico()), c.getIndirizzo().getComune(), c.getIndirizzo().getProvincia(), Integer.valueOf(c.getIndirizzo().getCap()), c.getTipoCentro().toString(), eventiAvversi.size(), media);
            centriVaccinaliSimple.add(centro);
        });

        System.out.println("centri trovati " + centriVaccinaliSimple);
        datiCentri.addAll(centriVaccinaliSimple);
        
        // selectedRow = selectionModel.getSelectedItems();
        
        // do {
        //     selectedRow = selectionModel.getSelectedItems();
        //     System.out.println("riga selezionata" + selectedRow);
        // } while (selectedRow.size() <= 0);
    }
}
