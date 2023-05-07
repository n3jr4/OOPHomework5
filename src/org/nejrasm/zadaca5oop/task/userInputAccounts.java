package org.nejrasm.zadaca5oop.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userInputAccounts {
    public userInputAccounts(final ATM atm, Scanner scanner) {
    }
    public static void createAccount(final ATM atm, Scanner scanner) {
        System.out.println("Please enter the information about the the owner of account you want to create:");
        Owner owner = new Owner(scanner);
        System.out.println("Please enter the type of account you want to create: Current or Savings");
        String typeOfAccount = scanner.next().toUpperCase();
        System.out.println("Please enter the information about the the account you want to create:");
        Account account;
        switch (typeOfAccount) {
            case "CURRENT":
                account = new CurrentAccount(owner, scanner);
                atm.addAccount(account);
                break;
            case "SAVINGS":
                account = new SavingsAccount(owner, scanner);
                atm.addAccount(account);
                break;
            default:
                System.out.println("Invalid account type.");
        }
    }
}
