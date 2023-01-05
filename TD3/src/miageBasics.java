import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE.METHOD,ElementType.FIELD})
public @interface miageBasics {
    public String Nom();
    public String prenom();
    public int Anne();
    public String module();
    public int Sceance();

}
