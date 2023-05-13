package com.mkdata.company.domain.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InvalidYearsOfExperienceExceptionTest {

    @Test
    @DisplayName("Testing constructor with specified detail message")
    public void testConstructorWithMessage() {
        String errorMessage = "Custom error message";
        InvalidYearsOfExperienceException exception = new InvalidYearsOfExperienceException(errorMessage);
        Assertions.assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Testing constructor with default detail message")
    public void testConstructorWithDefaultMessage() {
        InvalidYearsOfExperienceException exception = new InvalidYearsOfExperienceException();
        Assertions.assertEquals("Invalid number of years of experience", exception.getMessage());
    }

    @Test
    @DisplayName("Testing constructor with specified detail message and cause")
    public void testConstructorWithMessageAndCause() {
        String errorMessage = "Custom error message";
        Throwable cause = new Throwable("Cause message");
        InvalidYearsOfExperienceException exception = new InvalidYearsOfExperienceException(errorMessage, cause);
        Assertions.assertEquals(errorMessage, exception.getMessage());
        Assertions.assertEquals(cause, exception.getCause());
    }
}
