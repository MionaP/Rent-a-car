package rent.a.car;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class RentACar extends Application {

    private RentACarStyle style = new RentACarStyle();
    private BorderPane root = new BorderPane();
    private Button logIn = new Button("Ulogujte se");
    private Button rezervisi = new Button("Rezervisite auto");
    private TextField username = new TextField();
    private PasswordField password = new PasswordField();
    private VBox vbox = new VBox();
    private HBox hbox = new HBox(10);

    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {

        logIn.setStyle(style.getBUTTON());
        rezervisi.setStyle(style.getBUTTON());
        username.setPromptText("Ukucajte username");
        password.setPromptText("Ukucajte password");
        hbox.getChildren().addAll(logIn, rezervisi);
        vbox.getChildren().addAll(username, password, hbox);
        vbox.setPadding(new Insets(60, 60, 60, 60));
        vbox.setSpacing(10);
        root.setCenter(vbox);

        Database db = new Database();

        logIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (username.getText().length() == 0 || password.getText().length() == 0) {
                    
                    JOptionPane.showMessageDialog(null, "Polja(e) prazna!");
                } else {
                    if (username.getText().startsWith("admin") && password.getText().startsWith("admin")) {
                        
                        try {
                            new PrikazUnosa(primaryStage);
                        } catch (SQLException ex) {
                            Logger.getLogger(RentACar.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RentACar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            }

        });

        rezervisi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    new KlijentGUI().start(primaryStage);
                } catch (SQLException ex) {
                    Logger.getLogger(RentACar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RentACar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        root.setStyle(style.getFRAMESTYLE());
        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Rent-a-car");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void start(String[] args) {
        launch(args);
    }
}
