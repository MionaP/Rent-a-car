
package Entites;


public class Iznajmljivanje {
    
   
    public boolean dnevnoIznamljivanje;
    public boolean sedmicnoIznamljivanje;
    public boolean vikendIznamljivanje;

    public Iznajmljivanje() {
    }

    public Iznajmljivanje( boolean dnevnoIznamljivanje, boolean sedmicnoIznamljivanje, boolean vikendIznamljivanje) {
       
        this.dnevnoIznamljivanje = dnevnoIznamljivanje;
        this.sedmicnoIznamljivanje = sedmicnoIznamljivanje;
        this.vikendIznamljivanje = vikendIznamljivanje;
    }

  
    

   

    public boolean isDnevnoIznamljivanje() {
        return dnevnoIznamljivanje;
    }

    public void setDnevnoIznamljivanje(boolean dnevnoIznamljivanje) {
        this.dnevnoIznamljivanje = dnevnoIznamljivanje;
    }

    public boolean isSedmicnoIznamljivanje() {
        return sedmicnoIznamljivanje;
    }

    public void setSedmicnoIznamljivanje(boolean sedmicnoIznamljivanje) {
        this.sedmicnoIznamljivanje = sedmicnoIznamljivanje;
    }

    public boolean isVikendIznamljivanje() {
        return vikendIznamljivanje;
    }

    public void setVikendIznamljivanje(boolean vikendIznamljivanje) {
        this.vikendIznamljivanje = vikendIznamljivanje;
    }

  
}
