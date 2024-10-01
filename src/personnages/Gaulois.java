package personnages;
import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] listTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		
		for (int i = 0; listTrophees != null && i < listTrophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = listTrophees[i];
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	public void faireUneDonnation(Musee musee) {
		String texte = "Je donne au musée tous mes trophees :";
		int i = 0;
		while (i < nbTrophees && musee.getNbTrophees() < 200) {
			musee.donnerTrophees(this, trophees[i]);
			texte += "\n- " + trophees[i];
			trophees[i++] = null;
		}
		parler(texte);
		nbTrophees = 0;
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion="
		+ effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain aFrapper = new Romain("Romain à frapper", 1);
		System.out.println(asterix);
		asterix.parler("Je suis en phase de test");
		asterix.boirePotion(5);
		asterix.frapper(aFrapper);
	}
}