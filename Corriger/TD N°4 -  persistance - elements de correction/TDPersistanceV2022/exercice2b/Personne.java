package miage.TDPersistanceV2022.exercice2b;


import java.io.IOException;
import java.io.Serializable;


public class Personne implements Serializable {

	private static final long serialVersionUID = 123L;

	private String nom;
	private String prenom;
	private int age;
	// exercice 2a (1ère solution non utilisée ) transient
	private Adresse adresse; 

	public Personne() {
		System.out.println("Constructeur par défaut de personne");
		}

	public Personne (String n, String p, int a) {
		nom = n;
		prenom = p;
		age = a;
	}

	 // 2ème solution pour l'exercice 2a (utilisée pour le 2b)
	private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
		System.out.println("in writeObject de Personne");
       out.writeObject(this.nom);
       out.writeObject(this.prenom);
       out.writeInt(this.age);
       System.out.println("out writeObject de Personne");
    }

   private void readObject(java.io.ObjectInputStream in)
           throws IOException, ClassNotFoundException {
	   System.out.println("in readObject de Personne");
      this.nom = (String) in.readObject();
      this.prenom = (String) in.readObject();
      this.age = in.readInt();
      System.out.println("out readObject de Personne");
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
