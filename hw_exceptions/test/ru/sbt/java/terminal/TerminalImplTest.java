package ru.sbt.java.terminal;

import org.junit.Test;

import java.util.Random;


public class TerminalImplTest {
    @Test
    public void checkAccountStateTest() {
        AccountsDao dao = new AccountsDao();
        Random randomForID = new Random(100-000-000);
        Random randomForPin = new Random(10000);
        Random randomForBalance = new Random(100000000);


        for(int i = 0; i < 1000; ++i) {
            dao.addNewAccount(new Account(randomForID.nextLong(), randomForPin.nextInt(), randomForBalance.nextInt(), true));
        }
        dao.addNewAccount(new Account(103567, 2005, 10000, true));

        TerminalServer server = new TerminalServer(dao, new PinValidatorImpl());
        Terminal terminal = new TerminalImpl(server, new ConsoleMessagePrinter());

        for(int i =0; i < 6; ++i) {
            terminal.checkAccountState(103567L, 2006);
        }

        for(int i = 0; i < 10; ++i) {

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            terminal.checkAccountState(103567L, 2005);
        }
    }

    @Test
    public void putMoneyOntoAccountTest()  {
        AccountsDao dao = new AccountsDao();
        Random randomForID = new Random(100-000-000);
        Random randomForPin = new Random(10000);
        Random randomForBalance = new Random(100000000);


        for(int i = 0; i < 1000; ++i) {
            dao.addNewAccount(new Account(randomForID.nextLong(), randomForPin.nextInt(), randomForBalance.nextInt(), true));
        }
        dao.addNewAccount(new Account(103567, 2005, 10000, true));

        TerminalServer server = new TerminalServer(dao, new PinValidatorImpl());
        Terminal terminal = new TerminalImpl(server, new ConsoleMessagePrinter());

        for(int i =0; i < 6; ++i) {
            terminal.putMoneyOntoAccount(103567L, 2005, 135);
        }

        for(int i = 0; i < 10; ++i) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            terminal.putMoneyOntoAccount(103567L, 2005, 100);
        }
    }

    @Test
    public void getMoneyFromAccountTest() {

    }

}