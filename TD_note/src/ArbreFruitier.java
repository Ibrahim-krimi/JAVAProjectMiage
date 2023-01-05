@ComplementClasse (author = "developpeur X", shouldBeSerializable = true)

public class ArbreFruitier extends Arbre {
	@ComplementChamp (author = "developpeur X", ShouldBePersistent = true)

	String nomFruit; // Nom du fruit produit par l'arbre
	@ComplementChamp (author = "developpeur X", ShouldBePersistent = true)

	MoisAnnee recolte; // Mois pendant laaquelle se fait la r�colte
	
	public ArbreFruitier(String nomFruit, MoisAnnee recolte) {
		super();
		this.nomFruit = nomFruit;
		this.recolte = recolte;
	}

	public ArbreFruitier() {
		// TODO Auto-generated constructor stub
	}

	public String getNomFruit() {
		return nomFruit;
	}

	public void setNomFruit(String nomFruit) {
		this.nomFruit = nomFruit;
	}

	public MoisAnnee getRecolte() {
		return recolte;
	}

	public void setRecolte(MoisAnnee recolte) {
		this.recolte = recolte;
	}

}
