package org.nejrasm.zadaca5oop.task;

public class Owner {
    private final String firstName;
    private final String lastName;
    private final String address;

    public Owner(final String firstName, final String lastName, final String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public final String toString() {
        return "First name: {" + this.firstName + "}, Last name: {" + this.lastName + "} , Address: {" + this.address + "}";
    }
}
