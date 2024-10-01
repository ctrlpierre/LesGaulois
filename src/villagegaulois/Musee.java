package villagegaulois;
import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees = 0;
	
	public int getNbTrophees() {
		return nbTrophees;
	}

	public void donnerTrophees(Gaulois donateur, Equipement equipement) {
		if (nbTrophees < 200) {
			trophees[nbTrophees++] = new Trophee(donateur, equipement);
		}
	}
}
