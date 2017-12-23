package ru.sbt.java.terminal;


public class PinException extends RuntimeException {

    public PinException(Throwable cause) {
        super(cause);
    }

    public PinException() {
        super();
    }

    public PinException(String message) {
        super(message);
    }
}
