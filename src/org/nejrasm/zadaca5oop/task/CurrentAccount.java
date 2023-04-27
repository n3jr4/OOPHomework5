package org.nejrasm.zadaca5oop.task;

public class CurrentAccount extends Account {

    public CurrentAccount(final Owner owner, final String serialNumber, final int passcode, final double balance) throws IllegalArgumentException {
        super(owner, serialNumber, passcode, balance);
    }

    @Override
    public void withdraw(final double amount) {
        this.setBalance(this.getBalance() - amount);
    }

    @Override
    public void deposit(final double amount) {
        this.setBalance(this.getBalance() + amount);
    }

    @Override
    public void reset() {
    }
}

