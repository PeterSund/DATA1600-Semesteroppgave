package org.oslomet.ExceptionClasses;

public class InvalidLanguageException extends IllegalArgumentException {
    public InvalidLanguageException() {
        super("Language cannot be blank and must contain only letters with a capital first letter");
    }
}
