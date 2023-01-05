package miage.TDPersistanceV2022.exercice4a;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

// Version simplifiée sans tableaux
// pour implémentation exercice 4
public class Promotion2022Version2 {

	ObjectInputStream loader;
	ObjectOutputStream saver;
	
	Adresse2 rootAdresse;
	Etudiant2 rootEtudiant, rootEtudiant2;
	Personne2 rootPersonne, rootPersonne2;
	
	public Promotion2022Version2() {
		//init0();
	}
	
	public void init0(){
		rootPersonne = new Personne2("Andre", "Pierre", 30);
		rootEtudiant = new Etudiant2("Andre", "Pierre", 30, new Date(), "9294562389");
		rootAdresse = new Adresse2 ("Nice", "avenue Valrose", 28, true);
		rootPersonne.setAdresse(rootAdresse);
		rootEtudiant.setAdresse(rootAdresse);
		//rootPersonne.setAdresse (new Adresse2("Nice", "Valrose", 28, false));
		rootEtudiant2 = rootEtudiant;
	}
	
	public void testSerialization (Personne2 r) {
		System.out.println("testSerialization d'une personne (début)");
		System.out.println(r.getNom());
		System.out.println(r.getPrenom());
		System.out.println(r.getAge());
		//System.out.println(r.getNumTel());
		//System.out.println(r.getDatePremiereInscription().toString());
		System.out.println(r.getAdresse().isAdressePersonnelle());
		System.out.println(r.getAdresse().getNumero());
		System.out.println(r.getAdresse().getVille());
		System.out.println(r.getAdresse().getRue());
		//System.out.println(rootEtudiant.getParents().toString());
		System.out.println("testSerialization d'une personne (fin)");
	}
	public void testSerialization (Etudiant2 r) {
		System.out.println("testSerialization d'un étudiant (début)");
		System.out.println(r.getNom());
		System.out.println(r.getPrenom());
		System.out.println(r.getAge());
		System.out.println(r.getNumTel());
		System.out.println(r.getDatePremiereInscription().toString());
		System.out.println(r.getParents().toString());
		System.out.println(r.getAdresse().isAdressePersonnelle());
		System.out.println(r.getAdresse().getNumero());
		System.out.println(r.getAdresse().getVille());
		System.out.println(r.getAdresse().getRue());
		System.out.println("testSerialization d'un étudiant (fin)");
	}
	
	
	public void saveEtudiants(String nomfichier) {
		
		try {
		     FileOutputStream support = new FileOutputStream(nomfichier);
			System.out.println("save étudiant (début)");
		     saver = new ObjectOutputStream(support);
		     saver.writeObject(rootPersonne);
		     saver.writeObject(rootEtudiant);
		     saver.writeObject(rootEtudiant2);
		     support.flush();
		     support.close();
			 System.out.println("save étudiant (fin)");
		} catch(java.io.IOException e) {e.printStackTrace();};
	}

	void retrieveEtudiants(String nomfichier) {

		System.out.println("retrieve étudiant (début)");
		
		   try {
		           FileInputStream support = new FileInputStream(nomfichier);
		           loader = new ObjectInputStream(support);
		           rootPersonne = (Personne2) loader.readObject();
		           rootEtudiant = (Etudiant2) loader.readObject();
		           rootEtudiant2 = (Etudiant2) loader.readObject();
				   support.close();
			} catch(java.io.IOException | ClassNotFoundException e) {e.printStackTrace();};

		System.out.println("retrieve étudiant (fin)");
	}
	
	public static void main(String[] args) {
		Promotion2022Version2 p = new Promotion2022Version2();
//		p.init0();
//		p.saveEtudiants("f_etudiant2");
//
//		 System.out.println("Contenu de rootPersonne");
//		p.testSerialization(p.rootPersonne);
//		 System.out.println("Contenu de rootEtudiant");
//		p.testSerialization(p.rootEtudiant);
//		 System.out.println("Contenu de rootEtudiant2");
//		p.testSerialization(p.rootEtudiant2);
		 p.retrieveEtudiants("f_etudiant2");
		 System.out.println("Contenu de rootPersonne");
		 p.testSerialization (p.rootPersonne);
		 System.out.println("Contenu de rootEtudiant");
		 p.testSerialization (p.rootEtudiant);
		 System.out.println("Contenu de rootEtudiant2");
		 p.testSerialization (p.rootEtudiant2);
	}

}
