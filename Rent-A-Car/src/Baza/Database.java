package Baza;

import com.sun.scenario.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javafx.scene.control.TableView;
import java.time.LocalDate;
import Entites.Klijent;
import Entites.Model;
import Entites.OsiguravajucaKuca;
import Entites.Rezervacija;
import Entites.TarifnaKlasa;
import Entites.Vozilo;



public class Database {

    private Connection connection;
    private String url = "jdbc:mysql://localhost/";
    private String username = "root";
    private String password = "";
    private String databaseName = "rentacar";

    private String tabelaModel = "model";
    private String tabelaTarifnaKlasa = "tarifnaklasa";
    private String tabelaVozilo = "vozilo";

    private String tabelaIznajmljivanje = "iznajmljivanje";
    private String tabelaKlijent = "klijent";
    private String tabelaRezervacija = "rezervacija";

    private String tabelaOsiguravajucaKuca = "osiguravajucakuca";

    public Database() throws SQLException, ClassNotFoundException {

        System.out.println();

    }

    private void kreirajBazuAkoNePostoji() throws SQLException {

        connection = DriverManager.getConnection(url + databaseName, username, password);
        System.out.println("Connected");

        try {

            Statement st = (Statement) connection.createStatement();
            st.execute("CREATE DATABASE IF NOT EXISTS\" + databaseName;");
            connection.close();
        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        connection.close();

    }

    private void kreirajTabeluModelaAkoNePostoji() throws ClassNotFoundException, SQLException {

        try {

            connection = DriverManager.getConnection(url + databaseName, username, password);
            Statement st = (Statement) connection.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS" + tabelaModel
                    + "(idmodel INTEGER NOT NULL AUTO_INCREMENT,"
                    + " tarifnaKlasa char(30),"
                    + " marka char(30),"
                    + "tip char(30), "
                    + "snaga char(30),"
                    + "PRIMARY KEY (idmodel))");

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    private void kreirajTabeluTarifnaKlasaAkoNePostoji() throws ClassNotFoundException, SQLException {

        try {

            connection = DriverManager.getConnection(url + databaseName, username, password);
            Statement st = (Statement) connection.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS" + tabelaTarifnaKlasa
                    + "(idtk INTEGER NOT NULL AUTO_INCREMENT,"
                    + "tipOS VARCHAR(35),"
                    + "PRIMARY KEY(idtk))");

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    private void kreirajTabeluVozilaAkoNePostoji() throws ClassNotFoundException, SQLException {

        try {

            connection = DriverManager.getConnection(url + databaseName, username, password);
            Statement st = (Statement) connection.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS" + tabelaVozilo
                    + "(id INTEGER NOT NULL AUTO_INCREMENT,"
                    + "broj int(20),"
                    + "datum DATE"
                    + "kupovnaCena int(20)"
                    + "tekucaKilometraza int(20)"
                    + "popravka  boolean"
                    + "PRIMARY KEY(id))");

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    private void kreirajTabeluIznajmljivanjeAkoNepostoji() throws ClassNotFoundException, SQLException {

        try {

            connection = DriverManager.getConnection(url + databaseName, username, password);
            Statement st = (Statement) connection.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS " + tabelaIznajmljivanje
                    + "(idrent INTEGER NOT NULL AUTO_INCREMENT, "
                    + " dnevno boolean, "
                    + " sedmicno boolean "
                    + " vikend boolean "
                    + " Vozilo.id int, "
                    + " CONSTRAINT RentPk PRIMARY KEY(idrent) "
                    + " CONSTRAINT VoziloFK FOREING KEY REFERENCES(id)"
                    + "ON DELETE NO ACTION, ON UPDATE NO ACTION))"
                    + " PRIMARY KEY (id))");

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    private void kreirajTabeluKlijentAkoNepostoji() throws ClassNotFoundException, SQLException {

        try {

            connection = DriverManager.getConnection(url + databaseName, username, password);
            Statement st = (Statement) connection.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS " + tabelaKlijent
                    + "(idklijent INTEGER NOT NULL AUTO_INCREMENT, "
                    + " ime char(30) "
                    + " adresa char(30) "
                    + " telefon char(30), "
                    + " starost int(10), "
                    + " PRIMARY KEY (id))");

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    private void kreirajTabeluRezervacijaAkoNepostoji() throws ClassNotFoundException, SQLException {

        try {

            connection = DriverManager.getConnection(url + databaseName, username, password);
            Statement st = (Statement) connection.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS " + tabelaRezervacija
                    + "(idrezervacija INTEGER NOT NULL AUTO_INCREMENT, "
                    + " datum DATE, "
                    + " datumpocetka DATE, "
                    + " datumprestanka DATE "
                    + " vreme DATE, "
                    + " PRIMARY KEY (id))");

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    private void kreirajTabeluOsiguravajucaKucaAkoNePostoji() throws ClassNotFoundException, SQLException {

        try {

            connection = DriverManager.getConnection(url + databaseName, username, password);
            Statement st = (Statement) connection.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS" + tabelaOsiguravajucaKuca
                    + "(ido INTEGER NOT NULL AUTO_INCREMENT,"
                    + " naziv char(30),"
                    + "adresa char(30),"
                    + "telefon char(30),"
                    + "faks char(30),,"
                    + "PRIMARY KEY (ido))");

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public boolean ubaciModel(Model model) {

        try {
            connection = DriverManager.getConnection(url + databaseName, username, password);

            String query = "INSERT INTO " + tabelaModel + " (tarifnaKlasa, marka, "
                    + "tip, snaga) VALUES(?, ?, ?, ?) ";

            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);

            stmt.setString(1, model.getTarifnaKlasa());
            stmt.setString(2, model.getMarka());
            stmt.setString(3, model.getTip());
            stmt.setString(4, model.getSnaga());

            stmt.execute();

            connection.close();

        } catch (SQLException e) {
            return false;
        }

        return true;

    }

    public boolean ubaciTafifnaKlasa(TarifnaKlasa tarifnaKlasa) {

        try {
            connection = DriverManager.getConnection(url + databaseName, username, password);

            String query = "INSERT INTO " + tabelaTarifnaKlasa + " (tipOs, id, "
                    + ") VALUES(?, ?) ";

            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);

            stmt.setString(1, tarifnaKlasa.getTipOS());
            stmt.setInt(2, tarifnaKlasa.getId());

            stmt.execute();

            connection.close();

        } catch (SQLException e) {
            return false;
        }

        return true;

    }

    public boolean ubaciVozilo(Vozilo vozilo) {

        try {
            connection = DriverManager.getConnection(url + databaseName, username, password);

            String query = "INSERT INTO " + tabelaVozilo + " (broj, datum, "
                    + "kupovnaCena, kilometraza, popravka) VALUES(?, ?, ?, ?, ?) ";

            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);

            stmt.setInt(1, vozilo.getBroj());
            Date d = java.sql.Date.valueOf(vozilo.getDatum());
            stmt.setDate(2, d);
            stmt.setInt(3, vozilo.getKupovnaCena());
            stmt.setInt(4, vozilo.getTekucaKilometraza());
            stmt.setBoolean(5, vozilo.isPopravka());

            stmt.execute();

            connection.close();

        } catch (SQLException e) {
            return false;
        }

        return true;

    }

    public boolean ubaciKlijent(Klijent klijent) {

        try {
            connection = DriverManager.getConnection(url + databaseName, username, password);

            String query = "INSERT INTO " + tabelaKlijent + " (ime, adresa, "
                    + "telefon, starost) VALUES(?, ?, ?, ?) ";

            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);

            stmt.setString(1, klijent.getIme());
            stmt.setString(2, klijent.getAdresa());
            stmt.setString(3, klijent.getTelefon());
            stmt.setInt(4, klijent.getStarost());

            stmt.execute();

            connection.close();

        } catch (SQLException e) {
            return false;
        }

        return true;

    }

    public boolean ubaciRezervaciju(Rezervacija rezervacija) {

        try {
            connection = DriverManager.getConnection(url + databaseName, username, password);

            String query = "INSERT INTO " + tabelaRezervacija + " (datum, datumPocetka, "
                    + "datumPrestanka) VALUES(?, ?, ?) ";

            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
            
            Date d = java.sql.Date.valueOf(rezervacija.getDatum());
            Date dp = java.sql.Date.valueOf(rezervacija.getDatumPocetka());
            Date dk = java.sql.Date.valueOf(rezervacija.getDatumPrestanka());
            
            
            
            stmt.setDate(1, d);
            stmt.setDate(2, dp);
            stmt.setDate(3, dk);

            stmt.execute();

            connection.close();

        } catch (SQLException e) {
            return false;
        }

        return true;

    }
   public void updateTableView(TableView tableView, int i) throws SQLException {

        tableView.getItems().clear();

        String imeTabele = "";

        if (i == 0) {
            imeTabele = tabelaKlijent;
        } else if (i == 1) {
            imeTabele = tabelaModel;
        } else if (i == 2) {
            imeTabele = tabelaVozilo;
        } else if (i == 3) {
            imeTabele = tabelaOsiguravajucaKuca;
        
        }

        connection = DriverManager.getConnection(url + databaseName, username, password);

        String query = "SELECT * FROM " + imeTabele;
        if (i == 0) {
            query = "SELECT * FROM " + imeTabele + " WHERE id != 1";
        }
        Statement st = (Statement) connection.createStatement();

        ResultSet rs = st.executeQuery(query);

        if (i == 0) {
            while (rs.next()) {

                Klijent klijent = new Klijent(rs.getString("ime"),rs.getString("adresa"), rs.getString("telefon"),rs.getInt("starost"));
                
                tableView.getItems().add(klijent);

            }
        } else if (i == 1) {
            while (rs.next()) {
                Model model = new Model(rs.getString("tarifnaKlasa"), rs.getString("marka"), rs.getString("tip"), rs.getString("snaga"));

                
                tableView.getItems().add(model);

            }
        } else if (i == 2) {
            while (rs.next()) {
               LocalDate d = java.time.LocalDate.parse((CharSequence) rs.getDate("datum"));
               Vozilo vozilo = new Vozilo(rs.getInt("broj"),d,rs.getInt("kupovnaCena"), rs.getInt("tekucaKilometraza"), rs.getBoolean("popravka"));

               
                tableView.getItems().add(vozilo);

            }
        } else if (i == 3) {
            while (rs.next()) {

                OsiguravajucaKuca os = new OsiguravajucaKuca(rs.getString("naziv"), rs.getString("adresa"), rs.getString("telefon"), rs.getString("faks"));
                
                tableView.getItems().add(os);

            }
      
        }

        connection.close();

    }
   
   public List<String> dnevnoRezervisani(LocalDate l) throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        String query = "SELECT * FROM rezervacija WHERE datum ='" + l + " 00:00:00' ";
        Statement statement = (Statement) connection.createStatement();
        ResultSet result = (ResultSet) statement.executeQuery(query);
        String rezervacija = "";
        while (result.next()) {
             rezervacija= result.getString("rezervacija");
            list.add(rezervacija);
        }
        return list;

    }
   
    public List<String> listaVozila() throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        String query = "SELECT * FROM vozilo ";
        Statement statement = (Statement) connection.createStatement();
        ResultSet result = (ResultSet) statement.executeQuery(query);
        String vozilo = "";
        while (result.next()) {
            vozilo = result.getString("vozilo");
            list.add(vozilo);
        }
        return list;

    }
    
    public float VozilaCena() throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        String query = "SELECT kupovnaCena FROM vozilo ";
        Statement statement = (Statement) connection.createStatement();
        ResultSet result = (ResultSet) statement.executeQuery(query);
        float cena = 0;
        float ukupnaCena = 0;
        while (result.next()) {
            cena = result.getFloat("kupovnaCena");
            ukupnaCena += cena;
        }
        return ukupnaCena;

    }
    
     public List<String> dnevnaRezervacija(LocalDate l) throws SQLException {
        List<String> list = dnevnoRezervisani(l);
        List<String> tempList = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            String[] niz = list.get(j).split(",");

            for (int i = 0; i < niz.length; i++) {
                tempList.add(niz[i]);
            }
        }
        return tempList;
    }
     
