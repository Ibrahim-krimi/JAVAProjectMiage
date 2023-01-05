
import java.util.ArrayList;
import java.util.function.Consumer;

public class Ex1Statique {
        static ArrayList <Membre_statique> tab_enseignements ;

    public static class ConsummerUE implements Consumer<Membre_statique> {
        @Override
        public void accept(Membre_statique m) {
            System.out.println("le nom du module est :" + m.getNomModule() + "et annee de creation initile : " + m.getAnneeCreation());
            m.setAnneeCreation(m.getAnneeCreation() + 1);
            System.out.println("le nom du module est :" + m.getNomModule() + "et annee de creation modifie : " + m.getAnneeCreation());
        }
    }
    public static class ConsummerUE2 implements Consumer<Membre_statique>{


        @Override
        public  void accept(Membre_statique  m) {
            System.out.println("le nom Module / enseignant est :"+m.getNomModule()+"/"+m.getNomEnseignant()+" et annee de creation initiale: "+m.getAnneeCreation());
            if (m.getNomEnseignant().equals("Dupont")){
                m.setAnneeCreation(m.getAnneeCreation()+1);
                System.out.println("le nom Module / enseignant est :"+m.getNomModule()+"/"+m.getNomEnseignant()+" et annee de creation Modifier: "+m.getAnneeCreation());
            }
            else {
                System.out.print("Pas de modification : ");
                System.out.println("le nom Module  / enseignant est : "+m.getNomModule()+"/"+m.getNomEnseignant()+"et annee de creation initiale: "+m.getAnneeCreation());

            }

        }
    }

    public static class ConsummerUE3 implements Consumer<Membre_statique>{
        @Override
        public void accept(Membre_statique  m) {
            if (m.getGenre() == Membre_statique.TypeExercice.QCM) {
                m.setRattrapagePrevu(false);
                System.out.println("le nom Module/enseignant est :" + m.getNomModule() + "/" + m.getNomEnseignant());
            } else {
                System.out.println("Pas de modification du rattrapage");
            }
            System.out.println("le nom Module/enseignant est :" + m.getNomModule() + "/" + m.getNomEnseignant() + "et annee de creation initiale" + m.getAnneeCreation());
            if (m.getNomEnseignant().equals("Dupont") && m.getGenre() == Membre_statique.TypeExercice.QCM)
            {
                m.setAnneeCreation(m.getAnneeCreation()+1);
            }
            else{
                System.out.println("Pas de modification de l'annee de creation");
            }
        }

    }
    public Ex1Statique(ArrayList<Membre_statique> t)
    {

        tab_enseignements=t;
    }
    public static void main(String[] args){
        Ex1Statique e= new Ex1Statique(new ArrayList<Membre_statique>());

        /* e.tab_enseignements.add(0,new  Membre_statique("module1",1999,"M1","Pierre", Membre_statique.TypeExercice.QCM,true));
        e.tab_enseignements.add(1,new Membre_statique("module2",2006,"M1","Dupont", Membre_statique.TypeExercice.QCM,true));
        e.tab_enseignements.add(2,new Membre_statique("module3",2006,"M2","alex", Membre_statique.TypeExercice.QCM,true));
        e.tab_enseignements.add(3,new Membre_statique("module4",2007,"M2","john", Membre_statique.TypeExercice.QCM,true));*/

        System.out.println("Question 1.1");
        //////////////////////////////////////
       // e.tab_enseignements.forEach((n) -> System.out.println(n.getNomModule()));
        //e.tab_enseignements.forEach(new ConsummerUE());
        //////////////////////////////////////
        System.out.println("Question 1.2");
     //   e.tab_enseignements.forEach(new ConsummerUE2());
        //////////////////////////////////////
        System.out.println("Question 1.3");
      //  e.tab_enseignements.forEach(new ConsummerUE3());

    }

}
