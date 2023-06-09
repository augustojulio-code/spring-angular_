package com.julio.bookstore.services.exceptions;

public class DeleteIntegritViolationException extends RuntimeException {

    public DeleteIntegritViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteIntegritViolationException(String message) {
        super(message);
    }
}
