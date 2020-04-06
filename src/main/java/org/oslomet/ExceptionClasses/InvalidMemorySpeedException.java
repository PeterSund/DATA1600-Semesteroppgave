package org.oslomet.ExceptionClasses;

public class InvalidMemorySpeedException extends IllegalArgumentException {
    public InvalidMemorySpeedException() {
        super("Memory-speed cannot be blank and must be greater then 0");
    }
}
