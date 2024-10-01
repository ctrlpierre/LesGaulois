package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	private boolean perdant = true;
	
	public Romain(String nom, int force) {
		if (force > 0) {
			this.nom = nom;
			this.force = force;
			this.equipements = new Equipement[2];
		}
	}
	
	public boolean isPerdant() {
		return perdant;
	}

	public int getForce() {
		return force;
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
	
//	public void recevoirCoup(int forceCoup) {
//		assert force > 0 : "La force d'un Romain est toujours positive.";
//		int forceAvant = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//		parler("J'abandonne...");
//		}
//		assert forceAvant > force : "La force du Romain n'as pas diminué.";
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		
		if (0 < force && force < oldForce) {
			parler("Aïe");
		} else if (force == oldForce) {
			parler("Même pas mal !");
			perdant = false;
		} else if (force <= 0) {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force <= oldForce;
		return equipementEjecte;
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
			default:
				break;
		}
	}

	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}	
			texte += resistanceEquipement + "!";
		}
		
		parler(texte);
		if (forceCoup >= resistanceEquipement) {
			forceCoup -= resistanceEquipement;
		}
		return forceCoup;
	}
	
		
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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