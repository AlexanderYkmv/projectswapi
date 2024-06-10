package dev.alexander.demo.validation;

import java.util.Set;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidGenderConstraint implements ConstraintValidator<ValidGender, String> {

    private Set<String> validGenders = Set.of("male", "female", "n/a");
    
    public boolean isValid(String gender, ConstraintValidatorContext context){
        if(validGenders.contains(gender)){
            return true;
        }
        return false;
        
    }
}