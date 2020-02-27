package aa.kata.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
    @Test
    void new_account_is_empty() {
        Account account = new Account();
        assertThat(account.balance())
                .isEqualTo(new Balance(new Amount(0)));
    }

    @Test
    void add_first_deposit_to_balance() {
        Account account = new Account();
        account = account.deposit(new Amount(10));
        assertThat(account.balance())
                .isEqualTo(new Balance(new Amount(10)));
    }

    @Test
    void add_subsequent_deposits_to_balance() {
        Account account = new Account();
        account = account.deposit(new Amount(1));
        account = account.deposit(new Amount(1));
        assertThat(account.balance())
                .isEqualTo(new Balance(new Amount(2)));
    }

    @Test
    void withdraw() {
        Account account = new Account();
        account = account.deposit(new Amount(1));
        account = account.withdraw(new Amount(1));
        assertThat(account.balance())
                .isEqualTo(new Balance(new Amount(0)));
    }

    @Test
    void log_account_creation() {
        Account account = new Account();
        assertThat(account.history())
                .isEqualTo(new History(new AccountCreationEvent(account)));
    }
}
