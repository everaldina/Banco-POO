import bank.core.Bank;
import bank.utils.Gender;

import java.time.LocalDate;

import bank.client.Client;

public class App {
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
        bank.makeCheckingAccount("001", client2, 100);

        // creating accounts bank2
        bank2.makeCheckingAccount("001", client3, 100);
        bank2.makeCheckingAccount("001", client4, 100);
        bank2.makeCheckingAccount("001", client1, 100);

        // printing accounts
        System.out.println("Banco do Brasil");
        bank.printAccounts();
        System.out.println("Itau");
        bank2.printAccounts();


    }
}
