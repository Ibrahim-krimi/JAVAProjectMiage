package Ex1;

import miage.TDClassesInternes.ModuleEnseignementNonStatique;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Exercice1Lambda {

    ArrayList<ModuleEnseignementNonStatique> tab_enseignement;
public void initConsummers() {
    System.out.println("Question 1.1");
    Consumer<ModuleEnseignementNonStatique> traitemen1 = (ModuleEnseignementNonStatique m) -> {
        System.out.println("le nom du module est : " + m.getNomModule() + " et année de création initiale : " + m.getAnneeCreation());
        m.setAnneeCreation(m.getAnneeCreation() + 1);
        System.out.println("le nom du module est : " + m.getNomModule() + " et année de création modifiée : " + m.getAnneeCreation());
    };
    tab_enseignement.forEach(traitemen1)
    ;
    System.out.println("Question 1.1");
    Consumer<ModuleEnseignementNonStatique> traitemen2 = (ModuleEnseignementNonStatique m) -> {
        System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / "+ m.getNomEnseignant() + " et année de création initiale : " + m.getAnneeCreation());
        if (m.getNomEnseignant().equals("Dupont"))
            m.setAnneeCreation(m.getAnneeCreation() + 1);
        else
            System.out.print("Pas de modification: ");
        System.out.println("le nom Module/enseignant est : " + m.getNomModule() + " / " + m.getNomEnseignant() + " et année de création modifiée : " + m.getAnneeCreation());

    };
    tab_enseignement.forEach(traitemen2);
    Consumer<ModuleEnseignementNonStatique> traitemen3 = (ModuleEnseignementNonStatique m) -> {
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

    };
    tab_enseignement.forEach(traitemen3);

    }
    public Exercice1Lambda(ArrayList<ModuleEnseignementNonStatique> t)
    {
        this.tab_enseignement=t;

    }
public static void main(String[] args)
{
Exercice1Lambda e =new Exercice1Lambda(new ArrayList<ModuleEnseignementNonStatique>());
    e.tab_enseignement.add(0,new ModuleEnseignementNonStatique("module1",1999, "M1", "Pierre", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
    e.tab_enseignement.add(1, new ModuleEnseignementNonStatique("module2",2006, "M1", "Dupont", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
    e.tab_enseignement.add(2, new ModuleEnseignementNonStatique("module3",2006, "M2", "Jean", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
    e.tab_enseignement.add(3, new ModuleEnseignementNonStatique("module4",2006, "M2", "Dupont", ModuleEnseignementNonStatique.TypeExercice.QCM, true));
    e.initConsummers();
}

}
