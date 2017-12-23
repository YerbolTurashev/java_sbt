package ru.sbt.java.terminal;


public class Account {

    private final long accountId;
    private final int pin;
    private int balance;
    private boolean isAvailable;
    private long timeOfTheUnlock;
    private int failedTries;

    public Account(long accountId, int pin, int balance, boolean isAvailable) {
        this.accountId = accountId;
        this.pin = pin;
        this.balance = balance;
        this.isAvailable = isAvailable;
        this.timeOfTheUnlock = System.currentTimeMillis();
        this.failedTries = 0;
    }


    public Integer getPin() {
        return pin;
    }

    public Integer getBalance() {
        return balance;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void reduceBalance(double v) {
        balance -= v;
    }

    public void increaseBalance(double v) {
        balance += v;
    }

    public void lock(Long time) {
        isAvailable = false;
        timeOfTheUnlock = System.currentTimeMillis() + time;

    }

    public void unlock() {
        failedTries = 0;
        isAvailable = true;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getTimeToUnlock() {
        return timeOfTheUnlock - System.currentTimeMillis();
    }

    public Integer getFailedTries() {

        return failedTries;
    }

    public void incrementFailedTry() {
        failedTries++;
    }
}
