package miage.TDPersistanceV2022.exercice2a;


import java.io.Serializable;


public class Personne implements Serializable {
	
	private static final long serialVersionUID = 123L;

	// exercice 2a	: 3eme solution enlever "new ObjectStreamField("adresse", Adresse.class)"
//	private static final ObjectStreamField[] serialPersistentFields = 
//	     {new ObjectStreamField("nom", String.class),
//	      new ObjectStreamField("prenom", String.class),
//	      new ObjectStreamField("adresse", Adresse.class),
//	      new ObjectStreamField("age", int.class)};
	
	private String nom;
	private String prenom;
	private int age;
	transient private Adresse adresse; // exercice 2a (1ère solution)
	
	public Personne() {
		System.out.println("Constructeur par défaut de personne");
		}
	
	public Personne (String n, String p, int a) {
		nom = n;
		prenom = p;
		age = a;
	}
	
	// 2ème solution pour l'exercice 2a
//	private void writeObject(java.io.ObjectOutputStream out)    
//            throws IOException {
//       out.writeObject(this.nom);
//       out.writeObject(this.prenom);
//       out.writeInt(this.age);
//    }
//
//   private void readObject(java.io.ObjectInputStream in)
//           throws IOException, ClassNotFoundException {
//      this.nom = (String) in.readObject();
//      this.prenom = (String) in.readObject();
//      this.age = in.readInt();
//    }

           
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
