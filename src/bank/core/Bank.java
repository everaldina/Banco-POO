package bank.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bank.client.Client;
import bank.exceptions.AccountNotFoundExeption;

public class Bank {
    private String name;
    private Set<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new HashSet<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(IAccount account) {
        accounts.remove(account);
    }

    public Account getAccount(String number) throws AccountNotFoundExeption{
        try {
            return accounts.stream().filter(account -> account.getNumber().equals(number)).findFirst().get();
        } catch (Exception e) {
            throw new AccountNotFoundExeption("Account not found");
        }
    }

    public void makeCheckingAccount(String agency, Client owner, double limit) {
        CheckingAccount account = new CheckingAccount(agency, owner, limit);
        addAccount(account);
    }

    public void makeSavingsAccount(String agency, Client owner) {
        SavingsAccount account = new SavingsAccount(agency, owner);
        addAccount(account);
    }

    public void printAccounts() {
        for (IAccount account : accounts) {
            System.out.println(account);
        }
    }

}
