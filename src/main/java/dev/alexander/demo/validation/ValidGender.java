package dev.alexander.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ValidGenderConstraint.class)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidGender{

    String message() default "Invalid person gender! Valid genders:[male, female, n/a]";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}