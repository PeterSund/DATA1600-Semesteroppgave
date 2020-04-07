package org.oslomet.ExceptionClasses;

public class InvalidMemoryException extends IllegalArgumentException {
    public InvalidMemoryException(String msg) {
        super(msg);
    }
}
