package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidPerformanceValueException extends IllegalArgumentException {
    public InvalidPerformanceValueException() {
        super("Performancevalue cannot be blank and must be between 0 and " + AdminInputValidation.MAX_PERFORMANCE_VALUE);
    }
}
