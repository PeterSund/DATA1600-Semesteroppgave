package org.oslomet.ExceptionClasses;

public class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException(String msg) {
        super(msg);
    }
}
