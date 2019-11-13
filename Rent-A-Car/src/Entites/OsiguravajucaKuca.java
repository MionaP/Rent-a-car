
package Entites;


public class OsiguravajucaKuca {
    
    public String naziv;
    public String adresa;
    public String telefon;
    public String faks;

    public OsiguravajucaKuca() {
    }

  

    public OsiguravajucaKuca(String naziv, String adresa, String telefon, String faks) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.telefon = telefon;
        this.faks = faks;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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

    public String getFaks() {
        return faks;
    }

    public void setFaks(String faks) {
        this.faks = faks;
    }

    @Override
    public String toString() {
        return "OsiguravajucaKuca{" + "naziv=" + naziv + ", adresa=" + adresa + ", telefon=" + telefon + ", faks=" + faks + '}';
    }
    
    
}
