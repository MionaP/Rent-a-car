
package Entites;

import java.time.LocalDate;


public class Vozilo {
    
    public int broj;
    public LocalDate datum;
    public int kupovnaCena;
    public int tekucaKilometraza;
    public boolean popravka;

    public Vozilo() {
    }

    public Vozilo(int broj, LocalDate datum, int kupovnaCena, int tekucaKilometraza, boolean popravka) {
        this.broj = broj;
        this.datum = datum;
        this.kupovnaCena = kupovnaCena;
        this.tekucaKilometraza = tekucaKilometraza;
        this.popravka = popravka;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getKupovnaCena() {
        return kupovnaCena;
    }

    public void setKupovnaCena(int kupovnaCena) {
        this.kupovnaCena = kupovnaCena;
    }

    public int getTekucaKilometraza() {
        return tekucaKilometraza;
    }

    public void setTekucaKilometraza(int tekucaKilometraza) {
        this.tekucaKilometraza = tekucaKilometraza;
    }

    public boolean isPopravka() {
        return popravka;
    }

    public void setPopravka(boolean popravka) {
        this.popravka = popravka;
    }

    @Override
    public String toString() {
        return "Vozilo{" + "broj=" + broj + ", datum=" + datum + ", kupovnaCena=" + kupovnaCena + ", tekucaKilometraza=" + tekucaKilometraza + ", popravka=" + popravka + '}';
    }
    
    
}
