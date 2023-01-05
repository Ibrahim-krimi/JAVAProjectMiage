package miage.TDPersistanceV2022.exercice1;

import java.util.Date;

public class Etudiant extends Personne //implements Serializable //,java.io. ObjectInputValidation 
{

	private static final long serialVersionUID = 123L;
	
	private Date datePremiereInscription;
	transient private String numTel; // pour la solution de l'exercice 1.a
	Personne[] parents;

	public Etudiant() {
		System.out.println("Constructeur par défaut d_étudiant");
	}

	public Etudiant(String n, String p, int a, Date d, String t) {
		super(n, p, a);
		datePremiereInscription = d;
		numTel = t;
	}

	public Personne[] getParents() {
		return parents;
	}

	public void setParents(Personne[] parents) {
		this.parents = parents;
	}

	public Date getDatePremiereInscription() {
		return datePremiereInscription;
	}

	public void setDatePremiereInscription(Date datePremiereInscription) {
		this.datePremiereInscription = datePremiereInscription;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

}
