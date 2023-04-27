package org.nejrasm.zadaca5oop.task;

import java.util.ArrayList;
import java.util.List;

public class AccountsRegister {
    private final List<Account> accountsRegister;

    public AccountsRegister(List<Account>accounts) {
        this.accountsRegister = new ArrayList<Account>(accounts);
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

    public boolean accountAlreadyExists (final String serialNumber) {
        for (Account a : accountsRegister) {
            if (a.doesSerialNumberExists(serialNumber))
                return true;
        }
        return false;
    }
}
