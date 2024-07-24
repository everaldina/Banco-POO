package bank.core;

import bank.client.Client;
import bank.exceptions.IllegalAmountException;
import bank.utils.Utils;

public abstract class Account implements IAccount{
    protected String number;
    protected String agency;
    protected double balance;
    protected Client owner;

    private static int accountCounter = 0;
    private static int DIGITS_OF_ACCOUNT_NUMBER = 6;

    
    public Account(String agency, Client owner) {
        this.agency = agency;
        this.owner = owner;
        this.balance = 0;

        this.number = generateAccountNumber();
    }

    // TODO: equals and hashcode metods
    
    @Override
    public void deposit(double amount) throws IllegalAmountException {
        if (amount <= 0)
            throw new IllegalAmountException("Amount must be greater than 0");
        else
            this.balance += amount;
        System.out.println("Deposit of " + amount + " made successfully");
        
    }

    @Override
    public void printBalance() {
        System.out.println("Balance: " + Utils.formatBrazillianCurrency(this.balance));
    }

    @Override
    public void transfer(double amount, IAccount destination) throws IllegalAmountException {
        if (amount <= 0)
            throw new IllegalAmountException("Amount must be greater than 0");
        if (amount > this.balance)
            throw new IllegalAmountException("Insufficient funds");
        else{
            this.balance -= amount;
            destination.deposit(amount);
            System.out.println("Transfer of " + amount + " made successfully");
        } 
    }

    @Override
    public void withdraw(double amount) throws IllegalAmountException {
        if (amount <= 0)
            throw new IllegalAmountException("Amount must be greater than 0");
        if (amount > this.balance)
            throw new IllegalAmountException("Insufficient funds");
        else
            this.balance -= amount;
        System.out.println("Withdraw of " + amount + " made successfully");
    }

    


    @Override
    public String toString() {
        return "Account [number=" + number + 
                ", agency=" + agency + 
                ", balance=" + Utils.formatBrazillianCurrency(balance) + 
                ", owner=" + owner + "]";
    }

    private static String generateAccountNumber(){
        String numberString = String.valueOf(accountCounter++);
        int sizeOfNumber = numberString.length();
        String result = "";

        for (int i = 0; i < DIGITS_OF_ACCOUNT_NUMBER - sizeOfNumber; i++) {
            result += "0";
        }

        return result + numberString;
    }

    public String getNumber() {
        return number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public double getBalance() {
        return balance;
    }

    public Client getOwner() {
        return owner;
    }

}
