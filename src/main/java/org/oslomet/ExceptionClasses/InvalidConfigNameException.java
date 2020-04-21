package org.oslomet.ExceptionClasses;

public class InvalidConfigNameException extends IllegalArgumentException {
    public InvalidConfigNameException(String msg) {
        super(msg);
    }
}

