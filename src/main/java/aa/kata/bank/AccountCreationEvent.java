package aa.kata.bank;

import java.util.Objects;

class AccountCreationEvent {
    private final Account account;

    AccountCreationEvent(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCreationEvent that = (AccountCreationEvent) o;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }
}
