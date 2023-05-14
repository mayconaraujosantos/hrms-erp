package com.mkdata.company.domain.exception;

public class JobPostingException extends RuntimeException {
    public JobPostingException(String message) {
        super(message);
    }

    public JobPostingException(String message, Throwable cause) {
        super(message, cause);
    }
}
