
package Entites;


public class Klijent {
    
    
    public String ime;
    public String adresa;
    public String telefon;
    public int starost;

    public Klijent() {
    }

    public Klijent(String ime, String adresa, String telefon, int starost) {
        this.ime = ime;
        this.adresa = adresa;
        this.telefon = telefon;
        this.starost = starost;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    @Override
    public String toString() {
        return "Klijent{" + "ime=" + ime + ", adresa=" + adresa + ", telefon=" + telefon + ", starost=" + starost + '}';
    }
    
    
}
