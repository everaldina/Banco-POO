package bank.core;

import bank.client.Client;
import bank.exceptions.IllegalAmountException;

public class SavingsAccount extends Account{

    public SavingsAccount(String agency, Client owner) {
        super(agency, owner);
    }

    @Override
    public void pay(double amount) throws IllegalAmountException {
        if (amount <= 0)
            throw new IllegalAmountException("Amount must be greater than 0");
        if (amount > this.balance)
            throw new IllegalAmountException("Insufficient funds");
        else{
            this.balance -= amount;
            System.out.println("Payment of " + amount + " made successfully");
        }
    }

}
