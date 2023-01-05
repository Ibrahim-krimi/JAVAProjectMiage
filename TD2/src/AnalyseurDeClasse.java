
/**
 * @author Michel Buffa + Modifications Philippe Lahire
 * Inspir� par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publi�e dans le livre Core Java, Sun Press
 */

import java.lang.reflect.*;
import java.io.*;
import java.util.Objects;
import java.util.jar.Attributes;

public class AnalyseurDeClasse {

    public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
        // R�cup�ration d'un objet de type Class correspondant au nom pass� en param�tres
        Class cl = getClasse(nomClasse);// CODE A ECRIRE !

        afficheEnTeteClasse(cl);

        System.out.println();
        afficheInnerClasses(cl);

        System.out.println();
        afficheAttributs(cl);

        System.out.println();
        afficheConstructeurs(cl);

        System.out.println();
        afficheMethodes(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /** Retourne la classe dont le nom est pass� en param�tre */
    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        // CODE A ECRIRE
        Class cl = Class.forName(nomClasse);
        return cl;
    }

    /** Cette m�thode affiche par ex "public class C1 extends C2 implements I1, I2 {" */
    public static void afficheEnTeteClasse(Class cl) {
        //  Affichage du modifier et du nom de la classe
        // CODE A ECRIRE
          int   mod = cl.getModifiers();
          String nomClass= cl.getName();
          System.out.println( "Modifier"+mod+" ");
          System.out.println( "Nom de la class"+nomClass+" ");




        // R�cup�ration de la superclasse si elle existe (null si cl est le type Object)
        Class supercl = cl.getSuperclass();

                // On ecrit le "extends " que si la superclasse est non nulle et diff�rente de Object
        if ((supercl!=null)&&(supercl!= Object.class))
        {
            // CODE A ECRIRE
            System.out.println("extends "+cl.getName());
            // Affichage des interfaces que la classe implemente
            Class<?>[] interfaces = cl.getInterfaces();
            // CODE A ECRIRE
            if (interfaces.length==0) {
                System.out.println(" il n y as pas des interface qui implementes la class  ");
            }
            else {
                System.out.println("les interfaces qui implementes la class sont ");

                for (int i=0;i<interfaces.length;i++) {
                System.out.println(interfaces[i].getName());
            }
        }

            // Accolade ouvrante de d�but de classe
            System.out.println("{");


        }

                System.out.print(" {\n");
    }

    /** Cette m�thode affiche les classes imbriqu�es statiques ou pas
     A faire apr�s avoir fait fonctionner le reste */
    public static void afficheInnerClasses(Class cl) throws ClassNotFoundException {
        // CODE A ECRIRE
        Class<?>[] InnerClasses =cl.getDeclaredClasses();
        for (int i=0;i<InnerClasses.length;i++){
            analyseClasse(InnerClasses[i].getName());
        }
    }

    public static void afficheAttributs(Class cl) {
        // CODE A ECRIRE
        Field[] Attributes =cl.getDeclaredFields();
        System.out.println("les attributs de la class:");

        for (int i=0; i<Attributes.length;i++){
            System.out.println(Attributes[i]);
        }

    }

    public static void afficheConstructeurs(Class cl) {
        // CODE A ECRIRE
        Constructor<?>[] constructeur = cl.getDeclaredConstructors();
        System.out.println("constructeur{");

        for (int i=0 ;i<constructeur.length;i++ ) {
        System.out.println(constructeur[i]);
        }

        System.out.println("}");


    }


    public static void afficheMethodes(Class cl) {
        // CODE A ECRIRE
        Method[]  methods = cl.getDeclaredMethods();
        System.out.println("{");
        for (int i=0 ;i<methods.length;i++ ) {
            System.out.println(methods[i]);
        }
        System.out.println("}");


    }

    public String toString(Object obj, int prof)throws ClassNotFoundException {
        analyseClasse(obj.getClass().getName());
        Object[] Classes=obj.getClass().getDeclaredClasses();

      if ((Classes.length!=0)&&(prof!=0)) {
          for (int i=0;i<Classes.length;i++)
          {
              toString(Classes[i], prof--);
          }
      }

        return "aaaaaaaa";
    }


/* Facultatif au moins dans un premier temps */
/* tester le programme en passant un nom de classe complet en param�tre
     Modifier la m�thode "main" en cons�quence
*/
public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
        }


public static void main(String[] args) {
        boolean ok = false;

        while(!ok) {
        try {
        System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
        String nomClasse = litChaineAuClavier();
        analyseClasse(nomClasse);
        ok = true;

        } catch(ClassNotFoundException e) {
        System.out.println("Classe non trouvee.");
        }catch(IOException e) {
        System.out.println("Erreur d'E/S!");
        }
        }

        }
}
