/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rent.a.car;

import Entites.Vozilo;
import Entites.Rezervacija;
import Entites.Model;
import Baza.Database;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import rent.a.car.PrikazUnosa;

class RezervacijaGUI extends Application {
    
    ArrayList<Vozilo> list = new ArrayList<>();
    ArrayList<Model> model = new ArrayList<>();
    
    
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
        
        CheckBox ch1 = new CheckBox("Dnevno iznajmljivanje vozila");
        CheckBox ch2 = new CheckBox("Sedmicno iznajmljivanje vozila");
        CheckBox ch3 = new CheckBox("Vikend iznajmljivanje vozila");
        
        
        
        ListView<String> rezervisanaVozila = new ListView<>();
        rezervisanaVozila.setPrefHeight(120);
        
        Label pocetak = new Label("Pocetak rezervacije?");
        DatePicker datePicker = new DatePicker();
        
        Label kraj = new Label("Kraj rezervacije?");
        DatePicker datep = new DatePicker();
       
        
        
        Database d = new Database();
        
        Button rezervisi = new Button("Rezervisi");
        Button nazad = new Button("Nazad");
        
        Label datuml = new Label("Datum kada pocinje iznajmljivanje:");
        DatePicker dp = new DatePicker();
        
        ListView<String> naruceniAutomobili = new ListView<>();
        naruceniAutomobili.setPrefHeight(120);
        
        TableView<Model> tabelaModela = new Tabela(1).getTable();
        tabelaModela.setPrefHeight(120);
        
        Button clearAll = new Button("Izbrisi Sve");
        clearAll.setOnAction(e -> {
            naruceniAutomobili.getItems().clear();
            
        });
        
        rezervisi.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                try {
                    if ((ch1.isSelected() && ch2.isSelected() && ch3.isSelected()) || (ch1.isSelected() && ch2.isSelected()) || (ch1.isSelected() && ch3.isSelected()) || (ch2.isSelected() && ch3.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Jedan tip iznajmljivanja treba biti selektovan!");
                }
                     else {
                        Calendar now = Calendar.getInstance();
                    LocalDate d = java.time.LocalDate.parse((CharSequence) now.getTime());
                    Rezervacija r;
                    r = new Rezervacija(d,datePicker.getValue(), datep.getValue());
                    JOptionPane.showMessageDialog(null, "Uspesna rezervacija!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Nema rezervacije");
                    return;
                }

            }
        });
         
        
         nazad.setOnAction(e -> {

            try {
                new RentACar().start(primaryStage);
            } catch (SQLException ex) {
                Logger.getLogger(RezervacijaGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RezervacijaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         
         
         tabelaModela.setOnMousePressed((MouseEvent event) -> {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Model m = tabelaModela.getSelectionModel().getSelectedItem();
                    rezervisanaVozila.getItems().add(m.getMarka()+ " " + m.getSnaga()+ " "+ m.getTarifnaKlasa()+" "+m.getTip());
                    
                    
                }
            });
        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        VBox vbox1 = new VBox();
        
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(10);
        vbox1.setPadding(new Insets(20, 20, 20, 20));
        vbox1.setSpacing(10);
        vbox.getChildren().addAll(ch1, ch2, ch3);
        vbox1.getChildren().addAll(pocetak, datePicker, kraj, datep);
        root.setCenter(vbox1);
        root.setRight(vbox);
        HBox button = new HBox();
        button.setSpacing(60);
        button.getChildren().addAll(rezervisi, nazad);
        root.setBottom(button);
        root.setLeft(tabelaModela);
        
        Scene scene = new Scene(root, 1000, 450);
        
        primaryStage.setTitle("Rezervacija");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void start(String[] args) {
        launch(args);
    }
    
}
