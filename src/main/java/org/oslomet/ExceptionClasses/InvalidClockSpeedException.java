package org.oslomet.ExceptionClasses;

public class InvalidClockSpeedException extends IllegalArgumentException {
    public InvalidClockSpeedException(String msg) {
        super(msg);
    }
}
