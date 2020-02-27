package aa.kata.bank;

class Account {
    private final Balance balance;

    Account() {
        balance = new Balance(new Amount(0));
    }

    Balance balance() {
        return balance;
    }
}
