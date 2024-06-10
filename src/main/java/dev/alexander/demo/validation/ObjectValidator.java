package dev.alexander.demo.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Validation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidatorFactory;

@Component
public class ObjectValidator {

    private final ValidatorFactory vf = Validation.buildDefaultValidatorFactory();

    private final Validator validator = vf.getValidator();

    public Map<String, String> validate(Object object) {

        Set<ConstraintViolation<Object>> validationProblems = validator.validate(object);

        Map<String, String> violatioMap = new HashMap<>();

        for(ConstraintViolation<Object> violation : validationProblems){
            violatioMap.put(
                violation.getPropertyPath().toString(),
                violation.getMessage()
            );
        }
        return violatioMap;
    }
}