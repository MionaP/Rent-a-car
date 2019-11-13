
package rent.a.car;

import Entites.TarifnaKlasa;
import Entites.OsiguravajucaKuca;
import Entites.Vozilo;
import Entites.Iznajmljivanje;
import Entites.Model;
import Entites.Klijent;
import Baza.Database;
import java.sql.SQLException;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;


public class Tabela {
    
    private TableView<Klijent> tabelaKlijenta = null;
    private TableView<Model> tabelaModela = null;
    private TableView<Vozilo> tabelaVozila = null;
    private TableView<OsiguravajucaKuca> tabelaOsiguravajucaKuca = null;
    private TableView<TarifnaKlasa> tabelaTarifnaKlasa = null;
    private TableView<Iznajmljivanje> tabelaIznajmljivanje = null;
  

    private int currentTableNumber;

    private Database database;
    
    
     

    /**
     * Kontruktor koji prima broj koji oznacava sa kojom tabelom radimo
     * 
     * 
     */
    public Tabela(int number) {
        this.currentTableNumber = number;

        try {
            database = new Database();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        if (number == 0) {
            tabelaKlijenta = new TableView<>();
            TableColumn<Klijent, String> ime = new TableColumn<>("Ime");
            ime.setCellValueFactory(
                    new PropertyValueFactory<>("Ime"));

            TableColumn<Klijent, String> adresa = new TableColumn<>("Adresa");
            adresa.setCellValueFactory(
                    new PropertyValueFactory<>("Adresa"));

            TableColumn<Klijent, String> telefon = new TableColumn<>("Telefon");
            telefon.setCellValueFactory(
                    new PropertyValueFactory<>("Telefon"));

            TableColumn<Klijent, Integer> starost = new TableColumn<>("Starost");
            starost.setCellValueFactory(
                    new PropertyValueFactory<>("Starost"));

           

            tabelaKlijenta.getColumns().addAll(ime, adresa, telefon,
                    starost);

            refresh();

        } else if (number == 1) {
            tabelaModela = new TableView<>();

            TableColumn<Model, String> tarifnaKlasa = new TableColumn<>("TarifnaKlasa");
            tarifnaKlasa.setCellValueFactory(
                    new PropertyValueFactory<>("tarifnaKlasa"));

            TableColumn<Model, String> marka = new TableColumn<>("Marka");
            marka.setCellValueFactory(
                    new PropertyValueFactory<>("Marka"));

            TableColumn<Model, String> tip = new TableColumn<>("Tip");
            tip.setCellValueFactory(
                    new PropertyValueFactory<>("Tip"));

            TableColumn<Model, String> snaga = new TableColumn<>("Snaga");
            snaga.setCellValueFactory(
                    new PropertyValueFactory<>("Snaga"));

            

            tabelaModela.getColumns().addAll(tarifnaKlasa, marka, tip, snaga);

            refresh();
        } else if (number == 2) {
            tabelaVozila = new TableView<>();

            TableColumn<Vozilo, Integer> broj = new TableColumn<>("Broj");
            broj.setCellValueFactory(
                    new PropertyValueFactory<>("Broj"));

            TableColumn<Vozilo,LocalDate> datum = new TableColumn<>("Datum");
            datum.setCellValueFactory(
                    new PropertyValueFactory<>("datum"));

            TableColumn<Vozilo, Integer> kupovnaCena = new TableColumn<>("Kupovna cena");
            kupovnaCena.setCellValueFactory(
                    new PropertyValueFactory<>("Kupovna cena"));

            TableColumn<Vozilo, Integer> tekucaKilometraza = new TableColumn<>("Tekuca kilometraza");
            tekucaKilometraza.setCellValueFactory(
                    new PropertyValueFactory<>("TekucaKilometraza"));

            TableColumn<Vozilo, Boolean> popravka= new TableColumn<>("Popravka");
            popravka.setCellValueFactory(
                    new PropertyValueFactory<>("Popravka"));

            

            tabelaVozila.getColumns().addAll(broj,datum, kupovnaCena,tekucaKilometraza, popravka);

            //refresh();
        } else if (number == 3) {

            tabelaOsiguravajucaKuca = new TableView<>();

            TableColumn<OsiguravajucaKuca, String> naziv = new TableColumn<>("Naziv");
            naziv.setCellValueFactory(
                    new PropertyValueFactory<>("Naziv"));

            TableColumn<OsiguravajucaKuca, String> adresa = new TableColumn<>("Adresa");
            adresa.setCellValueFactory(
                    new PropertyValueFactory<>("Adresa"));

            TableColumn<OsiguravajucaKuca, String> telefon = new TableColumn<>("Telefon");
            telefon.setCellValueFactory(
                    new PropertyValueFactory<>("Telefon"));

            TableColumn<OsiguravajucaKuca, String> faks = new TableColumn<>("Faks");
            faks.setCellValueFactory(
                    new PropertyValueFactory<>("Faks"));

            

            tabelaOsiguravajucaKuca.getColumns().addAll(naziv, adresa, telefon,faks);

            refresh();
        } 
    }

    /**
     * Vraca odgovarajucu tabelu
     * 
     * @return tableview koji vracamo 
     */
    public TableView getTable() {
        if (currentTableNumber == 0) {
            return tabelaKlijenta;
        } else if (currentTableNumber == 1) {
            return tabelaModela;
        } else if (currentTableNumber == 2) {
            return tabelaVozila;
        } else 
            return tabelaOsiguravajucaKuca;
        
        
    }

    /**
     * Updatuje sadrzaj tabele iz baze
     */
    public void refresh() {
        try {
            if (currentTableNumber == 0) {
                database.updateTableView(tabelaKlijenta, currentTableNumber);
            } else if (currentTableNumber == 1) {
                database.updateTableView(tabelaModela, currentTableNumber);
            } else if (currentTableNumber == 2) {
                database.updateTableView(tabelaVozila, currentTableNumber);
            } else 
                database.updateTableView(tabelaOsiguravajucaKuca, currentTableNumber);
           
               
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}

    
    

