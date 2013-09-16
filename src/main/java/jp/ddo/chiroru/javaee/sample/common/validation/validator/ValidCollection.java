package jp.ddo.chiroru.javaee.sample.common.validation.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ValidCollectionValidator.class})
public @interface ValidCollection {
    
    Class<?> elementType();

    /* Specify constraints when collection element type is NOT constrained 
     * validator.getConstraintsForClass(elementType).isBeanConstrained(); */
    Class<?>[] constraints() default {};

    boolean allViolationMessages() default true;

    String message() default "{ValidCollection.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
