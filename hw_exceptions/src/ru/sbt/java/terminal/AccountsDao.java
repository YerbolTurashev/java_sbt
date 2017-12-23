package ru.sbt.java.terminal;

import java.util.HashMap;
import java.util.Map;

public class AccountsDao {

    private Map<Long, Account> accountStorage;

    public AccountsDao() {
        accountStorage = new HashMap<>();
    }

    public void addNewAccount(Account account) {
        accountStorage.put(account.getAccountId(), account);
    }

    public Account getAccount(Long accountId) {
        return accountStorage.get(accountId);
    }

    public int size() {
        return  accountStorage.size();
    }

    public boolean contains(Long id) {
        return accountStorage.containsKey(id);
    }
}
