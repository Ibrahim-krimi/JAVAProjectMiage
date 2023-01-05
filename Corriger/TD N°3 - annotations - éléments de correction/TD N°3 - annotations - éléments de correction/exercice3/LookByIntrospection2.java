/* Philippe Lahire 
 * M1 MIAGE
 */

package miage.TDAnnotations.exercice3;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

import miage.TDAnnotations.exercice2.TypeCompletude;
import miage.TDAnnotations.exercice2.miageAdvanced;
import miage.TDAnnotations.exercice2.miageBasics;				

public class LookByIntrospection2 {

	
	public static ArrayList<String> afficheAnnotationschamps(String nomClasse) throws ClassNotFoundException {
		// Traitement question 3: "La liste des champs cr��s pendant la 1�re et 2�me s�ance de TD"
	    Class<?> cl = getClasse(nomClasse);
	    Field[] fields = cl.getDeclaredFields();
	    ArrayList<String> tab = new ArrayList<String>(fields.length);
	    int i = 0;
		  for(Field f : fields) {
			  miageBasics a[] = f.getAnnotationsByType(miageBasics.class);
			  //System.out.println ("Field annotations: " + a[0].toString());
			  if (a.length != 0) {
				  if (a[0].seanceTD() == 1 || a[0].seanceTD() == 2) {
					  tab.add(i, f.getName() + ": " + f.getType().getTypeName());
					  //System.out.println("Field annotations: " + tab.get(i));
					  i++;
				  }
			  }
		  }
		  return tab;
	}
	
	public static ArrayList<String> afficheAnnotationsmethodesCompletude(String nomClasse, int an, TypeCompletude t) throws ClassNotFoundException {
		// Traitement question 3 (calcul de ratio): "La liste des m�thodes cr��es pendant l'ann�e universitaire 'an' et ayant le degr� de compl�tude 't'
	    Class<?> cl = getClasse(nomClasse);
	    Method[] methods = cl.getDeclaredMethods();
	    ArrayList<String> tab = new ArrayList<String>(methods.length);
	    int i = 0;
		  for(Method m : methods) {  
			  miageBasics a[] = m.getAnnotationsByType(miageBasics.class);
			  miageAdvanced b[] = m.getAnnotationsByType(miageAdvanced.class);
			  if (a.length != 0 & b.length != 0) {
				  if (a[0].anneeUniversitaire() == an & b[0].completude() == t) {
					  String s = m.getName() + "(";
					  for (Parameter p : m.getParameters()) {
						  s = s + p.getName() + ": " + p.getParameterizedType().getTypeName() + ",";
					  }
					  s = s.substring(0, s.lastIndexOf(','));
					  tab.add(i, s + ") : " + m.getReturnType().getTypeName());
					  i++;
				  }
			  }
		  }
		  return tab;
	}
		 
	public static ArrayList<String> afficheAnnotationsmethodes(String nomClasse) throws ClassNotFoundException {
		// Traitement question 3 (calcul de ratio): "La liste des m�thodes cr��es pendant l'ann�e universitaire 2020 et ayant le degr� de compl�tude 'Finalized'
	    return afficheAnnotationsmethodesCompletude (nomClasse, 2020, TypeCompletude.Finalized);
	}
	
	public static ArrayList<String> afficheAnnotationsmethodesGenerees(String nomClasse, int an, boolean g) throws ClassNotFoundException {
		// Traitement question 3 (calcul de ratio): "La liste des m�thodes cr��es pendant l'ann�e universitaire 'an' marqu�es par : g�n�r�e = 'g'
	    Class<?> cl = getClasse(nomClasse);
	    Method[] methods = cl.getDeclaredMethods();
	    ArrayList<String> tab = new ArrayList<String>(methods.length);
	    int i = 0;
		  for(Method m : methods) {			  
			  miageBasics a[] = m.getAnnotationsByType(miageBasics.class);
			  miageAdvanced b[] = m.getAnnotationsByType(miageAdvanced.class);
			  if (a.length != 0 & b.length != 0) {
				  if (a[0].anneeUniversitaire() == an & b[0].generated() == g) {
					  String s = m.getName() + "(";
					  for (Parameter p : m.getParameters()) {
						  s = s + p.getName() + ": " + p.getParameterizedType().getTypeName() + ",";
					  }
					  s = s.substring(0, s.lastIndexOf(','));
					  tab.add(i, s + ") : " + m.getReturnType().getTypeName());
					  i++;
				  }
			  }
		  }
		  return tab;
	}
	
