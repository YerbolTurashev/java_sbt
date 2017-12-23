package ru.sbt.java.terminal.exception;

/**
 * Thrown by TerminalServer when AccountsDao has no account with given id
 */

public class NoSuchAccountException extends RuntimeException {

    public NoSuchAccountException() {
        super();
    }

    public NoSuchAccountException(String message) {
        super(message);
    }
}
