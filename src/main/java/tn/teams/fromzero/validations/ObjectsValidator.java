package tn.teams.fromzero.validations;

import tn.teams.fromzero.exceptions.ObjectValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

public class ObjectsValidator <T>{
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validate(T objectValidateReference){
        Set<ConstraintViolation<T>> violations = validator.validate(objectValidateReference);
        if(!violations.isEmpty()){
            Set<String> errorMessages = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
            throw new ObjectValidationException(errorMessages,objectValidateReference.getClass().getSimpleName());
        }
    }
}
