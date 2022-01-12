import java.math.BigInteger;

public class HTNaive {

    private ListeBigI[] t;
    private long totalTimeh;
    private long totalTimeContient;

    public HTNaive(int m) {
        this.t = new ListeBigI[m];
        this.totalTimeh = 0;
        this.totalTimeContient = 0;
        for (int i = 0; i < m; i++)
            this.t[i] = new ListeBigI();
    }

    public HTNaive(ListeBigI l, int m) {
        this(m);
        this.ajoutListe(l);
    }

    public HTNaive(ListeBigI l, double f) {
        this(l, (int) (f * HTNaive.cardListe(l)));
    }

    private static int cardListe(ListeBigI l) {
        return new HTNaive(l, 1000).getCardinal();
    }

    public ListeBigI getListe(int i) {
        return this.t[i];
    }

    public long getTotalTimeh() {
        return this.totalTimeh;
    }

    public long getTotalTimeContient() {
        return this.totalTimeContient;
    }

    private int h(BigInteger u) {
        long start = System.currentTimeMillis();
        int res = u.mod(BigInteger.valueOf(this.t.length)).intValue();
        this.totalTimeh += (System.currentTimeMillis() - start);
        return res;
    }

    public boolean contient(BigInteger u) {
        long start = System.currentTimeMillis();
        boolean res = this.t[this.h(u)].contient(u);
        this.totalTimeContient += (System.currentTimeMillis() - start);
        return res;
    }

    public boolean ajout(BigInteger u) {
        return this.contient(u) ? false : this.ajoutAux(u);
    }

    private boolean ajoutAux(BigInteger u) {
        this.t[this.h(u)].ajoutTete(u);
        return true;
    }

    public void ajoutListe(ListeBigI L) {
        ListeBigI listeCourante = new ListeBigI(L);
        while (!listeCourante.estVide()) 
            this.ajout(listeCourante.supprTete());
    }

    public ListeBigI getElements() {
        ListeBigI L = new ListeBigI();
        for (int i = 0; i < this.t.length; i++) L.ajoutListe(this.t[i]);
        return L;
    }

    public String toString() {
        String res = "";    
        for (int i = 0; i < this.t.length; i++)
            res += "t[" + i + "] : " + this.t[i].toString() + "\n";
        return res;
    }

    public int getNbListes() {
        return this.t.length;
    }

    public int getCardinal() {
        return this.getElements().longueur();
    }

    public int getMaxSize() {
        int res = 0;
        for (int i = 0; i < this.t.length; i++)
            if (this.t[i].longueur() > res) res = this.t[i].longueur();
        return res;
    }

    public String toStringV2() {
        String res = "";
        for (int i = 0; i < this.t.length; i++) {
            if (!this.t[i].estVide()) {
                res += "t[" + i + "] : ";
                for (int j = 0; j < this.t[i].longueur(); j++) res += "*";
                res += "\n";
            }
        }
        return res;
    }
} 