import java.math.BigInteger;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Dictionnaire {
    private HTNaive hashTable;

    public Dictionnaire(int m) {
        this.hashTable = new HTNaive(m);
    }

    public Dictionnaire(String fileName, int m) {
        this.hashTable = new HTNaive(Dictionnaire.calculeListeInt(fileName), m);
    }

    public Dictionnaire(String fileName, double f) {
        this.hashTable = new HTNaive(Dictionnaire.calculeListeInt(fileName), f);
    }

    public static BigInteger stringToBigInteger(String s) {
        BigInteger res = new BigInteger("0");
        BigInteger multiplieur = new BigInteger("1");
        for (int i = s.length() - 1; i >= 0; i--) {
            res = res.add(BigInteger.valueOf((int) s.charAt(i)).multiply(multiplieur));
            multiplieur = multiplieur.multiply(BigInteger.valueOf(256));
        }
        return res;
    }

    public boolean ajout(String s) {
        BigInteger value = Dictionnaire.stringToBigInteger(s);
        return this.hashTable.ajout(value);
    }

    public boolean contient(String s) {
        return this.hashTable.contient(Dictionnaire.stringToBigInteger(s));
    }

    public int getCardinal() {
        return this.hashTable.getCardinal();
    }

    public int getMaxSize() {
        return this.hashTable.getMaxSize();
    }

    public int getNbListes() {
        return this.hashTable.getNbListes();
    }
    public long getTotalTimeh() {
        return this.hashTable.getTotalTimeh();
    }

    public long getTotalTimeContient() {
        return this.hashTable.getTotalTimeContient();
    }

    public String toString() {
        return "Dictionnaire\n" + this.hashTable.toString();
    }

    public String toStringV2() {
        return "Dictionnaire\n" + this.hashTable.toStringV2();
    }

    public static ListeBigI calculeListeInt(String fileName) {
        File f = new File(fileName); ListeBigI res = new ListeBigI(); Scanner sc;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println(("Unable to get file " + e.getMessage()));
            return null;
        }
        sc.useDelimiter(", |. | |\\n|,|;|:|\\.|!|\\?|-");
        while (sc.hasNext()) {
            String mot = sc.next();
            res.ajoutTete(Dictionnaire.stringToBigInteger(mot));
        }
        sc.close();
        return res;
    }
}
 