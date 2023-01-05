@ComplementClasse (author = "developpeur X", shouldBeSerializable = true)

public class ArbreOrnement extends Arbre {
	@ComplementChamp (author = "developpeur X", ShouldBePersistent = true)

	essenceDarbre essence; // essence de l'arbre
	@ComplementChamp (author = "developpeur X", ShouldBePersistent = true)

	boolean milieuUrbain; // peut �tre plant� en milieu urbain
	
	public ArbreOrnement() {
		// TODO Auto-generated constructor stub
	}

	public ArbreOrnement(essenceDarbre essence, boolean milieuUrbain) {
		super();
		this.essence = essence;
		this.milieuUrbain = milieuUrbain;
	}
	
	public essenceDarbre getEssence() {
		return essence;
	}

	public void setEssence(essenceDarbre essence) {
		this.essence = essence;
	}

	public boolean isMilieuUrbain() {
		return milieuUrbain;
	}

	public void setMilieuUrbain(boolean milieuUrbain) {
		this.milieuUrbain = milieuUrbain;
	}
	
}
