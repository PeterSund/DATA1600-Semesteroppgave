package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidWattException extends IllegalArgumentException {
    public InvalidWattException() {
        super("Watt cannot be blank and must be between 0 and " + AdminInputValidation.MAX_WATT);
    }
}
