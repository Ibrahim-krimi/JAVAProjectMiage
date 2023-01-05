import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface ComplementChamp {
    boolean ShouldBePersistent() default true;

    String author() default "anonyme";
}
