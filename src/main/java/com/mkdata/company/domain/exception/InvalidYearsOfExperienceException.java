package com.mkdata.company.domain.exception;

public final class InvalidYearsOfExperienceException extends RuntimeException {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidYearsOfExperienceException(String message) {
        super(message);
    }

    /** Constructs a new exception with a default detail message. */
    public InvalidYearsOfExperienceException() {
        super("Invalid number of years of experience");
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method)
     */
    public InvalidYearsOfExperienceException(String message, Throwable cause) {
        super(message, cause);
    }
}
