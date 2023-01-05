
import miage.TDClassesInternes.ModuleEnseignementNonStatique;

import java.util.ArrayList;
import java.util.function.Consumer;


public class Exercice1Anonyme {

    private ArrayList<ModuleEnseignementNonStatique> tab_enseignements;
public void initConsummers() {
    System.out.println("Question 1.1");
    tab_enseignements.forEach(new Consumer<ModuleEnseignementNonStatique>() {
        @Override
        public void accept(ModuleEnseignementNonStatique m) {
            System.out.println("le nom du module est :" + m.getNomModule() + "et anneé de creation initiale :" + m.getAnneeCreation());
            m.setAnneeCreation(m.getAnneeCreation() + 1);
            System.out.println("le nom du module est :" + m.getNomModule() + "et anneé de creation modifier :" + m.getAnneeCreation());

        }
    });
    System.out.println("Question 1.2");
    tab_enseignements.forEach(new Consumer<ModuleEnseignementNonStatique>() {
        @Override
        public void accept(ModuleEnseignementNonStatique m) {
            System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / " + m.getNomEnseignant() + " et année de création initiale : " + m.getAnneeCreation());
            if (m.getNomEnseignant().equals("Dupont"))
                m.setAnneeCreation(m.getAnneeCreation() + 1);
            else
                System.out.print("Pas de modification: ");
            System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / " + m.getNomEnseignant() + " et année de création modifiée : " + m.getAnneeCreation());
        }
    });

    System.out.println("Question 1.3");

    tab_enseignements.forEach(new Consumer<ModuleEnseignementNonStatique>() {
        @Override
        public void accept(ModuleEnseignementNonStatique m) {
            if (m.getGenre() == ModuleEnseignementNonStatique.TypeExercice.QCM) {
                m.setRattrapagePrevu(false);
                System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / " + m.getNomEnseignant() + " et rattapage modifié : " + m.isRattrapagePrevu());
            } else
                System.out.println("Pas de modification du rattrapage");
            System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / " + m.getNomEnseignant() + " et année de création initiale : " + m.getAnneeCreation());
            if (m.getNomEnseignant().equals("Dupont") && m.getGenre() == ModuleEnseignementNonStatique.TypeExercice.QCM)
                m.setAnneeCreation(m.getAnneeCreation() + 1);
            else
                System.out.println("Pas de modification de l'année de création");
            //System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / " + m.getNomEnseignant() + " et année de création : " + m.getAnneeCreation());
        }
    });

}

  public Exercice1Anonyme(ArrayList<ModuleEnseignementNonStatique> t)
    {
        tab_enseignements=t;
    }
public static void main (String[] args){
Exercice1Anonyme e= new Exercice1Anonyme(new ArrayList<ModuleEnseignementNonStatique>());
    e.tab_enseignements.add(0,new ModuleEnseignementNonStatique("module1",1999, "M1", "Pierre", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
    e.tab_enseignements.add(1, new ModuleEnseignementNonStatique("module2",2006, "M1", "Dupont", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
    e.tab_enseignements.add(2, new ModuleEnseignementNonStatique("module3",2006, "M2", "Jean", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
    e.tab_enseignements.add(3, new ModuleEnseignementNonStatique("module4",2006, "M2", "Dupont", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
    e.initConsummers();
}

}
