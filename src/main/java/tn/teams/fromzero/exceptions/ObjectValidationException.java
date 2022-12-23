package tn.teams.fromzero.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
@RequiredArgsConstructor
@Getter
public class ObjectValidationException extends RuntimeException{
    private final Set<String> errorMessages;

    private final String validationSource;



}
