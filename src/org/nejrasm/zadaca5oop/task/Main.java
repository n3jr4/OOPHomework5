package org.nejrasm.zadaca5oop.task;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Owner Nejra = new Owner("Nejra", "Skandro", "Igmanska");
        final List<Account> listOfAccounts = new ArrayList<>();
        final AccountsRegister accountsRegister = new AccountsRegister(listOfAccounts);
        final ATM atm = new ATM(accountsRegister);

        try {
            final Account NejraCurrent = new CurrentAccount(Nejra, "TestSerial1", 1234, 100);
            final Account NejraSavings = new SavingsAccount(Nejra, "TestSerial2", 1233, 150);

            accountsRegister.addAccount(NejraCurrent);
            accountsRegister.addAccount(NejraSavings);

            NejraSavings.withdraw(100);
            NejraSavings.deposit(100);
            NejraSavings.withdraw(100);
            NejraSavings.reset();
            System.out.println(atm.showAccountState("TestSerial2", 1233));
            NejraSavings.withdraw(100);

            NejraCurrent.withdraw(200);
            NejraCurrent.deposit(100);
            NejraCurrent.withdraw(100);
            NejraCurrent.reset();
            System.out.println(atm.showAccountState("TestSerial1", 1234));

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
