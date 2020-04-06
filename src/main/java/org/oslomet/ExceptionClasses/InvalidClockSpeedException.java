package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidClockSpeedException extends IllegalArgumentException {
    public InvalidClockSpeedException() {
        super("Clockspeed must be between 0 and " + AdminInputValidation.MAX_CLOCK_SPEED);
    }
}
