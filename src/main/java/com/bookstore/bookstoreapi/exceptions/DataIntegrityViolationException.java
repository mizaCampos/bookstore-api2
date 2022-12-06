package com.bookstore.bookstoreapi.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationException(String arg0) {
        super(arg0);
    }

    public DataIntegrityViolationException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    
    
}
