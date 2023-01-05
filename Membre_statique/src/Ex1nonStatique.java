import java.util.ArrayList;
import java.util.function.Consumer;

public class Ex1nonStatique {
    ArrayList<Membre_nonstatique> tab_enseignements;

    public class ConsummerUE implements Consumer<Membre_nonstatique> {
       @Override
        public void accept(Membre_nonstatique m) {
            System.out.println("le nom du module est :" + m.getNomModule() + "et annee de creation initile : " + m.getAnneeCreation());
            m.setAnneeCreation(m.getAnneeCreation() + 1);
            System.out.println("le nom du module est :" + m.getNomModule() + "et annee de creation modifie : " + m.getAnneeCreation());
        }
    }
    public class ConsummerUE2 implements Consumer<Membre_nonstatique>{


        @Override
        public void accept(Membre_nonstatique  m) {
          System.out.println("le nom Moduler / enseignant est :"+m.getNomModule()+"/"+m.getNomEnseignant()+"et annee de creation initiale:"+m.getAnneeCreation());
          if (m.getNomEnseignant().equals("Dupont")){
              m.setAnneeCreation(m.getAnneeCreation()+1);
              System.out.println("le nom Moduler / enseignant est :"+m.getNomModule()+"/"+m.getNomEnseignant()+"et annee de creation Modifier:"+m.getAnneeCreation());
          }
          else {
              System.out.print("Pas de modification : ");
              System.out.println("le nom Moduler / enseignant est :"+m.getNomModule()+"/"+m.getNomEnseignant()+"et annee de creation initiale:"+m.getAnneeCreation());

          }

        }
    }

    public class ConsummerUE3 implements Consumer<Membre_nonstatique>{
        @Override
        public void accept(Membre_nonstatique  m) {
            if (m.getGenre() == Membre_nonstatique.TypeExercice.QCM) {
                m.setRattrapagePrevu(false);
                System.out.println("le nom Module/enseignant est :" + m.getNomModule() + "/" + m.getNomEnseignant());
            } else {
                System.out.println("Pas de modification du rattrapage");
            }
            System.out.println("le nom Module/enseignant est :" + m.getNomModule() + "/" + m.getNomEnseignant() + "et annee de creation initiale" + m.getAnneeCreation());
            if (m.getNomEnseignant().equals("Dupont") && m.getGenre() == Membre_nonstatique.TypeExercice.QCM)
            {
               m.setAnneeCreation(m.getAnneeCreation()+1);
            }
            else{
                System.out.println("Pas de modification de l'annee de creation");
            }
        }

    }
    public Ex1nonStatique(ArrayList<Membre_nonstatique> t)
    {
        tab_enseignements=t;
    }
    public static void main(String[] args){
        Ex1nonStatique e= new Ex1nonStatique(new ArrayList<Membre_nonstatique>());
        e.tab_enseignements.add(0,new Membre_nonstatique("module1",1999,"M1","Pierre", Membre_nonstatique.TypeExercice.QCM,true));
        e.tab_enseignements.add(1,new Membre_nonstatique("module2",2006,"M1","Dupont", Membre_nonstatique.TypeExercice.QCM,true));
        e.tab_enseignements.add(2,new Membre_nonstatique("module3",2006,"M2","Pierre", Membre_nonstatique.TypeExercice.QCM,true));
        e.tab_enseignements.add(3,new Membre_nonstatique("module3",2006,"M2","Pierre", Membre_nonstatique.TypeExercice.QCM,true));
        System.out.println("Question 1.1");
        //////////////////////////////////////
        e.tab_enseignements.forEach(e.new ConsummerUE());
        //////////////////////////////////////
        System.out.println("Question 1.2");
        e.tab_enseignements.forEach(e.new ConsummerUE2());
        //////////////////////////////////////
        System.out.println("Question 1.3");
        e.tab_enseignements.forEach(e.new ConsummerUE3());

    }

}
