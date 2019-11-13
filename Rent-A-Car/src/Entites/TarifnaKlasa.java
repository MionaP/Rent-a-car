
package Entites;

import Entites.OsiguravajucaKuca;


public class TarifnaKlasa {
    
    public String tipOS;
    public int id;

    public TarifnaKlasa() {
    }

    public TarifnaKlasa(String tipOS, int id) {
        this.tipOS = tipOS;
        this.id = id;
    }

    public String getTipOS() {
        return tipOS;
    }

    public void setTipOS(String tipOS) {
        this.tipOS = tipOS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    OsiguravajucaKuca okuca =  new OsiguravajucaKuca();
    
}
