package aa.kata.bank;

import java.util.Objects;

class History {
    private final AccountCreationEvent accountCreationEvent;

    History(AccountCreationEvent accountCreationEvent) {
        this.accountCreationEvent = accountCreationEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(accountCreationEvent, history.accountCreationEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCreationEvent);
    }
}


