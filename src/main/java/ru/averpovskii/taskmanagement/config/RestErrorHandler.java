package ru.averpovskii.taskmanagement.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.averpovskii.taskmanagement.model.ValidationErrorException;
import ru.averpovskii.taskmanagement.model.ValidationErrorModel;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler({ValidationErrorException.class})
    public ResponseEntity<ValidationErrorModel> handleValidationErrorModel(final ValidationErrorException e) {
        final var error = new ValidationErrorModel();
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
