
import java.math.BigInteger;

public class ListeBigI {

	private Maillon tete;

	/**
	 * Constructeur d'une liste vide
	 */
	public ListeBigI() {
		this.tete = null;
	}

	public ListeBigI(Maillon m) { // OBSOLETE : NE PLUS UTILISER
		this.tete = m;
	}

	/**
	 * Constructeur d'une liste a un seul element
	 */
	public ListeBigI(BigInteger x) {
		this.tete = new Maillon(x); // ou bien: this(new Maillon(x));
	}

	/**
	 * @param tabListe est un tableau contenant les elements de la liste
	 *                 Pre-requis : aucun
	 */
	public ListeBigI(BigInteger[] tabListe) {
		this();
		if (tabListe.length > 0) {
			this.tete = new Maillon(tabListe[0]);
			Maillon curThis = this.tete;
			for (int i = 1; i < tabListe.length; i++) {
				curThis.setSuiv(new Maillon(tabListe[i])); // creation et accrochage du maillon (encore vide) suivant
				curThis = curThis.getSuiv();
			}
		}
	}

	/**
	 * Prerequis: aucun
	 * construit une liste completement disjointe de la liste l
	 */
	public ListeBigI(ListeBigI l) { // constructeur par recopie profonde
		this();
		if (!l.estVide()) {
			this.tete = new Maillon(l.tete.getVal());
			Maillon curThis = this.tete;
			Maillon curL = l.tete.getSuiv();
			while (curL != null) {
				curThis.setSuiv(new Maillon(curL.getVal())); // creation et accrochage du maillon suivant
				curThis = curThis.getSuiv();
				curL = curL.getSuiv();
			}
		}
	}

	public boolean estVide() {
		return (this.tete == null);
	}

	public int longueur() {
		int res = 0; Maillon current = this.tete;
		while (current != null) {
			current = current.getSuiv();
			res ++;
		}
		return res;
	}

	public void ajoutTete(BigInteger x) {
		Maillon m = new Maillon(x);
		m.setSuiv(this.tete);
		this.tete = m;
	}

	public void ajoutListe(ListeBigI l) {
		Maillon current = l.tete;
		while (current != null) {
			ajoutTete(current.getVal());
			current = current.getSuiv();
		}
	}

	public String toString() {
		String s = "(";
		Maillon current = this.tete;
		while (current != null) {
			s += (current.getVal()) + ((current.getSuiv() != null) ? ", " : "");
			current = current.getSuiv();
		}
		return s + ")";
	}

	public BigInteger supprTete() {
		BigInteger res = this.tete.getVal();
		this.tete = this.tete.getSuiv();
		return res;
	}

	public void ajoutFin(BigInteger n) {
		if (this.estVide()) {
			this.tete = new Maillon(n);
		} else {
			Maillon courant = this.tete;
			while (courant.getSuiv() != null) {
				courant = courant.getSuiv();
			}
			courant.setSuiv(new Maillon(n));
		}
	}

	public boolean contient(BigInteger x) {
		Maillon current = this.tete;
		while (current != null && !(current.getVal().equals(x)))
			current = current.getSuiv();
		return current != null;
	}

	public void supprOcc(BigInteger n) {
		if (!this.estVide() && this.tete.getVal().equals(n)) {
			this.tete = this.tete.getSuiv();
		} else if (!this.estVide()) {
			Maillon last = this.tete;
			Maillon current = last.getSuiv();
			while (current != null && current.getVal() != n) {
				last = current;
				current = current.getSuiv();
			}
			if (current != null) last.setSuiv(current.getSuiv());
		}
	}
}
