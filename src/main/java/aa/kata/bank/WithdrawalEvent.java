package aa.kata.bank;

import java.time.LocalDate;
import java.util.Objects;

class WithdrawalEvent implements AccountEvent {
    private final Balance before;
    private final Balance after;

    WithdrawalEvent(LocalDate of, Balance before, Amount amount, Balance after) {
        this.before = before;
        this.after = after;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WithdrawalEvent that = (WithdrawalEvent) o;
        return Objects.equals(before, that.before) &&
                Objects.equals(after, that.after);
    }

    @Override
    public int hashCode() {
        return Objects.hash(before, after);
    }
}
