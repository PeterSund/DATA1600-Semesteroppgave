package org.oslomet.ExceptionClasses;

public class InvalidColorException extends IllegalArgumentException {
    public InvalidColorException(String msg) {
        super(msg);
    }
}
