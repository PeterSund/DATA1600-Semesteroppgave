package org.oslomet.ExceptionClasses;

public class InvalidDimensionsException extends IllegalArgumentException {
    public InvalidDimensionsException() {
        super("Dimensions cannot be blank and must be in input-format HxLxD");
    }
}
