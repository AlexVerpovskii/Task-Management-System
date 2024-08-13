package ru.averpovskii.taskmanagement.model;

import lombok.Getter;

@Getter
public class ValidationErrorException extends RuntimeException {
    public ValidationErrorException(final String message) {
        super(message);
    }
}
