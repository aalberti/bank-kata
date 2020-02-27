package aa.kata.bank;

class Account {
    private final Balance balance;
    private final History history;

    Account() {
        balance = new Balance(new Amount(0));
        history = new History(new AccountCreationEvent());
    }

    private Account(Balance balance, History history) {
        this.balance = balance;
        this.history = history;
    }

    Balance balance() {
        return balance;
    }

    Account deposit(Amount amount) {
        Balance balanceAfter = balance.add(amount);
        return new Account(balanceAfter, history.logDeposit(balance, balanceAfter));
    }

    Account withdraw(Amount amount) {
        return new Account(balance.remove(amount), history);
    }

    History history() {
        return history;
    }
}
