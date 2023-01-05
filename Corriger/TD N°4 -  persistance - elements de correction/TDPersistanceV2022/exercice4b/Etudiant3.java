package miage.TDPersistanceV2022.exercice4b;

import java.io.Externalizable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class Etudiant3 extends Personne3 implements Externalizable {
//public class Etudiant3 extends Personne3 implements Serializable { // 4b en utilisant Serializable et read/writeObject

	private static final long serialVersionUID = 123L;
	
	private Date datePremiereInscription;
	private String numTel;
	Personne3[] parents;

	public Etudiant3() {
		System.out.println("Constructeur par défaut d_étudiant 3");
	}

	public Etudiant3(String n, String p, int a, Date d, String t) {
		super(n, p, a);
		datePremiereInscription = d;
		numTel = t;
		parents = new Personne3[] {};
	}

	//solution exercice 4b
	public void writeExternal(java.io.ObjectOutput out) throws IOException {

		System.out.println("Write external (etudiant3): ");
		// on ne fait pas appel au writeExternal de Personne3 car il n'existe pas
		// writeExternalPersonne(out); 

		// Par contre on sérialise bien les données décrites dans la classe Personne3
		out.writeObject(getNom());
		out.writeObject(getPrenom());
		out.writeInt(getAge());
		out.writeObject(getAdresse());
		// On sérialise bien sur les données spécifiques à Etudiant3
		out.writeObject(numTel);
		out.writeObject(datePremiereInscription);
		out.writeObject(parents);
	}

	//solution exercice 4b
	public void readExternal(java.io.ObjectInput in) throws IOException, ClassNotFoundException {

		System.out.println("Read external (etudiant3): ");
		// on ne fait pas appel au readExternal de Personne3 car il n'existe pas
		// readExternalPersonne(in);

		// Par contre on désérialise bien les données décrites dans la classe Personne3
		setNom((String) in.readObject());
		setPrenom((String) in.readObject());
		setAge(in.readInt());
		setAdresse((Adresse2) in.readObject());
		// On désérialise bien sur les données spécifiques à Etudiant3
		setNumTel((String) in.readObject());
		setDatePremiereInscription((Date) in.readObject());
		setParents((Personne3[]) in.readObject());
	}

	// 4b en utilisant Serializable et writeObject
//	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
//      System.out.println("writeObject (etudiant3): ");
//		out.writeObject(getNom());
//		out.writeObject(getPrenom());
//		out.writeInt(getAge());
//		out.writeObject(getAdresse());
//		out.writeObject(numTel);
//		out.writeObject(datePremiereInscription);
//		out.writeObject(parents);
//	}

	// 4b en utilisant Serializable et readObject
//	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
//	    System.out.println("readObject (etudiant3): ");
//		setNom((String) in.readObject());
//		setPrenom((String) in.readObject());
//		setAge(in.readInt());
//		setAdresse((Adresse2) in.readObject());
//		setNumTel((String) in.readObject());
//		setDatePremiereInscription((Date) in.readObject());
//		setParents((Personne3[]) in.readObject());
//	}
	
	public Personne3[] getParents() {
		return parents;
	}

	public void setParents(Personne3[] parents) {
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
