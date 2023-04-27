package org.nejrasm.zadaca5oop.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BonusMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final List<Account> listOfAccounts = new ArrayList<>(2);
        final AccountsRegister accountsRegister = new AccountsRegister(listOfAccounts);
        final ATM atm = new ATM(accountsRegister);

        try {
            userInputAccounts.createAccount(accountsRegister, scanner);
            userInputAccounts.createAccount(accountsRegister, scanner);

            while (true) {
                OptionsToPerform.options();
                int entry = scanner.nextInt();

                switch (entry) {
                    case 1:
                        serialNumberAndPasscodeEntry entry1 = new serialNumberAndPasscodeEntry(scanner);
                        Account accountForDeposit = accountsRegister.findAccount(entry1.getSerialNumber(), entry1.getPasscode());
                        System.out.println("Please enter the amount you would like to deposit:");
                        double amountToDeposit = scanner.nextInt();
                        accountForDeposit.deposit(amountToDeposit);
                        break;
                    case 2:
                        serialNumberAndPasscodeEntry entry2 = new serialNumberAndPasscodeEntry(scanner);
                        Account accountForWithdraw = accountsRegister.findAccount(entry2.getSerialNumber(), entry2.getPasscode());
                        System.out.println("Please enter the amount you would like to withdraw:");
                        double amountToWithdraw = scanner.nextInt();
                        accountForWithdraw.withdraw(amountToWithdraw);
                        break;
                    case 3:
                        serialNumberAndPasscodeEntry entry3 = new serialNumberAndPasscodeEntry(scanner);
                        Account accountToReset = accountsRegister.findAccount(entry3.getSerialNumber(), entry3.getPasscode());
                        accountToReset.reset();
                        break;
                    case 4:
                        serialNumberAndPasscodeEntry entry4 = new serialNumberAndPasscodeEntry(scanner);
                        Account accountToShow = accountsRegister.findAccount(entry4.getSerialNumber(), entry4.getPasscode());
                        System.out.println(accountToShow.toString());
                        break;
                    default:
                        System.out.println("Exiting program.");
                        System.exit(0);
                }
            }
        } catch (final IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }
}

