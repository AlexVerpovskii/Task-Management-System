package ru.averpovskii.taskmanagement.service;

import org.springframework.stereotype.Component;
import ru.averpovskii.taskmanagement.model.ValidationErrorException;

import java.io.Serializable;
import java.util.Objects;

@Component
public class TaskValidator {

    public void assertEquals(final String message, final Serializable expected,
                             final Serializable value) {
        final boolean check = !Objects.equals(expected, value);
        if (check) {
            throw new ValidationErrorException(message);
        }
    }

    public void assertTrue(final String message, final Serializable value) {
        final boolean check = !Boolean.TRUE.equals(value);
        if (check) {
            throw new ValidationErrorException(message);
        }
    }

    public void assertIsNull(final String message, final Object value) {
        final boolean check = value != null;
        if (check) {
            throw new ValidationErrorException(message);
        }
    }
}
