package ru.sbt.java.terminal;

public class ConsoleMessagePrinter implements MessagePrinter {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
