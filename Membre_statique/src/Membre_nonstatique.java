public class Membre_nonstatique {
    public Membre_nonstatique(String nomModule, int anneeCreation, String nomDiplome, String nomEnseignant, TypeExercice genre, boolean rattrapagePrevu) {
        this.nomModule = nomModule;
        this.anneeCreation = anneeCreation;
        this.nomDiplome = nomDiplome;
        this.nomEnseignant = nomEnseignant;
        this.genre = genre;
        this.rattrapagePrevu = rattrapagePrevu;
    }

    public enum TypeExercice{
        QCM,Projet,questionsSynthese
    }
    private String nomModule;
    private int anneeCreation;
    private String nomDiplome;
    private String nomEnseignant;
    private TypeExercice genre;;
    private boolean rattrapagePrevu;

    public String getNomModule() {
        return nomModule;
    }

    public int getAnneeCreation() {
        return anneeCreation;
    }

    public String getNomDiplome() {
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

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public void setAnneeCreation(int anneeCreation) {
       this.anneeCreation = anneeCreation;
    }

    public void setNomDiplome(String nomDiplome) {
        this.nomDiplome = nomDiplome;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public void setGenre(TypeExercice genre) {
        this.genre = genre;
    }

    public void setRattrapagePrevu(boolean rattrapagePrevu) {
        this.rattrapagePrevu = rattrapagePrevu;
    }

}
