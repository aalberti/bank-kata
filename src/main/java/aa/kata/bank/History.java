package aa.kata.bank;

import java.util.Arrays;

class History {
    private final AccountEvent[] events;

    History(AccountEvent... events) {
        this.events = events;
    }

    History logDeposit(Balance before, Balance after) {
        return new History(concatenate(this.events, new DepositEvent(before, after)));
    }

    History logWithdrawal(Balance before, Balance after) {
        return new History(concatenate(this.events, new WithdrawalEvent(before, after)));
    }

    private static AccountEvent[] concatenate(AccountEvent[] events, AccountEvent newEvent) {
        AccountEvent[] newEvents = new AccountEvent[events.length + 1];
        System.arraycopy(events, 0, newEvents, 0, events.length);
        newEvents[events.length] = newEvent;
        return newEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Arrays.equals(events, history.events);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(events);
    }
}


