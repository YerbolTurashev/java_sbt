package ru.sbt.java.terminal.exception;

/**
 * Thrown by TerminalServer when takeMoney method calls with a value
 * of parameter moneyValue less than current balance of the account
 */

public class LackOfMoneyException extends RuntimeException {

    public LackOfMoneyException() {
        super();
    }

    public LackOfMoneyException(String message) {
        super(message);
    }
}
