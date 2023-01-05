package miage.TDPersistanceV2022.exercice3b;

import java.io.ObjectStreamField;
import java.util.Date;

public class Etudiant extends Personne //implements Serializable 
{

	private static final long serialVersionUID = 123L;
	
	//Solution exercice 3a
	private static final ObjectStreamField[] serialPersistentFields = 
	     {
//	    		 new ObjectStreamField("datePremiereInscription", Date.class),
	    		 new ObjectStreamField("numTel", String.class)//,
//	    		 new ObjectStreamField("parents", Personne[].class),
	    		 };
	
	private Date datePremiereInscription;
	private String numTel; 
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
