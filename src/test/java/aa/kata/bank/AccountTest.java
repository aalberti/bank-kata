package aa.kata.bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountTest {
    @Mock
    Calendar calendar;

    @Test
    void new_account_is_empty() {
        Account account = new Account(calendar);
        assertThat(account.balance())
                .isEqualTo(new Balance(new Amount(0)));
    }

    @Test
    void add_first_deposit_to_balance() {
        Account account = new Account(calendar);

        account = account.deposit(new Amount(10));

        assertThat(account.balance())
                .isEqualTo(new Balance(new Amount(10)));
    }

    @Test
    void add_subsequent_deposits_to_balance() {
        Account account = new Account(calendar);

        account = account.deposit(new Amount(1));
        account = account.deposit(new Amount(1));

        assertThat(account.balance())
                .isEqualTo(new Balance(new Amount(2)));
    }

    @Test
    void withdraw() {
        Account account = new Account(calendar);

        account = account.deposit(new Amount(1));
        account = account.withdraw(new Amount(1));

        assertThat(account.balance())
                .isEqualTo(new Balance(new Amount(0)));
    }

    @Test
    void log_account_creation() {
        when(calendar.today())
                .thenReturn(LocalDate.of(2020, 1, 1));

        Account account = new Account(calendar);

        assertThat(account.history())
                .isEqualTo(new History(calendar,
                        new AccountCreationEvent(LocalDate.of(2020, 1, 1))
                ));
    }

    @Test
    void log_deposit() {
        when(calendar.today())
                .thenReturn(LocalDate.of(2020, 1, 1))
                .thenReturn(LocalDate.of(2020, 2, 2));
        Account account = new Account(calendar);

        account = account.deposit(new Amount(1));

        assertThat(account.history())
                .isEqualTo(new History(calendar,
                        new AccountCreationEvent(LocalDate.of(2020, 1, 1)),
                        new DepositEvent(
                                LocalDate.of(2020, 2, 2),
                                new Balance(new Amount(0)),
                                new Amount(1),
                                new Balance(new Amount(1))
                        )
                ));
    }

    @Test
    void log_withdrawal() {
        when(calendar.today())
                .thenReturn(LocalDate.of(2020, 1, 1))
                .thenReturn(LocalDate.of(2020, 2, 2))
                .thenReturn(LocalDate.of(2020, 3, 3));
        Account account = new Account(calendar);

        account = account.deposit(new Amount(2));
        account = account.withdraw(new Amount(1));

        assertThat(account.history())
                .isEqualTo(new History(calendar,
                        new AccountCreationEvent(LocalDate.of(2020, 1, 1)),
                        new DepositEvent(
                                LocalDate.of(2020, 2, 2),
                                new Balance(new Amount(0)),
                                new Amount(2),
                                new Balance(new Amount(2))
                        ),
                        new WithdrawalEvent(
                                LocalDate.of(2020, 3, 3),
                                new Balance(new Amount(2)),
                                new Amount(1),
                                new Balance(new Amount(1))
                        )
                ));
    }
}
