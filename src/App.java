import bank.core.Account;
import bank.core.Bank;
import bank.utils.Gender;

import java.time.LocalDate;

import bank.client.Client;

public class App {

    public static void showBalances(Account [] accounts) {
        System.out.println("printing balance");
        for (Account account : accounts) {
            account.printBalance();
        }
    }
    public static void main(String[] args) throws Exception {
        // creating a bank
        Bank bank = new Bank("Banco do Brasil");
        Bank bank2 = new Bank("Itaú");

        // creating clients
        Client client1 = new Client("João", "123.456.789-00", LocalDate.of(2010, 07, 22), Gender.FEMALE);
        Client client2 = new Client("Maria", "987.654.321-00", LocalDate.of(1990, 10, 05), Gender.MALE);
        Client client3 = new Client("Cleber", "321.456.789-00", LocalDate.of(2000, 07, 11));
        Client client4 = new Client("Marc", "122.654.321-00", LocalDate.of(1990, 10, 05));

        // creating accounts bank1
        bank.makeCheckingAccount("001", client1, 100);
        bank.makeCheckingAccount("001", client2, 100);
        bank.makeSavingsAccount("001", client2);

        // creating accounts bank2
        bank2.makeCheckingAccount("001", client3, 100);
        bank2.makeSavingsAccount("001", client4);
        bank2.makeCheckingAccount("001", client1, 100);

        // printing accounts
        System.out.println("Banco do Brasil");
        bank.printAccounts();
        System.out.println("Itau");
        bank2.printAccounts();

        Account account1 = bank.getAccount("000001");
        Account account2 = bank.getAccount("000000");
        Account account3 = bank2.getAccount("000003");
        Account account4 = bank2.getAccount("000004");

        Account [] accounts = {account1, account2, account3, account4};


        System.out.println("depositing");
        account1.deposit(200);
        account2.deposit(200);
        account3.deposit(200);
        account4.deposit(200);

        showBalances(accounts);

        System.out.println("transfering");
        account1.transfer(50, account2);
        account3.transfer(50, account4);
        account2.transfer(10, account4);


        showBalances(accounts);


        System.out.println("withdrawing");
        account1.withdraw(50);
        account4.withdraw(50);

        showBalances(accounts);


        System.out.println("paying bills");
        account1.pay(100);
        account2.pay(100);
        account3.pay(100);
        account4.pay(100);

        showBalances(accounts);

        // TODO: test overdraft in checking account
        // TODO: test wrong amount in deposit, withdraw, transfer and pay




    }
}
