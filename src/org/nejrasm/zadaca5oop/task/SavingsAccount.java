package org.nejrasm.zadaca5oop.task;

import java.util.Scanner;

public class SavingsAccount extends Account {
    private int dailyTransactionsLimit;
    private int maximumNumberOfTransactions;
    private int numberOfTransactionsLeft;
    private double withdrownMoney = 0;

    public SavingsAccount(final Owner owner, final String serialNumber, final int passcode, final double balance) {
        this(owner, serialNumber, passcode, balance, 1000);
    }

    public SavingsAccount(final Owner owner, final String serialNumber, final int passcode, final double balance, final int dailyTransactionsLimit) throws IllegalArgumentException {
        super(owner, serialNumber, passcode, balance);
        this.dailyTransactionsLimit = dailyTransactionsLimit;
        this.maximumNumberOfTransactions = 3;
        this.numberOfTransactionsLeft = 3;
    }

    public SavingsAccount(final Owner owner, Scanner scanner) {
        super(owner,scanner);
    }

    private boolean maximumOfTransactionsReached() {
        if (numberOfTransactionsLeft == 0) {
            throw new IllegalStateException("You have reached your daily transaction limit!");
        } else {
            numberOfTransactionsLeft -= 1;
        }
        return numberOfTransactionsLeft >= 0;
    }

    private boolean dailyTransactionLimitReached(double amount) {
        if (withdrownMoney > this.dailyTransactionsLimit) {
            throw new IllegalStateException("You have reached your daily amount limit!");
        } else {
            this.dailyTransactionsLimit -= amount;
            withdrownMoney += amount;
        }
        return withdrownMoney < this.dailyTransactionsLimit;
    }

    private boolean balanceLeft(final double amount) {
        if (amount > this.getBalance()) {
            throw new IllegalStateException("You don't have enough balance to perform this transaction!");
        }
        return amount < this.getBalance();
    }

    private boolean transactionsChecker(final double amount) {
        return (dailyTransactionLimitReached(amount) && maximumOfTransactionsReached());
    }

    @Override
    public void withdraw(final double amount) {
        if (transactionsChecker(amount) && balanceLeft(amount)) {
            this.setBalance(this.getBalance() - amount);
        }
    }

    @Override
    public void deposit(final double amount) {
        if (this.maximumOfTransactionsReached()) {
            this.setBalance(this.getBalance() + amount);
        }
    }

    @Override
    public void reset() {
        this.dailyTransactionsLimit = 1000;
        this.numberOfTransactionsLeft = 3;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCurrent daily limit: {" + this.dailyTransactionsLimit + "}, NumberOfAvailableTransaction: {" + this.numberOfTransactionsLeft + "}";
    }
}

