/* Philippe Lahire 
 * M1 MIAGE
 */

package miage.TDClassesInternes.exercice1;

import java.util.ArrayList;
import java.util.function.Consumer;

import miage.TDClassesInternes.ModuleEnseignementNonStatique;

/* Explications : 
 * on peut placer indifféremment les classes internes dans ModuleEnseignement ou dans Exercice1NonStatique (c'est pour cela que vous les voyez apparaitre aux deux endroits mais bien évidemment dans la 
 * vraie vie il faut choisir l'endroit le plus adéquat.
 * Dans le premier cas cela nécessite d'avoir une version de ModuleEnseignement dans laquelle les classes trois classes internes (ConsummerUE...) sont déclarées "non statiques"
 * Dans le second cas les trois classes internes sont déclarées "non statiques" dans la classe Exercice1NonStatique et le choix de la classe ModuleEnseignement est libre
 * Attention : si la classe interne a besoin d'accéder à des informations de la classe englobante (ModuleEnseignement dans le premier cas et Exercice1NonStatique dans le second),
 * cela peut rendre obligatoire la localisation des classes internes dans l'une ou l'autre classe.
 * 
 * Si on place les classes internes dans la classe ModuleEnseignement on aura obligatoirement une version ModuleEnseignementNonStatique et ModuleEnseignementStatique
 * Quelque soit la localisation, la création d'instances des classes internes nécessitera la création d'une instance de la classe englobante (c'est un élément qui devra participer au choix de la localisation)
 * Donc dans le cas "non statique" la localisation la meilleure semble être dans Exercice1NonStatique
 * 
 * */

public class Exercice1NonStatique {
	
	 ArrayList<ModuleEnseignementNonStatique> tab_enseignements;

	 public class ConsummerUE implements Consumer<ModuleEnseignementNonStatique> {
		    
		    public void accept(ModuleEnseignementNonStatique m) {
		    	 System.out.println("le nom du module est : " + m.getNomModule() + " et année de création initiale : " + m.getAnneeCreation());
		    	 m.setAnneeCreation(m.getAnneeCreation() + 1);
			      System.out.println("le nom du module est : " + m.getNomModule() + " et année de création modifiée : " + m.getAnneeCreation());
			}
		}

	 public class ConsummerUE2 implements Consumer<ModuleEnseignementNonStatique> {
	    
	    public void accept(ModuleEnseignementNonStatique m) {

	    	 System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / "+ m.getNomEnseignant() + " et année de création initiale : " + m.getAnneeCreation());
	    	 if (m.getNomEnseignant().equals("Dupont"))
	    		 m.setAnneeCreation(m.getAnneeCreation() + 1);
	    	 else
	    		 System.out.print("Pas de modification: ");
		     System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / " + m.getNomEnseignant() + " et année de création modifiée : " + m.getAnneeCreation());
		}
	}
	
	public class ConsummerUE3 implements Consumer<ModuleEnseignementNonStatique> {
	    
	    public void accept(ModuleEnseignementNonStatique m) {
	    	 if (m.getGenre() == ModuleEnseignementNonStatique.TypeExercice.QCM) {
	    		 m.setRattrapagePrevu(false);
	    		 System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / "+ m.getNomEnseignant() + " et rattapage modifié : " + m.isRattrapagePrevu());
	    	 }
	    	 else
	    		 System.out.println("Pas de modification du rattrapage");
	    	 System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / "+ m.getNomEnseignant() + " et année de création initiale : " + m.getAnneeCreation());
	    	 if (m.getNomEnseignant().equals("Dupont") && m.getGenre() == ModuleEnseignementNonStatique.TypeExercice.QCM)
	    		 m.setAnneeCreation(m.getAnneeCreation() + 1);
	    	 else
	    		 System.out.println("Pas de modification de l'année de création");
		     //System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / " + m.getNomEnseignant() + " et année de création : " + m.getAnneeCreation());
		}
	}
	
	public Exercice1NonStatique(ArrayList<ModuleEnseignementNonStatique> t) {
		tab_enseignements = t;
		//new ConsummerUE(); // OK mais utile que si le constructeur déclenche un traitement
		//ConsummerUE testCreation = new ConsummerUE(); // OK accès à l'instance créée à travers testCreation
	}

	// Remarque: si on implémentait les "consummer" dans "ModuleEnseignementNonStatique" on serait obligé de créer une instance par instance de "ModuleEnseignementNonStatique" ce qui est un non sens
	public static void main(String[] args) {
		Exercice1NonStatique e = new Exercice1NonStatique(new ArrayList<ModuleEnseignementNonStatique>());

		e.tab_enseignements.add(0,new ModuleEnseignementNonStatique("module1",1999, "M1", "Pierre", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
		e.tab_enseignements.add(1, new ModuleEnseignementNonStatique("module2",2006, "M1", "Dupont", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
		e.tab_enseignements.add(2, new ModuleEnseignementNonStatique("module3",2006, "M2", "Jean", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
		e.tab_enseignements.add(3, new ModuleEnseignementNonStatique("module4",2006, "M2", "Dupont", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
		System.out.println("Question 1.1");
		//e.tab_enseignements.forEach(e.tab_enseignements.get(0).new ConsummerUE());
		e.tab_enseignements.forEach(e.new ConsummerUE());
		System.out.println("Question 1.2");
		//e.tab_enseignements.forEach(e.tab_enseignements.get(0).new ConsummerUE2());
		e.tab_enseignements.forEach(e.new ConsummerUE2());
		System.out.println("Question 1.3");
		//e.tab_enseignements.forEach(e.tab_enseignements.get(0).new ConsummerUE3());
		e.tab_enseignements.forEach(e.new ConsummerUE3());
	}
}
