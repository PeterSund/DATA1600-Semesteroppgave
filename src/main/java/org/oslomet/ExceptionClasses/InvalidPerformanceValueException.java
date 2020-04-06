package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidPerformanceValueException extends IllegalArgumentException {
    public InvalidPerformanceValueException(String msg) {
        super(msg);
    }
}
