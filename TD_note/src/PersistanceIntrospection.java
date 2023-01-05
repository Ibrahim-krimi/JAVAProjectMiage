import java.lang.reflect.Field;
import java.util.ArrayList;

public class PersistanceIntrospection {
    public static ArrayList<String>  remonterIncoherence(String nomClasse)throws ClassNotFoundException
    {
        Class<?> cl = getClasse(nomClasse);
        Field[] fields = cl.getDeclaredFields();
        Class<?>[] classes =cl.getClasses();
        ArrayList<String> tab = new ArrayList<String>(fields.length);
        int i = 0;
        for(Field f : fields) {
            ComplementChamp a[] = f.getAnnotationsByType(ComplementChamp.class);
            //System.out.println ("Field annotations: " + a[0].toString());
            if (a.length != 0) {
                if (a[0].ShouldBePersistent() == false) {
                    tab.add(i, f.getName() + ": " + f.getType().getTypeName());
                    //System.out.println("Field annotations: " + tab.get(i));
                    i++;
                }
            }
        }

        /* triatmemnt de class incomplet
        for(Class f : classes) {
            ComplementClasse a[] = f.getAnnotationsByType(ComplementClasse);
            //System.out.println ("Field annotations: " + a[0].toString());
            if (a.length != 0) {
                if (a[0].shouldBeSerializable() == false) {
                    tab.add(i, f.getName() + ": " + f.().getTypeName());
                    //System.out.println("Field annotations: " + tab.get(i));
                    i++;
                }
            }
        }

         */
        return tab;

    }
    public static Class<?> getClasse(String nomClasse) throws ClassNotFoundException {
        return Class.forName(nomClasse);
    }


    public static void main(String[] args) {
        // boolean ok = false;
        // while(!ok) {
        try {
            //System.out.print("Entrez le nom d'une classe (ex : miage.annotations.tests.ActionAnnotated): ");
            //String nomClasse = litChaineAuClavier();
            //analyseClasse(nomClasse);
            ArrayList<String>  tab=remonterIncoherence ("Arbre");
            for (String s : tab) {
                System.out.println(s);

            }
        }
        catch(ClassNotFoundException e) {e.printStackTrace();}
        // }
    }
}
