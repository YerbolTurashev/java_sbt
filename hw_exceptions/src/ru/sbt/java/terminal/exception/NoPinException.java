package ru.sbt.java.terminal.exception;

/**
 * Thrown by PinValidator when a user does not enter the pin at all
 */

public class NoPinException extends Exception {

    public NoPinException() {
        super();
    }

    public NoPinException(String message) {
        super(message);
    }
}
