package bank.core;

import bank.client.Client;
import bank.exceptions.IllegalAmountException;
import bank.utils.Utils;

public class CheckingAccount extends Account {
    private double overdraft;

    public CheckingAccount(String agency, Client owner, double overdraft) {
        super(agency, owner);
        this.overdraft = overdraft;
    }

    public void printOverdraft(){
        System.out.println("Overdraft: " + Utils.formatBrazillianCurrency(overdraft));
    }

    public void changeOverdraft(double quantity) throws IllegalAmountException {
        if (overdraft - quantity < 0){
            throw new IllegalAmountException("Overdraft can't be negative");
        }else{
            this.overdraft += quantity;
            System.out.println("Overdraft changed to " + Utils.formatBrazillianCurrency(overdraft) + "successfully");
        }
    }
    
    
    
    @Override
    public void pay(double amount) throws IllegalAmountException {
        if (amount <= 0)
            throw new IllegalAmountException("Amount must be greater than 0");
        if (amount > this.balance + this.overdraft)
            throw new IllegalAmountException("Insufficient funds");
        else{
            this.balance -= amount;
            System.out.println("Payment of " + amount + " made successfully");
        }
    }

    public double getOverdraft() {
        return overdraft;
    }

    private void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }




}
