package ru.sbt.java.terminal;


import ru.sbt.java.terminal.exception.AccessLockedException;
import ru.sbt.java.terminal.exception.LackOfMoneyException;
import ru.sbt.java.terminal.exception.UnsupportedAmountOfMoneyException;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final MessagePrinter printer;

    public TerminalImpl(TerminalServer server, MessagePrinter printer) {
        this.server = server;
        this.printer = printer;
    }

    @Override
    public void checkAccountState(Long id, Integer pin) {
        try {
            printer.print(server.giveAccountBalance(id, pin).toString());
        } catch (PinException | AccessLockedException e) {
            printer.print(e.getMessage());
        }
    }

    @Override
    public void putMoneyOntoAccount(Long id, Integer pin, Integer moneyValue) {
        try {
            server.putMoney(id, pin, moneyValue);
            printer.print("Success");
        } catch (PinException | AccessLockedException | UnsupportedAmountOfMoneyException | LackOfMoneyException e) {
            printer.print(e.getMessage());
        }
    }

    @Override
    public void getMoneyFromAccount(Long id, Integer pin, Integer moneyValue) {
        try {
            printer.print(server.takeMoney(id, pin, moneyValue).toString());
        } catch (PinException | UnsupportedAmountOfMoneyException | LackOfMoneyException | AccessLockedException e) {
            printer.print(e.getMessage());
        }
    }


}
