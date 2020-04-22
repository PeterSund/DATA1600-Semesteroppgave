package org.oslomet.ExceptionClasses;

public class InvalidSizeException extends IllegalArgumentException {
    public InvalidSizeException(String msg) {
        super(msg);
    }
}
