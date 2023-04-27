package org.nejrasm.zadaca5oop.task;

import java.util.Scanner;

public abstract class Account {
    private final Owner owner;
    private final String serialNumber;
    private final int passcode;
    private double balance;

    public Account(final Owner owner, final String serialNumber, final int passcode, final double balance) throws IllegalArgumentException {
        isPasscodeInRange(passcode);
        this.owner = owner;
        this.serialNumber = serialNumber;
        this.passcode = passcode;
        this.balance = balance;

    }

    public Account(final Owner owner, Scanner scanner) throws IllegalArgumentException {
        this.owner = owner;
        System.out.println("Enter the serial number for account:");
        this.serialNumber = scanner.next();
        System.out.println("Enter the passcode for account:");
        this.passcode = scanner.nextInt();
        isPasscodeInRange(this.passcode);
        System.out.println("Enter the balance of the account:");
        this.balance = scanner.nextInt();
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(final double newBalance) {
        this.balance = newBalance;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    abstract public void withdraw(final double amount);

    abstract public void deposit(final double amount);

    abstract public void reset();

    public void isPasscodeInRange(final int passcode) {
        if (passcode < 1000 || passcode > 9999) {
            throw new IllegalStateException("Password needs to be in range from 1000 to 99999!");
        }
    }

    public void isPasscodeCorrect(final int passcode) {
        if (!(passcode == this.passcode)) {
            throw new IllegalStateException("Incorrect password provided!");
        }
    }

    public boolean doesSerialNumberExists(final String serialNumber) {
        return this.serialNumber.equals(serialNumber);
    }

    @Override
    public String toString() {
        return owner.toString() + ",\nCurrent balance: {" + this.balance + "}";
    }
}

