
package Entites;

import Entites.Klijent;
import java.time.LocalDate;

public class Rezervacija {
   
    public LocalDate datum;
    Vozilo vozilo = new Vozilo();
    Klijent klijent = new Klijent();

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }
    public LocalDate datumPocetka;
    public LocalDate datumPrestanka;

    public Rezervacija() {
    }

    public Rezervacija(LocalDate datum, LocalDate datumPocetka, LocalDate datumPrestanka) {
        this.datum = datum;
        this.datumPocetka = datumPocetka;
        this.datumPrestanka = datumPrestanka;
    }
    public Rezervacija(Klijent klijent, LocalDate datum, LocalDate datumPocetka, LocalDate datumPrestanka){
        this.klijent =klijent;
        this.datum = datum;
        this.datumPocetka =datumPocetka;
        this.datumPrestanka = datumPrestanka;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalDate getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(LocalDate datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public LocalDate getDatumPrestanka() {
        return datumPrestanka;
    }

    public void setDatumPrestanka(LocalDate datumPrestanka) {
        this.datumPrestanka = datumPrestanka;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "datum=" + datum + ", datumPocetka=" + datumPocetka + ", datumPrestanka=" + datumPrestanka + '}';
    }
    
    
}
