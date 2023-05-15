package com.mkdata.company.domain.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("JobPostingException should")
class JobPostingExceptionTest {

    @Nested
    @DisplayName("have a constructor that")
    class ConstructorTests {
        @Test
        @DisplayName("take a message and set it as the exception message")
        void takeMessage() {
            String message = "test message";
            JobPostingException ex = new JobPostingException(message);

            assertEquals(message, ex.getMessage());
        }

        @Test
        @DisplayName("take a message and a cause and set them as the exception message and cause")
        void takeMessageAndCause() {
            String message = "test message";
            Exception cause = new Exception("test cause");
            JobPostingException ex = new JobPostingException(message, cause);

            assertEquals(message, ex.getMessage());
            assertEquals(cause, ex.getCause());
        }

        @Test
        @DisplayName("return an instance of JobPostingException")
        void returnInstance() {
            String message = "test message";
            JobPostingException ex = new JobPostingException(message);

            assertNotNull(ex);
            assertEquals(JobPostingException.class, ex.getClass());
        }
    }

    @Nested
    @DisplayName("be constructed by throwing the exception which ")
    class ThrowTests {
        @Test
        @DisplayName("is constructed with only a message")
        void throwWithMessage() {
            String message = "test message";

            try {
                throw new JobPostingException(message);
            } catch (JobPostingException ex) {
                assertEquals(message, ex.getMessage());
                assertNull(ex.getCause());
            }
        }

        @Test
        @DisplayName("is constructed with a message and a cause")
        void throwWithMessageAndCause() {
            String message = "test message";
            Exception cause = new Exception("test cause");

            try {
                throw new JobPostingException(message, cause);
            } catch (JobPostingException ex) {
                assertEquals(message, ex.getMessage());
                assertEquals(cause, ex.getCause());
            }
        }
    }
}
