package org.oslomet.ExceptionClasses;

public class InvalidPerformanceValueException extends IllegalArgumentException {
    public InvalidPerformanceValueException(String msg) {
        super(msg);
    }
}
