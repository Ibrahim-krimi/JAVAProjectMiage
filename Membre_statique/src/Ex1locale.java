import java.util.ArrayList;
import java.util.function.Consumer;
public class Ex1locale {
    static ArrayList <Membre_nonstatique> tab_enseignements ;

    public void methodConsumer() throws Exception {

        class ConsummerUE implements Consumer<Membre_nonstatique> {
            @Override
            public void accept(Membre_nonstatique m) {
                System.out.println("le nom du module est :" + m.getNomModule() + "et annee de creation initile : " + m.getAnneeCreation());
                m.setAnneeCreation(m.getAnneeCreation() + 1);
                System.out.println("le nom du module est :" + m.getNomModule() + "et annee de creation modifie : " + m.getAnneeCreation());
            }

        }
        class ConsummerUE2 implements Consumer<Membre_nonstatique> {

            @Override
            public void accept(Membre_nonstatique m) {
                System.out.println("le nom Module / enseignant est :" + m.getNomModule() + "/" + m.getNomEnseignant() + " et annee de creation initiale: " + m.getAnneeCreation());
                if (m.getNomEnseignant().equals("Dupont")) {
                    m.setAnneeCreation(m.getAnneeCreation() + 1);
                    System.out.println("le nom Module / enseignant est :" + m.getNomModule() + "/" + m.getNomEnseignant() + " et annee de creation Modifier: " + m.getAnneeCreation());
                } else {
                    System.out.print("Pas de modification : ");
                    System.out.println("le nom Module  / enseignant est : " + m.getNomModule() + "/" + m.getNomEnseignant() + "et annee de creation initiale: " + m.getAnneeCreation());

                }

            }
        }

        class ConsummerUE3 implements Consumer<Membre_nonstatique> {
            @Override
            public void accept(Membre_nonstatique m) {
                if (m.getGenre() == Membre_nonstatique.TypeExercice.QCM) {
                    m.setRattrapagePrevu(false);
                    System.out.println("le nom Module/enseignant est :" + m.getNomModule() + "/" + m.getNomEnseignant());
                } else {
                    System.out.println("Pas de modification du rattrapage");
                }
                System.out.println("le nom Module/enseignant est :" + m.getNomModule() + "/" + m.getNomEnseignant() + "et annee de creation initiale" + m.getAnneeCreation());
                if (m.getNomEnseignant().equals("Dupont") && m.getGenre() == Membre_nonstatique.TypeExercice.QCM) {
                    m.setAnneeCreation(m.getAnneeCreation() + 1);
                } else {
                    System.out.println("Pas de modification de l'annee de creation");
                }
            }

        }
        System.out.println("Question 1.1");
        tab_enseignements.forEach(new ConsummerUE());
        System.out.println("Question 1.2");
        tab_enseignements.forEach(new ConsummerUE2());
        System.out.println("Question 1.3");
        tab_enseignements.forEach(new ConsummerUE3());
    }

    public Ex1locale(ArrayList<Membre_nonstatique> t)
    {

        tab_enseignements=t;
    }
    public static void main(String[] args){
        Ex1locale e = new Ex1locale(new  ArrayList<Membre_nonstatique>());

        e.tab_enseignements.add(0, new Membre_nonstatique("AGILE", 2018, "MIAGE", "M.Dupont", Membre_nonstatique.TypeExercice.QCM, true));
        e.tab_enseignements.add(1, new Membre_nonstatique("SCRUM", 2010, "MIAGE", "M.Donati", Membre_nonstatique.TypeExercice.Projet, false));
        e.tab_enseignements.add(2, new Membre_nonstatique("JYTHON", 2011, "MIAGE", "M.Alpha", Membre_nonstatique.TypeExercice.questionsSynthese, true));
        e.tab_enseignements.add(3, new Membre_nonstatique("HASKEL", 2017, "informatique", "M.Beta", Membre_nonstatique.TypeExercice.QCM, true));
        try {
            e.methodConsumer();
        } catch (Exception ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }

    }


}
