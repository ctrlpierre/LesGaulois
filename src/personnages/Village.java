package personnages;

public class Village {
	private String nom;
	
	public Village(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Village [nom=" + nom + "]";
	}
}