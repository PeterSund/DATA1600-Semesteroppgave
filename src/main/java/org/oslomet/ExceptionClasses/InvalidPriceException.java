package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException(String msg) {
        super(msg);
    }
}
