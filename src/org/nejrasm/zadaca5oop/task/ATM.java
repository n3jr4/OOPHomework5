package org.nejrasm.zadaca5oop.task;

import java.util.ArrayList;
import java.util.List;

public class ATM {
    private final AccountsRegister accountsRegister;

    public ATM(final AccountsRegister accountsRegister) {
        this.accountsRegister = accountsRegister;
    }

    public final double withdraw(final double amount, final String serialNumber, final int passcode) {
        Account a = accountsRegister.findAccount(serialNumber, passcode);
        a.withdraw(amount);
        return amount;
    }

    public final double depositMoney(final double amount, final String serialNumber, final int passcode) {
        Account a = accountsRegister.findAccount(serialNumber, passcode);
        a.deposit(amount);
        return amount;
    }

    public final void reset(final String serialNumber, final int passcode) {
        Account a = accountsRegister.findAccount(serialNumber, passcode);
        a.reset();
    }

    public final String showAccountState(final String serialNumber, final int passcode) {
        Account a = accountsRegister.findAccount(serialNumber, passcode);
        return a.toString();
    }
}
