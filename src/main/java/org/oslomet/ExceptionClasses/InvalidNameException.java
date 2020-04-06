package org.oslomet.ExceptionClasses;

public class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException() {
        super("Name cannot be blank or contain characters other then letters, numbers or !#$%&'*+-/=?^_`{|};");
    }
}
