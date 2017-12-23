package ru.sbt.java.terminal;


import ru.sbt.java.terminal.exception.*;

import java.util.Timer;
import java.util.TimerTask;

public class TerminalServer {

    private static final int MAX_FAILED_TRY_COUNT = 3;
    private static final long LOCK_TIME = 5000;
    private final AccountsDao accountsDao;
    private final PinValidator pinValidator;
    private final Timer timer;

    public TerminalServer(AccountsDao accountsDao, PinValidator pinValidator) {
        this.accountsDao = accountsDao;
        this.pinValidator = pinValidator;
        this.timer = new Timer();
    }

    private Account getAccount(Long accountId, Integer pin) throws NoSuchAccountException, PinException, AccessLockedException {
        if (!accountsDao.contains(accountId)) {
            throw new NoSuchAccountException("Account with  account id " + accountId + " does not exist");
        }

        Account account = accountsDao.getAccount(accountId);

        if (!account.isAvailable()) {
            double timeToUnlock = Math.floor(account.getTimeToUnlock() / 1000.0);
            throw new AccessLockedException("Account is locked. Try again " + (timeToUnlock > 0 ? "in " + timeToUnlock + " seconds" : "later"));
        }

        try {
            pinValidator.validate(account.getPin(), pin);

        } catch (WrongPinException | NoPinException e) {
            account.incrementFailedTry();

            if (account.getFailedTries() >= MAX_FAILED_TRY_COUNT) {
                account.lock(LOCK_TIME);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        account.unlock();
                    }
                }, 5000);
            }

            throw new PinException(e);

        }

        return account;
    }


    public Integer giveAccountBalance(Long accountId, Integer pin) {
        Account account = getAccount(accountId, pin);

        return account.getBalance();
    }

    public void putMoney(Long accountId, Integer pin, int moneyValue) {
        if (moneyValue % 100 != 0) {
            throw new UnsupportedAmountOfMoneyException("Please put number that is a multiple of 100");
        }

        Account account = getAccount(accountId, pin);
        account.increaseBalance(moneyValue);
    }

    public Integer takeMoney(Long accountId, Integer pin, int moneyValue) {
        if (moneyValue % 100 != 0) {
            throw new UnsupportedAmountOfMoneyException("Please enter number that is a multiple of 100");
        }

        Account account = getAccount(accountId, pin);
        if (account.getBalance() < moneyValue) {
            throw new LackOfMoneyException("You doesn't have this amount of money on your account.");
        }
        account.reduceBalance(moneyValue);

        return moneyValue;
    }
}
