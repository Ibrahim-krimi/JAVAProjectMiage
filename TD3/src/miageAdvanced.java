
public @interface miageAdvanced {
    public enum Etats_de_completude{
        draft_partiel,
        draft_complet,
        version_finalisé;
    }
    public Boolean Etat_des_tests = false;
    public Boolean Etat_automatisation = false;

}
