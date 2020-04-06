package org.oslomet.ExceptionClasses;

public class InvalidBrandException extends IllegalArgumentException {
    public InvalidBrandException() {
        super("Brand cannot be blank or contain characters other then letters, numbers or !#$%&'*+-/=?^_`{|};");
    }
}
