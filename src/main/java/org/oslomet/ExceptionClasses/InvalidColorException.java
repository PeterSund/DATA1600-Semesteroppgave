package org.oslomet.ExceptionClasses;

public class InvalidColorException extends IllegalArgumentException {
    public InvalidColorException() {
        super("Color cannot be blank and must be entered with a capital first letters. Only letters allowed");
    }
}
