import java.math.BigInteger; 

public class Maillon {
    private BigInteger valeur;
    private Maillon suivant;

    public Maillon () { 
        suivant = null; 
    }

    public Maillon(BigInteger valeur) {
        this.valeur = valeur;
        this.suivant = null;
    }

    public BigInteger getVal() {
        return this.valeur;
    }

    public void setVal(BigInteger v) {
        this.valeur = v;
    }

    public Maillon getSuiv () {
        return this.suivant;
    }

    public void setSuiv (Maillon m) {
        this.suivant = m;
    }

    public String toString () {
        return String.valueOf(this.valeur);
    }
}