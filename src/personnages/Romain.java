package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force > 0 : "La force d'un Romain est toujours positive.";
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force > 0 : "La force d'un Romain est toujours positive.";
		int forceAvant = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
		parler("J'abandonne...");
		}
		assert forceAvant > force : "La force du Romain n'as pas diminué.";
	}
	
	public void sEquiper(Equipement e) {
		switch (nbEquipement) {
			case 2:
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1:
				if (equipements[0] == e) {
					System.out.println("Le soldat " + nom + " possède déjà un " + e + " !");
				} 
				else {
					equipements[1] = e;
					System.out.println("Le soldat " + nom + " s'équipe avec un " + e + ".");
					nbEquipement++;
				}
				break;
			case 0:
				equipements[0] = e;
				System.out.println("Le soldat " + nom + " s'équipe avec un " + e + ".");
				nbEquipement++;
				break;
		}
	}

	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus);
		minus.parler("Je vais me frapper !");
		minus.recevoirCoup(69420);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}