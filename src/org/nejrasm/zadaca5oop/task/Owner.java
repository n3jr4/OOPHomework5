package org.nejrasm.zadaca5oop.task;

import java.util.Scanner;

public class Owner {
    private final String firstName;
    private final String lastName;
    private final String address;

    public Owner(final String firstName, final String lastName, final String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Owner (Scanner scanner){
        System.out.println("Please enter the first name:");
        this.firstName = scanner.next();
        System.out.println("Please enter the last name:");
        this.lastName = scanner.next();
        System.out.println("Please enter the address:");
        this.address = scanner.next();
    }

    @Override
    public final String toString() {
        return "First name: {" + this.firstName + "}, Last name: {" + this.lastName + "} , Address: {" + this.address + "}";
    }
}
