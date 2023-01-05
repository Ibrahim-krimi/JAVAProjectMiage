package Ex1.td4;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class Etudiant extends Personne implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 123L;
	private Date datePremiereInscription;
	transient private String numTel;
	Personne[] parents;

	public Etudiant() {
		System.out.println("Constructeur par défaut d_étudiant");
	}

	public Etudiant(String n, String p, int a, Date d, String t) {
		super(n, p, a);
		datePremiereInscription = d;
		numTel = t;
	}

	private void writeObject(java.io.ObjectOutputStream out)
			throws IOException {
		System.out.println("in writeObject de Etudiant");
		out. defaultWriteObject();
//       out.writeObject(getNom());
//       out.writeObject(getPrenom());
//       out.writeInt(getAge());
		out.writeObject(getAdresse());
		System.out.println("out writeObject de Etudiant");
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
