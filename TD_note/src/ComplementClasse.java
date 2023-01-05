import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface ComplementClasse {
    boolean shouldBeSerializable() default false;

    String author() default "anonyme";
}
