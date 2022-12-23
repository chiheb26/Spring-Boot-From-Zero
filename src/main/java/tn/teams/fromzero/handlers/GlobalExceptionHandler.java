package tn.teams.fromzero.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tn.teams.fromzero.exceptions.ObjectValidationException;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(ObjectValidationException exception) {
        ExceptionRepresentation exp = ExceptionRepresentation.builder()
                .errorMessage("Object not valid exception has occurred")
                .errorSource(exception.getValidationSource())
                .validationErrors(exception.getErrorMessages()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exp);
    }
}
