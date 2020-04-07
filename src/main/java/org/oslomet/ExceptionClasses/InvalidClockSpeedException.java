package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidClockSpeedException extends IllegalArgumentException {
    public InvalidClockSpeedException(String msg) {
        super(msg);
    }
}
