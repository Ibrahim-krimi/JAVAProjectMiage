package miage.TDPersistanceV2022.exercice4a;

import java.io.Externalizable;
import java.io.IOException;
import java.util.Date;

public class Etudiant2 extends Personne2 implements Externalizable {

	private static final long serialVersionUID = 123L;
	
	private Date datePremiereInscription;
	private String numTel;
	Personne2[] parents;

	public Etudiant2() {
		System.out.println("Constructeur par défaut d_étudiant2");
	}

	public Etudiant2(String n, String p, int a, Date d, String t) {
		super(n, p, a);
		datePremiereInscription = d;
		numTel = t;
		parents = new Personne2[] {};
	}

	//solution exercice 4a
	public void writeExternal(java.io.ObjectOutput out) throws IOException {
		System.out.println("Write external (etudiant2): ");
		super.writeExternal(out);
		out.writeObject(numTel);
		out.writeObject(datePremiereInscription);
		out.writeObject(parents);
	}

	//solution exercice 4a
	public void readExternal(java.io.ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("read external (etudiant2): ");
		super.readExternal(in);
		setNumTel((String) in.readObject());
		setDatePremiereInscription((Date) in.readObject());
		setParents((Personne2[]) in.readObject());
	}

	public Personne2[] getParents() {
		return parents;
	}

	public void setParents(Personne2[] parents) {
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
