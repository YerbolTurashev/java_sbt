package ru.sbt.java.terminal;


import ru.sbt.java.terminal.exception.NoPinException;
import ru.sbt.java.terminal.exception.WrongPinException;

public class PinValidatorImpl implements PinValidator {

    @Override
    public void validate(Integer accountPin, Integer pin) throws NoPinException, WrongPinException {
       if(pin == null) {
           throw new NoPinException("You didn't input the pin.");
       }

       if(pin.compareTo(accountPin) != 0) {
           throw new WrongPinException("Wrong pin! Try again.");
       }
    }
}
