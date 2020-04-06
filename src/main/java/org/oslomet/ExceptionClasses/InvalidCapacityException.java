package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidCapacityException extends IllegalArgumentException {
    public InvalidCapacityException() {
        super("Capacity cannot be blank and must be between 0 and " + AdminInputValidation.MAX_CAPACITY);
    }
}
