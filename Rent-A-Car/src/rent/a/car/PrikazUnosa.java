package rent.a.car;

import Entites.Vozilo;
import Entites.Model;
import Baza.Database;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class PrikazUnosa extends Application {

    private RentACarStyle style = new RentACarStyle();

    public PrikazUnosa(Stage primaryStage) throws SQLException, ClassNotFoundException {
     
    



        Button unesiModel = new Button("Unesi model");
        Button unesiVozilo = new Button("Unesi vozilo");
        unesiModel.setStyle(style.getBUTTON());
        unesiVozilo.setStyle(style.getBUTTON());

        Label label1 = new Label("Unesi marku modela");
        Label label2 = new Label("Unesite snagu modela");
        Label label3 = new Label("Unesite tip modela");
        Label label4 = new Label("Unesite tarifnu klasu modela");

        TextField marka = new TextField();
        TextField snaga = new TextField();
        TextField tip = new TextField();
        TextField tarifnaklasa = new TextField();

        Label label5 = new Label("Unesibroj vozila ");
        Label label6 = new Label("kupovna cena");
        Label label7 = new Label("tekuca kilometraza");
        Label label8 = new Label("Unesite datum");
        Label label9 = new Label("Da li je vozilo na popravci?");
        Button nazad = new Button("Nazad");
        Database db = new Database();

        TextField broj = new TextField();
        TextField kupovnaCena = new TextField();
        TextField tekucaKilometraza = new TextField();

        CheckBox popravka = new CheckBox();
        DatePicker datePicker = new DatePicker();

        GridPane gp = new GridPane();
        GridPane gp1 = new GridPane();
        BorderPane bp = new BorderPane();

        ArrayList<Vozilo> list = new ArrayList<>();

        unesiModel.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {

                if (marka.getText().length() == 0 || snaga.getText().length() == 0 || tip.getText().length() == 0 || tip.getText().length() == 0 || tarifnaklasa.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Polja(e) prazna!");
                } else {
                    Model model = new Model(tarifnaklasa.getText(), marka.getText(), tip.getText(), snaga.getText());
                    db.ubaciModel(model);
                    JOptionPane.showMessageDialog(null, "Uspesno ste uneli model");

                }

            }

        });

        unesiVozilo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (broj.getText().length() == 0 || kupovnaCena.getText().length() == 0 || tekucaKilometraza.getText().length() == 0 || popravka.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Polja(e) prazna!");
                } else {
                    int br = Integer.parseInt(broj.getText());
                    int kc = Integer.parseInt(kupovnaCena.getText());
                    int tk = Integer.parseInt(tekucaKilometraza.getText());
                    Vozilo vozilo = new Vozilo(br, datePicker.getValue(), kc, tk, popravka.isSelected());
                    list.add(vozilo);
                    db.ubaciVozilo(vozilo);
                    JOptionPane.showMessageDialog(null, "Uneto vozilo!");

                }
            }
        });

        nazad.setOnAction(e -> {

            try {
                new RentACar().start(primaryStage);
            } catch (SQLException ex) {
                Logger.getLogger(PrikazUnosa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PrikazUnosa.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        gp.add(label1, 0, 0);
        gp.add(marka, 1, 0);
        gp.add(label2, 0, 1);
        gp.add(snaga, 1, 1);
        gp.add(label3, 0, 2);
        gp.add(tip, 1, 2);
        gp.add(label4, 0, 3);
        gp.add(tarifnaklasa, 1, 3);
        gp.add(unesiModel, 0, 4);

        gp1.add(label5, 0, 0);
        gp1.add(broj, 1, 0);
        gp1.add(label7, 0, 1);
        gp1.add(tekucaKilometraza, 1, 1);
        gp1.add(label6, 0, 2);
        gp1.add(kupovnaCena, 1, 2);
        gp1.add(label9, 0, 3);
        gp1.add(popravka, 1, 3);
        gp1.add(label8, 0, 4);
        gp1.add(datePicker, 1, 4);
        gp1.add(unesiVozilo, 0, 5);

        bp.setLeft(gp);
        bp.setRight(gp1);
        bp.setBottom(nazad);
        bp.setStyle(style.getFRAMESTYLE());
        Scene scene = new Scene(bp, 600, 600);

        primaryStage.setTitle("Unos podataka");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
   

   
    public void start(String[] args) throws Exception {
         launch(args);

}

    @Override
    public void start(Stage primaryStage) throws Exception {
       
    }
}
