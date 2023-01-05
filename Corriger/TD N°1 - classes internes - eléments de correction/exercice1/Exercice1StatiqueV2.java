/* Philippe Lahire 
 * M1 MIAGE
 */

package miage.TDClassesInternes.exercice1;

import java.util.ArrayList;
import java.util.function.Consumer;

import miage.TDClassesInternes.ModuleEnseignementNonStatique;
import miage.TDClassesInternes.ModuleEnseignementNonStatique.TypeExercice;
import miage.TDClassesInternes.ModuleEnseignementStatique;

/* Explications : 
 * on peut placer indifféremment les classes internes dans ModuleEnseignement ou dans Exercice1NonStatique (c'est pour cela que vous les voyez apparaitre aux deux endroits mais bien évidemment dans la 
 * vraie vie il faut choisir l'endroit le plus adéquat.
 * Dans le premier cas cela nécessite d'avoir une version de ModuleEnseignement dans laquelle les classes trois classes internes (ConsummerUE...) sont déclarées "statiques"
 * Dans le second cas les trois classes internes sont déclarées "statiques" dans la classe Exercice1NonStatique et le choix de la classe ModuleEnseignement est libre
 * Attention : si la classe interne a besoin d'accéder à des informations de la classe englobante (ModuleEnseignement dans le premier cas et Exercice1NonStatique dans le second),
 * cela peut rendre obligatoire la localisation des classes internes dans l'une ou l'autre classe. Dans le cas d'une classe interne statique seuls les champs et méthodes statiques de la classe englobante
 * seront accessibles.
 * 
 * Si on place les classes internes dans la classe ModuleEnseignement on aura obligatoirement une version ModuleEnseignementNonStatique et ModuleEnseignementStatique.
 * Quelque soit la localisation, la création d'instances des classes internes ne nécessitera pas la création d'une instance de la classe englobante (c'est un élément qui devra participer au choix de la localisation)
 * Donc dans le cas "statique" si on veut éviter d'avoir deux versions de ModuleEnseignement la localisation devra être dans Exercice1Statique.
 * 
 * */

public class Exercice1StatiqueV2 {
	
	 ArrayList<ModuleEnseignementNonStatique> tab_enseignements; /* cas où on veut mettre les classes internes dans Exercice1StatiqueV2 */
	 ArrayList<ModuleEnseignementStatique> tab_enseignements2; /* cas où on veut mettre les classes internes dans ModuelEnseignement */

	public Exercice1StatiqueV2() {
	}
	

public static class ConsummerUE implements Consumer<ModuleEnseignementNonStatique> {
	 // On pourrait placer les traitements ici  (voir (*) ci dessous
	    public void accept(ModuleEnseignementNonStatique m) {
	    	 System.out.println("le nom du module est : " + m.getNomModule() + " et année de création initiale : " + m.getAnneeCreation());
	    	 m.setAnneeCreation(m.getAnneeCreation() + 1);
		      System.out.println("le nom du module est : " + m.getNomModule() + " et année de création modifiée : " + m.getAnneeCreation());
		}
	}

public static class ConsummerUE2 implements Consumer<ModuleEnseignementNonStatique> {
    
    public void accept(ModuleEnseignementNonStatique m) {

    	 System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / "+ m.getNomEnseignant() + " et année de création initiale : " + m.getAnneeCreation());
    	 if (m.getNomEnseignant().equals("Dupont"))
    		 m.setAnneeCreation(m.getAnneeCreation() + 1);
    	 else
    		 System.out.print("Pas de modification: ");
	     System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / " + m.getNomEnseignant() + " et année de création modifiée : " + m.getAnneeCreation());
	}
}

public static class ConsummerUE3 implements Consumer<ModuleEnseignementNonStatique> {
    
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

	private static void init2() { /* cas où on veut mettre les classes internes dans ModuelEnseignement */
		Exercice1StatiqueV2 e = new Exercice1StatiqueV2();
		
		e.tab_enseignements2 = new ArrayList<ModuleEnseignementStatique>();
		e.tab_enseignements2.add(0,new ModuleEnseignementStatique("module1",1999, "M1", "Pierre", ModuleEnseignementStatique.TypeExercice.QCM, true));
		e.tab_enseignements2.add(1, new ModuleEnseignementStatique("module2",2006, "M1", "Dupont", ModuleEnseignementStatique.TypeExercice.QCM, true));
		e.tab_enseignements2.add(2, new ModuleEnseignementStatique("module3",2006, "M2", "Jean", ModuleEnseignementStatique.TypeExercice.QCM, true));
		e.tab_enseignements2.add(3, new ModuleEnseignementStatique("module4",2006, "M2", "Dupont", ModuleEnseignementStatique.TypeExercice.QCM, true));
		System.out.println("Question 1.1");
		e.tab_enseignements2.forEach(new ModuleEnseignementStatique.ConsummerUE());
		System.out.println("Question 1.2");
		e.tab_enseignements2.forEach(new ModuleEnseignementStatique.ConsummerUE2());
		System.out.println("Question 1.3");
		e.tab_enseignements2.forEach(new ModuleEnseignementStatique.ConsummerUE3());
	}
	
	private static void init1 () { /* cas où on veut mettre les classes internes dans Exercice1StatiqueV2 */
		Exercice1StatiqueV2 e = new Exercice1StatiqueV2();
		
		e.tab_enseignements = new ArrayList<ModuleEnseignementNonStatique>();
		e.tab_enseignements.add(0,new ModuleEnseignementNonStatique("module1",1999, "M1", "Pierre", TypeExercice.QCM, true));
		e.tab_enseignements.add(1, new ModuleEnseignementNonStatique("module2",2006, "M1", "Dupont", TypeExercice.QCM, true));
		e.tab_enseignements.add(2, new ModuleEnseignementNonStatique("module3",2006, "M2", "Jean", TypeExercice.QCM, true));
		e.tab_enseignements.add(3, new ModuleEnseignementNonStatique("module4",2006, "M2", "Dupont", TypeExercice.QCM, true));
		System.out.println("Question 1.1");
		e.tab_enseignements.forEach(new ConsummerUE());
		System.out.println("Question 1.2");
		e.tab_enseignements.forEach(new ConsummerUE2());
		System.out.println("Question 1.3");
		e.tab_enseignements.forEach(new ConsummerUE3());
	}
	
	public static void main(String[] args) {
		init1();
		init2();
	}
}
