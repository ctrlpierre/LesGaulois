package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getNbVillageois() {
		return nbVillageois;
	}
	
	public void ajouterHabitant(Gaulois g, int place) {
		assert 0 <= place && place < villageois.length : "La place est strictement < au nbMax de villageois.";
		villageois[place] = g;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];
	}
	
	public void afficherVillageois() {
		if (chef != null) {
			System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		} else {
			System.out.println("Dans ce village sans chef vivent les légendaires gaulois :");
		}
		for (int i = 0; i < villageois.length; i++) {
			if (villageois[i] != null) {
				System.out.println("- " + villageois[i].getNom());
			}
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		
//		Gaulois gaulois = village.trouverHabitant(30);
//		Index out of range
		
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(asterix, 0);
		village.ajouterHabitant(obelix, 1);
		village.afficherVillageois();
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		En effet, on a mis Astérix en position 0 et on le cherche en 
//		position 1, cela renvoie donc null car on a pas initialisé 
//		le villageois d'indice 1		
	}
}
