package org.oslomet.ExceptionClasses;

public class InvalidBrandException extends IllegalArgumentException {
    public InvalidBrandException(String msg) {
        super(msg);
    }
}
