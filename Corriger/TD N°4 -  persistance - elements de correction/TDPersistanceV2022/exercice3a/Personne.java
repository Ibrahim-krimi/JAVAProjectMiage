package miage.TDPersistanceV2022.exercice3a;


import java.io.ObjectStreamField;
import java.io.Serializable;


public class Personne implements Serializable {
	
	private static final long serialVersionUID = 123L;
	
	// Solution exercice 3a
	private static final ObjectStreamField[] serialPersistentFields = 
	     {new ObjectStreamField("nom", String.class),
//	      new ObjectStreamField("prenom", String.class),
//	      new ObjectStreamField("adresse", Adresse.class),
	      new ObjectStreamField("age", int.class)};

	
	private String nom;
	private String prenom;
	private int age;
	private Adresse adresse; 
	
	public Personne() {
		System.out.println("Constructeur par défaut de personne");
	}
	
	public Personne (String n, String p, int a) {
		nom = n;
		prenom = p;
		age = a;
	}
           
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
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
