package ru.sbt.java.terminal.exception;

/**
 * Thrown by TerminalServer when the pin was entered wrong three times in a row
 */

public class AccessLockedException extends RuntimeException {

    public AccessLockedException() {
        super();
    }

    public AccessLockedException(String message) {
        super(message);
    }
}
