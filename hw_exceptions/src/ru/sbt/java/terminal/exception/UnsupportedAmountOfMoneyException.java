package ru.sbt.java.terminal.exception;

/**
 *  Thrown when amount of money that is put into terminal is not a multiple 100
 */

public class UnsupportedAmountOfMoneyException extends RuntimeException {

    public UnsupportedAmountOfMoneyException() {
        super();
    }

    public UnsupportedAmountOfMoneyException(String message) {
        super(message);
    }
}
