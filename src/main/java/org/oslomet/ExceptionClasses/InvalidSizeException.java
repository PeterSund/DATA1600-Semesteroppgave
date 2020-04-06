package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidSizeException extends IllegalArgumentException {
    public InvalidSizeException(String msg) {
        super(msg);
    }
}
