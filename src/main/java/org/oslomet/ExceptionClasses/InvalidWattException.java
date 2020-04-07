package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidWattException extends IllegalArgumentException {
    public InvalidWattException(String msg) {
        super(msg);
    }
}
