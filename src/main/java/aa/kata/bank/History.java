package aa.kata.bank;

import java.util.Arrays;
import java.util.Objects;

class History {
    private Calendar calendar;
    private final AccountEvent[] events;

    History(Calendar calendar, AccountEvent... events) {
        this.calendar = calendar;
        this.events = events;
    }

    History logDeposit(Balance before, Balance after) {
        return new History(
                calendar,
                concatenate(
                        this.events,
                        new DepositEvent(calendar.today(), before, after))
        );
    }

    History logWithdrawal(Balance before, Balance after) {
        return new History(calendar, concatenate(this.events, new WithdrawalEvent(before, after)));
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
        return calendar.equals(history.calendar) &&
                Arrays.equals(events, history.events);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(calendar);
        result = 31 * result + Arrays.hashCode(events);
        return result;
    }
}


