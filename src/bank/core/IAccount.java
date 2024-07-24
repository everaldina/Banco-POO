package bank.core;

import bank.exceptions.IllegalAmountException;

public interface IAccount {
    void deposit(double amount) throws IllegalAmountException;
    void withdraw(double amount) throws IllegalAmountException;
    void transfer(double amount, IAccount destination) throws IllegalAmountException;
    void printBalance();

    void pay(double amount) throws IllegalAmountException;
}