	public static ArrayList<String> afficheAnnotationsmethodesTestees(String nomClasse, int an, boolean g) throws ClassNotFoundException {
		// Traitement question 3 (calcul de ratio): "La liste des m�thodes cr��es pendant l'ann�e universitaire 'an' marqu�es par : test�e = 'g'
	    Class<?> cl = getClasse(nomClasse);
	    Method[] methods = cl.getDeclaredMethods();
	    ArrayList<String> tab = new ArrayList<String>(methods.length);
	    int i = 0;
		  for(Method m : methods) {
			  miageBasics a[] = m.getAnnotationsByType(miageBasics.class);
			  miageAdvanced b[] = m.getAnnotationsByType(miageAdvanced.class);
			  if (a.length != 0 & b.length != 0) {
				  if (a[0].anneeUniversitaire() == an & b[0].tested() == g) {
					  String s = m.getName() + "(";
					  for (Parameter p : m.getParameters()) {
						  s = s + p.getName() + ": " + p.getParameterizedType().getTypeName() + ",";
					  }
					  s = s.substring(0, s.lastIndexOf(','));
					  tab.add(i, s + ") : " + m.getReturnType().getTypeName());
					  i++;
				  }
			  }
		  }
		  return tab;
	}
	
	public static void afficherRatios (String nomClasse) throws ClassNotFoundException {
		// Traitement question 3 (calcul de ratio)
		int nb = afficheAnnotationsmethodesCompletude (nomClasse, 2020, TypeCompletude.Partial).size() + afficheAnnotationsmethodesCompletude (nomClasse, 2020, TypeCompletude.Full).size() + afficheAnnotationsmethodesCompletude (nomClasse, 2020, TypeCompletude.Finalized).size();
		if (nb != 0) {
		System.out.println("Partielles/R�alis�es = " + (float) afficheAnnotationsmethodesCompletude (nomClasse, 2020, TypeCompletude.Partial).size()/nb);
		System.out.println("G�n�r�es/R�alis�es = " + (float) afficheAnnotationsmethodesGenerees (nomClasse, 2020, true).size()/nb);
		}
		System.out.println("Finalis�es/Non g�n�r�es = " + (float) afficheAnnotationsmethodesCompletude (nomClasse, 2020, TypeCompletude.Finalized).size() / afficheAnnotationsmethodesGenerees (nomClasse, 2020, false).size());
		System.out.println("Test�es/Non g�n�r�es = " + (float) afficheAnnotationsmethodesTestees (nomClasse, 2020, true).size() / afficheAnnotationsmethodesGenerees (nomClasse, 2020, false).size());
	}
	
	public static ArrayList<String> afficheAnnotationsClasse(String nomClasse, int an) throws ClassNotFoundException {
		// Traitement question 3 : "La liste des annotations de niveau "classe" cr��es pendant l'ann�e universitaire 'an'
	    ArrayList<String> tab = new ArrayList<String>(1);
	    Class<?> cl = getClasse(nomClasse);
		miageBasics a[] = cl.getAnnotationsByType(miageBasics.class);
		miageAdvanced b[] = cl.getAnnotationsByType(miageAdvanced.class);
		if (a.length != 0 & b.length == 0) {
			if (a[0].anneeUniversitaire() == an) {
				tab.add(0,"[" + a[0].nomAuteur() + ", " + a[0].prenomAuteur() + ", " + a[0].anneeUniversitaire() + ", " + a[0].seanceTD() + "]");
			}
		}
	if (tab.size() == 0) 
		System.out.println("Pas d'annotation de classe");
	return tab;

	}

	public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
		// Traitement de la question 3
		ArrayList<String> tab;
		System.out.println("Affichage des annotations de classe concern�es (Exercice 3) ");
		tab = afficheAnnotationsClasse(nomClasse, 2020);
		System.out.println(tab.get(0));
		
		System.out.println("Affichage des champs concern�s (Exercice 3) ");
		tab = afficheAnnotationschamps (nomClasse);
		tab.forEach(new Consumer<String>() {
			public void accept(String s) {
				System.out.println (s);
			}
		});

		System.out.println("Affichage des m�thodes concern�es (Exercice 3) ");
		tab= afficheAnnotationsmethodes (nomClasse);
		System.out.println(tab.get(0));
		tab.forEach(new Consumer<String>() {
			public void accept(String s) {
				System.out.println (s);
			}
		});
		
		System.out.println("Affichage des ratios demand�s (Exercice 3) ");
	    afficherRatios(nomClasse);
		  }
		  
	 
	 public static Class<?> getClasse(String nomClasse) throws ClassNotFoundException {
		  return Class.forName(nomClasse);
	  }
	 
	 public static String litChaineAuClavier() throws IOException {
		  Scanner sc = new Scanner(System.in);
		  String line = sc.nextLine();
		  sc.close();
	      return line;
	 }

	  public static void main(String[] args) {
	   // boolean ok = false;
	   // while(!ok) {
	      try {
	        //System.out.print("Entrez le nom d'une classe (ex : miage.annotations.tests.ActionAnnotated): ");
	        //String nomClasse = litChaineAuClavier();
	        //analyseClasse(nomClasse);
	        analyseClasse("miage.TDAnnotations.AnnotedClass");
	      }
	      catch(ClassNotFoundException e) {e.printStackTrace();}
	   // }
	  }
}
