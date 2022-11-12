package com.example;

import java.io.IOException;
import java.util.ArrayList;

import com.example.models.EventoAvverso;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EventiAvversi {

      @FXML
      Slider slider1 = new Slider();
      @FXML
      Slider slider2 = new Slider();
      @FXML
      Slider slider3 = new Slider();
      @FXML
      Slider slider4 = new Slider();
      @FXML
      Slider slider5 = new Slider();
      @FXML
      Slider slider6 = new Slider();
      @FXML
      TextField note1 = new TextField();
      @FXML
      TextField note2 = new TextField();
      @FXML
      TextField note3 = new TextField();
      @FXML
      TextField note4 = new TextField();
      @FXML
      TextField note5 = new TextField();
      @FXML
      TextField note6 = new TextField();

      Alert a = new Alert(AlertType.INFORMATION);

      @FXML
      private void backToHub() throws IOException {
         App.setRoot("HubIniziale");
      }

      @FXML
      private void confirm() throws IOException {
         ArrayList<EventoAvverso> eventiAvversi = fillEventi();
         a.setContentText("Eventi avversi aggiunti con successo!");
         a.show();
         for (int i = 0; i < 6; i++){
            System.out.println(eventiAvversi.get(i));
         }
         App.setRoot("HubIniziale");
      }

      private ArrayList<EventoAvverso> fillEventi() {
         ArrayList<EventoAvverso> eventiAvversi = new ArrayList<>();

         eventiAvversi.add(new EventoAvverso("Mal di testa/Nausea", (int) slider1.getValue(), note1.getText()));
         eventiAvversi.add(new EventoAvverso("Febbre", (int) slider2.getValue(), note2.getText()));
         eventiAvversi.add(new EventoAvverso("Tachicardia", (int) slider3.getValue(), note3.getText()));
         eventiAvversi.add(new EventoAvverso("Disturbi intestinali", (int) slider4.getValue(), note4.getText()));
         eventiAvversi.add(new EventoAvverso("Linfoadenopatia", (int) slider5.getValue(), note5.getText()));
         eventiAvversi.add(new EventoAvverso("Dolori vari", (int) slider6.getValue(), note6.getText()));

         return eventiAvversi;
      }
}