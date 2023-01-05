@ComplementClasse (author = "developpeur X", shouldBeSerializable = true)

public class Arbre {
	@ComplementChamp (author = "developpeur X", ShouldBePersistent = true)
	String nom; // Nom de l'arbre
	@ComplementChamp (author = "developpeur X", ShouldBePersistent = true)

	int hauteur; // Hauteur de l'arbre en m�tres
	@ComplementChamp (author = "developpeur X", ShouldBePersistent = true)

	int anneePlantation; // Ann�e durant laquelle l'arbre a �t� plant�
	@ComplementChamp (author = "developpeur X", ShouldBePersistent = true)

	LieuPlantation lieu;
	
	
	public Arbre() {
		// TODO Auto-generated constructor stub
	}

	public Arbre(String nom, int hauteur, int anneePlantation) {
		super();
		this.nom = nom;
		this.hauteur = hauteur;
		this.anneePlantation = anneePlantation;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}


	public int getAnneePlantation() {
		return anneePlantation;
	}


	public void setAnneePlantation(int anneePlantation) {
		this.anneePlantation = anneePlantation;
	}


	public LieuPlantation getLieu() {
		return lieu;
	}


	public void setLieu(LieuPlantation lieu) {
		this.lieu = lieu;
	}

}
