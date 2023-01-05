import java.util.ArrayList;
import java.util.function.Consumer;

public class Exercice1Lambda {


    ArrayList<Membre_nonstatique> tab_enseignement;


    public void initConsumers() throws Exception {
        System.out.println("Question 1.1");
        Consumer<Membre_nonstatique> ConsumerUE = (Membre_nonstatique m) -> {
            System.out.println("le nom du module est " + m.getNomModule() + " et l'année de création initiale est ==> " + m.getAnneeCreation());
            m.setAnneeCreation(m.getAnneeCreation() + 1);
            System.out.println("le nom du module est " + m.getNomModule() + " et l'année de création modifié est ==> " + m.getAnneeCreation());
        };
        tab_enseignement.forEach(ConsumerUE);

        // #########################################################################################################################################

        System.out.println("Question 1.2");

        Consumer<Membre_nonstatique> ConsumerUE2 = (Membre_nonstatique m) -> {
            System.out.println("le nom du module est " + m.getNomModule() + " et l'enseignant est : " + m.getNomEnseignant());
            if (m.getNomEnseignant().equals("M.Dupont")) {
                m.setAnneeCreation(m.getAnneeCreation() + 1);
                System.out.println("Le module " + m.getNomModule() + " a été modifié");
            } else {
                System.out.println("Le module " + m.getNomModule() + " n'a pas été modifié");
            }
        };
        tab_enseignement.forEach(ConsumerUE2);

        // #########################################################################################################################################


        System.out.println("Question 1.3");

        Consumer<Membre_nonstatique> ConsumerUE3 = (Membre_nonstatique m) -> {
            System.out.println("le nom du module est " + m.getNomModule() + " et le type de controle est : " + m.getGenre());
            if (m.getGenre() == Membre_nonstatique.TypeExercice.QCM) {
                m.setRattrapagePrevu(false);
                System.out.println("le  Module  " +  m.getNomModule() +  " a été modifié");
            } else {
                System.out.println("Pas de modification du rattrapage");
            }
        };
        tab_enseignement.forEach(ConsumerUE3);
    }
    public Exercice1Lambda(ArrayList<Membre_nonstatique> t) {
        tab_enseignement = t;
        //enseignements = new ModuleEnseignement[] {new ModuleEnseignement("module1",1999, "M1", "Pierre", TypeExercice.QCM, true), new ModuleEnseignement("module2",2006, "M2", "Jean", TypeExercice.QCM, true)};
    }
    public static void main(String[] args) throws Exception {
        Exercice1Lambda e = new Exercice1Lambda(new  ArrayList<Membre_nonstatique>());

        e.tab_enseignement.add(0, new Membre_nonstatique("AGILE", 2018, "MIAGE", "M.Dupont", Membre_nonstatique.TypeExercice.QCM, true));
        e.tab_enseignement.add(1, new Membre_nonstatique("SCRUM", 2010, "MIAGE", "M.Donati", Membre_nonstatique.TypeExercice.Projet, false));
        e.tab_enseignement.add(2, new Membre_nonstatique("JYTHON", 2011, "MIAGE", "M.Alpha", Membre_nonstatique.TypeExercice.questionsSynthese, true));
        e.tab_enseignement.add(3, new Membre_nonstatique("HASKEL", 2017, "informatique", "M.Beta", Membre_nonstatique.TypeExercice.QCM, true));
        try {
            e.initConsumers();
        } catch (Exception ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }
    }

}