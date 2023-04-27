package org.nejrasm.zadaca5oop.task;

import java.util.Scanner;

public class serialNumberAndPasscodeEntry {
    private final String serialNumber;
    private final int passcode;

    public serialNumberAndPasscodeEntry(Scanner scanner) {
        System.out.println("Please enter the serial number:");
        this.serialNumber = scanner.next();
        System.out.println("Please enter passcode:");
        this.passcode = scanner.nextInt();
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public int getPasscode() {
        return this.passcode;
    }
}

