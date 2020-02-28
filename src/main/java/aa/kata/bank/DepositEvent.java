package aa.kata.bank;

import java.time.LocalDate;
import java.util.Objects;

class DepositEvent implements AccountEvent {
    private LocalDate date;
    private final Balance before;
    private final Balance after;

    DepositEvent(LocalDate date, Balance before, Amount amount, Balance after) {
        this.date = date;
        this.before = before;
        this.after = after;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepositEvent that = (DepositEvent) o;
        return date.equals(that.date) &&
                before.equals(that.before) &&
                after.equals(that.after);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, before, after);
    }
}
