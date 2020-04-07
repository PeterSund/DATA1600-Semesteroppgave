package org.oslomet.ExceptionClasses;

public class InvalidDimensionsException extends IllegalArgumentException {
    public InvalidDimensionsException(String msg) {
        super(msg);
    }
}
