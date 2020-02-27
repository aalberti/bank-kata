package aa.kata.bank;

class Account {
    private final Balance balance;

    Account() {
        balance = new Balance(new Amount(0));
    }

    private Account(Balance balance) {
        this.balance = balance;
    }

    Balance balance() {
        return balance;
    }

    Account deposit(Amount amount) {
        return new Account(new Balance(amount));
    }
}
