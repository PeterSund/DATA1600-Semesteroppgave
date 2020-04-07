package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidCapacityException extends IllegalArgumentException {
    public InvalidCapacityException(String msg) {
        super(msg);
    }
}
