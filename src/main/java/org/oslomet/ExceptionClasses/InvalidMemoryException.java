package org.oslomet.ExceptionClasses;

public class InvalidMemoryException extends IllegalArgumentException {
    public InvalidMemoryException() {
        super("Memory cannot be blank, bigger then 0 and an even number");
    }
}
