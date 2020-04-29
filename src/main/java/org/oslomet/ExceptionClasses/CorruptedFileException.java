package org.oslomet.ExceptionClasses;

public class CorruptedFileException extends NullPointerException {
    public CorruptedFileException(String msg) {
        super(msg);
    }
}
