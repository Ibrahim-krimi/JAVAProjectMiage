package miage.TDPersistanceV2022.exercice1;


import java.io.Serializable;


public class Personne implements Serializable {
	
	private static final long serialVersionUID = 123L;
	
	private String nom;
	private String prenom1; // 1b: renommer prenom en prenom1 une fois la sauvegarde faite et recharger les données du fichier
	private int age;
	private Adresse adresse; 
	//public String prenom2; // 1b: ajouter prenom2 une fois la sauvegarde faite et recharger les données du fichier
	
	public Personne() {
		System.out.println("Constructeur par défaut de personne");
		// 1.b
		//prenom2 = "nouveau"; // on garde le même serialVersionUID et l'ajout de "prenom2" ne pose pas de problème
		// par contre le renommage de "prenom" en "prenom1" déclenche une exception (non compatibilité malgré un serialVersion UID identique.
	}
	
	public Personne (String n, String p, int a) {
		nom = n;
		prenom1 = p;
		age = a;
	}
           
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom1;
	}
	public void setPrenom(String prenom) {
		this.prenom1 = prenom;
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