      public List<String> VozilaSplitovanje() throws SQLException {
        List<String> list = listaVozila();
        List<String> tempList = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            String[] niz = list.get(j).split(",");

            for (int i = 0; i < niz.length; i++) {
                tempList.add(niz[i]);
            }
        }
        return tempList;
    }
      
      public void izbrisiRezervaciju(int id) throws SQLException {
        String query = "DELETE FROM rezervacija WHERE idr = " + id;
        Statement st = connection.createStatement();
        st.execute(query);
    }
    // ,imamo metod za nalazenje svih rezervisanih , i ukupne liste vozila pa cemo
      //slobodna vozila naci tako sto cemo od ukupnog broja svih vozila oduzeti ona koja su rezervisana
   public int najstarijiKlijent() throws SQLException {
        String query = "SELECT max(starost) FROM Klijent";
        Statement statement = (Statement) connection.createStatement();
        ResultSet result = (ResultSet) statement.executeQuery(query);
        int id = 0;
        while (result.next()) {
            id = result.getInt("starost");
        }
        return id;
    }
   
   public ArrayList nadjiSveKlijente() throws SQLException {
        ArrayList<Klijent> list = new ArrayList<>();
        String query = "SELECT ime,prezime,id_zaposlenog,zaposlenje FROM zaposleni";
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
        while (result.next()) {
            
                list.add(new Klijent(result.getString("ime"),result.getString("adresa"),result.getString("telefon"),result.getInt("starost")));
            
        }
        return list;
    }


}
