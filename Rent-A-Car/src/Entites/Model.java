
package Entites;


public class Model {
    
    public String tarifnaKlasa;
    public String marka;
    public String tip;
    public String snaga;

    public Model() {
    }

    public Model(String tarifnaKlasa, String marka, String tip, String snaga) {
        this.tarifnaKlasa = tarifnaKlasa;
        this.marka = marka;
        this.tip = tip;
        this.snaga = snaga;
    }

    public String getTarifnaKlasa() {
        return tarifnaKlasa;
    }

    public void setTarifnaKlasa(String tarifnaKlasa) {
        this.tarifnaKlasa = tarifnaKlasa;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getSnaga() {
        return snaga;
    }

    public void setSnaga(String snaga) {
        this.snaga = snaga;
    }

    @Override
    public String toString() {
        return "Car{" + "tarifnaKlasa=" + tarifnaKlasa + ", marka=" + marka + ", tip=" + tip + ", snaga=" + snaga + '}';
    }
    
}
