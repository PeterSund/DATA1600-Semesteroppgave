package org.oslomet.ExceptionClasses;

public class InvalidCapacityException extends IllegalArgumentException {
    public InvalidCapacityException(String msg) {
        super(msg);
    }
}
