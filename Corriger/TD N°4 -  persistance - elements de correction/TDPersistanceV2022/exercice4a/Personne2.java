package miage.TDPersistanceV2022.exercice4a;


import java.io.Externalizable;
import java.io.IOException;
import java.io.Serializable;


public class Personne2 implements Externalizable, Serializable {
	
	private static final long serialVersionUID = 123L;
	
	transient private String nom;
	private String prenom;
	transient private int age;
	private Adresse2 adresse;
	//public String prenom2;
	
	public Personne2() {
		System.out.println("Constructeur par défaut de personne2");
		//prenom2 = "nouveau";
	}
	
	public Personne2 (String n, String p, int a) {
		nom = n;
		prenom = p;
		age = a;
	}
	
	//solution exercice 4a
	public void writeExternal(java.io.ObjectOutput out)    
            throws IOException {
	   System.out.println("Write external (personne2): ");
       out.writeObject(this.nom);
       out.writeObject(this.prenom);
       out.writeInt(this.age);
       out.writeObject(this.adresse);
    }

	//solution exercice 4a
	public void readExternal(java.io.ObjectInput in)
           throws IOException, ClassNotFoundException {
	  System.out.println("Read external (personne2): ");
      this.nom = (String) in.readObject();
      this.prenom = (String) in.readObject();
      this.age = in.readInt();
      this.adresse = (Adresse2) in.readObject();
    }

	// pour montrer que writeExternal "domine" writeObject
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		System.out.println("Write serializable (personne2) : ");
		out.writeObject(this.nom);
		out.writeObject(this.prenom);
		out.writeInt(this.age);
	}

	// pour montrer que readExternal "domine" readObject
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("Read serializable (personne2): ");
		this.nom = (String) in.readObject();
		this.prenom = (String) in.readObject();
		this.age = in.readInt();
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
	public Adresse2 getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse2 adresse) {
		this.adresse = adresse;
	}

}
