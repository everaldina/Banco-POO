# Bank System
A simple bank system made in Java that allows users to create accounts, make transactions.

## Features
### Create account
- There are two types of accounts: `Savings` and `Cashing`
- `Cashing` account has a overdraft limit, while `Savings` account does not
### Deposit money
- Deposit money to the account
### Withdraw money
- Withdraw money from the account
- Checks if the amount is valid
### Transfer money
- Transfer money to another account
- Checks if the amount is valid
### Check balance
- Check the balance of the account
- Uses custom currency format (e.g. `R$ 1000.00`)
### Pay bills
- Pay bills using the account
- Checks if the amount is valid
- `Cashing` account can pay bills even if the balance is negative
