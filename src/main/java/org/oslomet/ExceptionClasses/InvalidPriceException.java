package org.oslomet.ExceptionClasses;

import org.oslomet.ComponentClasses.AdminInputValidation;

public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException() {
        super("Price cannot be blank and must be between 0 and " + AdminInputValidation.MAX_PRICE);
    }
}
