package org.oslomet.ExceptionClasses;

public class InvalidWattException extends IllegalArgumentException {
    public InvalidWattException(String msg) {
        super(msg);
    }
}
