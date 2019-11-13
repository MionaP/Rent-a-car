package rent.a.car;

import Entites.Klijent;
import Baza.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class KlijentGUI extends Application {

    private RentACarStyle style = new RentACarStyle();

    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {

        Label ime1 = new Label("Ime");
        TextField ime = new TextField();

        Label adresa1 = new Label("Adresa");
        TextField adresa = new TextField();

        Label starost1 = new Label("Starost");
        TextField starost = new TextField();

        Label telefon1 = new Label("Unesite telefon");
        TextField telefon = new TextField();

        Button unesi = new Button("Unesi");
        unesi.setStyle(style.getBUTTON());
        Database db = new Database();

        Button nazad = new Button("Nazad");
        nazad.setStyle(style.getBUTTON());
        unesi.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                try {
                    if (ime.getText().length() == 0 || adresa.getText().length() == 0 || starost.getText().length() == 0
                            || telefon.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Neko polje je nepopunjeno!");
                    }
                    if (Integer.parseInt(starost.getText()) < 18) {
                        JOptionPane.showMessageDialog(null, "Osoba mora da bude starija od 18 godina!");
                    } else {
                        Klijent k = new Klijent(ime.getText(), adresa.getText(), telefon.getText(), Integer.parseInt(starost.getText()));
                        db.ubaciKlijent(k);
                        new RezervacijaGUI().start(primaryStage);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Nema osobe");
                    return;
                }

            }
        });

        nazad.setOnAction(e -> {

            try {
                new RentACar().start(primaryStage);
            } catch (SQLException ex) {
                Logger.getLogger(KlijentGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(KlijentGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setVgap(10);
        root.setHgap(5);

        root.add(ime1, 0, 0);
        root.add(ime, 1, 0);
        root.add(adresa1, 0, 1);
        root.add(adresa, 1, 1);
        root.add(starost1, 0, 2);
        root.add(starost, 1, 2);
        root.add(telefon1, 0, 3);
        root.add(telefon, 1, 3);

        root.add(unesi, 3, 4);
        root.add(nazad, 5, 4);
        root.setStyle(style.getFRAMESTYLE());
        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Klijent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start(String[] args) {
        launch(args);
    }
}
