import java.util.*;

public class Test {

    public static void main(String[] args) {

        Random ran = new Random();
        
        // pour un dico créé à partir du fichier radnomWordsPetit.txt avec m appartenant à {1,2,3,4}
        // Dictionnaire d = new Dictionnaire("randomWordsPetit.txt", 50);
 
        // pour un dico créé à partir du fichier radnomWords.txt avec f appartenant à {0.01,0.1,0.5,1}
        Dictionnaire d = new Dictionnaire("randomWords.txt", 0.1);

        System.out.println("maxSize : " + d.getMaxSize());
        System.out.println("cardinal : " + d.getCardinal());
        System.out.println("nbListes : " + d.getNbListes());
        System.out.println("totalTimeh : " + d.getTotalTimeh() + " ms");
        System.out.println("totalTimeContient : " + d.getTotalTimeContient() + " ms");

        int nbRecherches = 100000;

        long deb = System.currentTimeMillis();

        for (int i = 0; i < nbRecherches; i++) {

            int tailleMot = ran.nextInt(15) + 2; // 2 <= tailleMot <= 16

            char[] mot = new char[tailleMot];

            for (int j = 0; j < mot.length; j++) {
                mot[j] = (char) ('a' + ran.nextInt(26));
            }

            String motS = new String(mot);
            d.contient(motS);// on ne récupère même pas le résultat de la recherche!
        }

        long fin = System.currentTimeMillis();

        System.out.println("temps total : " + (fin - deb) + " ms");
    }

}
