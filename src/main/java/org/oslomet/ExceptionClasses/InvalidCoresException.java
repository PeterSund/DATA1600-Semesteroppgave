package org.oslomet.ExceptionClasses;

public class InvalidCoresException extends IllegalArgumentException {
    public InvalidCoresException() {
        super("Cores cannot be blank and must be between and even number");
    }
}
