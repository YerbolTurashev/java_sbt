package ru.sbt.java.terminal;


public interface Terminal {

    void checkAccountState(Long id, Integer pin);

    void putMoneyOntoAccount(Long id, Integer pin, Integer moneyValue);

    void getMoneyFromAccount(Long id, Integer pin, Integer moneyValue);

}
