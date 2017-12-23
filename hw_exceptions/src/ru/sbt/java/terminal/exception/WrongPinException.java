package ru.sbt.java.terminal.exception;


/**
 *  Thrown by PinValidator when a user enters wrong password to the account
 */

public class WrongPinException extends Exception {

    public WrongPinException() {
        super();
    }

    public WrongPinException(String message) {
        super(message);
    }
}
