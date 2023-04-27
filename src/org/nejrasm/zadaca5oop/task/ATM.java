package org.nejrasm.zadaca5oop.task;

import java.util.ArrayList;
import java.util.List;

public class ATM {
    private final List<Account> accountsRegister;

    public ATM(List<Account> accountsRegister) {
        this.accountsRegister = new ArrayList<Account>(accountsRegister);
    }

    public void addAccount(final Account account) {
        String givenSerialNumber = account.getSerialNumber();
        if (accountAlreadyExists(givenSerialNumber)) {
            throw new IllegalArgumentException("Account with given serial number already exits!");
        } else accountsRegister.add(account);
    }

    public Account findAccount(final String serialNumber, final int passcode) {
        for (Account a : accountsRegister) {
            if (a.doesSerialNumberExists(serialNumber)) {
                a.isPasscodeInRange(passcode);
                a.isPasscodeCorrect(passcode);
                return a;
            }
        }
        throw new IllegalStateException("The account with the given serial number doesn't exists");
    }

    public boolean accountAlreadyExists(final String serialNumber) {
        for (Account a : accountsRegister) {
            if (a.doesSerialNumberExists(serialNumber)) {
                return true;
            }
        }
        return false;
    }

    public final double withdraw(final double amount, final String serialNumber, final int passcode) {
        Account a = findAccount(serialNumber, passcode);
        a.withdraw(amount);
        return amount;
    }

    public final double depositMoney(final double amount, final String serialNumber, final int passcode) {
        Account a = findAccount(serialNumber, passcode);
        a.deposit(amount);
        return amount;
    }

    public final void reset(final String serialNumber, final int passcode) {
        Account a = findAccount(serialNumber, passcode);
        a.reset();
    }

    public final String showAccountState(final String serialNumber, final int passcode) {
        Account a = findAccount(serialNumber, passcode);
        return a.toString();
    }
}
