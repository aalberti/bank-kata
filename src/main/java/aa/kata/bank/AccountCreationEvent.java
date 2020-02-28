package aa.kata.bank;

import java.time.LocalDate;
import java.util.Objects;

class AccountCreationEvent implements AccountEvent {
    private LocalDate date;

    AccountCreationEvent(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCreationEvent that = (AccountCreationEvent) o;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
