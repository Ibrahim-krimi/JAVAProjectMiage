package miage.TDPersistanceV2022.exercice4b;

import java.io.IOException;

// Solution exercice 4b
public class Personne3  { // Personne n'hérite pas de Serializable ou Externalizable
	
	private String nom;
	private String prenom;
	private int age;
	private Adresse2 adresse;
	
	public Personne3() {
		System.out.println("Constructeur par défaut de personne 3");
	}
	
	public Personne3 (String n, String p, int a) {
		nom = n;
		prenom = p;
		age = a;
	}
 
	// exercice 4.b: Absente ou vide si appel de "super" dans la classe descendante
//	public void writeExternal(java.io.ObjectOutput out) throws IOException {
//		
//	}
	
	// exercice 4.b: Absente ou vide si appel de "super" dans la classe descendante
//	public void readExternal(java.io.ObjectInput in) throws IOException, ClassNotFoundException {
//		
//	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Adresse2 getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse2 adresse) {
		this.adresse = adresse;
	}

}
