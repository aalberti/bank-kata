package aa.kata.bank;

class Account {
    private final Balance balance;
    private final History history;

    Account(Calendar calendar) {
        balance = new Balance(new Amount(0));
        history = new History(calendar);
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
        return new Account(balanceAfter, history.logDeposit(balance, amount, balanceAfter));
    }

    Account withdraw(Amount amount) {
        Balance balanceAfter = balance.remove(amount);
        return new Account(balanceAfter, history.logWithdrawal(balance, amount, balanceAfter));
    }

    History history() {
        return history;
    }
}
