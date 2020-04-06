package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidSizeException extends IllegalArgumentException {
    public InvalidSizeException() {
        super("Size cannot be blank and must be between 0 and " + AdminInputValidation.MAX_SIZE_MONITOR);
    }
}
