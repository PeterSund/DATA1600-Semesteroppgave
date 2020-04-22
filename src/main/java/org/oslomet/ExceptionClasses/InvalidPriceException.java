package org.oslomet.ExceptionClasses;

public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException(String msg) {
        super(msg);
    }
}
