package miage.TDAnnotations.exercice2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME) //, ElementType.PARAMETER
@Documented
public @interface miageBasics {
	
	String nomAuteur();
	String prenomAuteur();
	int anneeUniversitaire() default 2020;
	String moduleInfo() default "";
	int seanceTD() default 0;
}
