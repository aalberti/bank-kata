package aa.kata.bank;

import java.util.Objects;

public class Balance {
    private final Amount amount;

    Balance(Amount amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return Objects.equals(amount, balance.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
