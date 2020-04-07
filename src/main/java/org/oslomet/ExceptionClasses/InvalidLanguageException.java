package org.oslomet.ExceptionClasses;

public class InvalidLanguageException extends IllegalArgumentException {
    public InvalidLanguageException(String msg) {
        super(msg);
    }
}
