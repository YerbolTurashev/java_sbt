package ru.sbt.java.terminal;

import ru.sbt.java.terminal.exception.NoPinException;
import ru.sbt.java.terminal.exception.WrongPinException;

public interface PinValidator {
    void validate(Integer account, Integer pin) throws NoPinException, WrongPinException;
}
