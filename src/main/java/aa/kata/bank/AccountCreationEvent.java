package aa.kata.bank;

class AccountCreationEvent implements AccountEvent {
    AccountCreationEvent() {}

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AccountCreationEvent;
    }
}
