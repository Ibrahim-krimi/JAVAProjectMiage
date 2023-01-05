import java.util.function.Consumer;

public  class  Membre_statique {
    public  Membre_statique(String nomModul, int annee, String Diplome, String Enseignant, TypeExercice g, boolean Prevu) {
        nomModule = nomModul;
        anneeCreation = annee;
        nomDiplome = Diplome;
        nomEnseignant = Enseignant;
        genre = g;
        rattrapagePrevu = Prevu;
    }

    public static enum TypeExercice{
        QCM,projet,questionsSynthese
    }
    private static String nomModule;
    private static int anneeCreation;
    private static String nomDiplome;
    private static String nomEnseignant;
    private static TypeExercice genre;;
    private static boolean rattrapagePrevu;

    public  String getNomModule() {
        return nomModule;
    }

    public  int getAnneeCreation() {
        return anneeCreation;
    }

    public  String getNomDiplome() {
        return nomDiplome;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public TypeExercice getGenre() {
        return genre;
    }

    public boolean isRattrapagePrevu() {
        return rattrapagePrevu;
    }

    public void setNomModule(String nomModul) {
        nomModule = nomModul;
    }

    public void setAnneeCreation(int annee) {
        anneeCreation = annee;
    }

    public void setNomDiplome(String Diplome) {
        nomDiplome = Diplome;
    }

    public void setNomEnseignant(String Enseignant) {
      nomEnseignant = Enseignant;
    }

    public void setGenre(TypeExercice g) {
       genre = g;
    }

    public void setRattrapagePrevu(boolean rattrapage) {
        rattrapagePrevu = rattrapage;
    }

}
