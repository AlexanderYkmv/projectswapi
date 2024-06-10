package dev.alexander.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidHeightConstraint implements ConstraintValidator<ValidHeight, String> {
    
    public boolean isValid(String height, ConstraintValidatorContext context){
        Integer personHeight = Integer.parseInt(height);
        if(personHeight >= 50 && personHeight <= 250){
            return true;    
        }
        return false;

    }
}