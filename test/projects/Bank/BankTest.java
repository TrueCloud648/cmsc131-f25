package projects.Bank;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BankTest {
    private Bank bank;
    private Account acct;

    @BeforeEach
    void setup() {
        bank = new Bank();
        acct = new Account("id0", "Owner Name", 1.0, AccountType.SAVINGS);
    }

    @Test
    void testAddAccount() {
        // add account that's absent from bank's accounts

        // add account that's present in bank's accounts (no effect)
    }

    @Test
    void testAddAccountOverflow() {}

    @Test
    void testFind() {
        // add account and check its returned value

        // check returned value for account not in bank
    }

} // end: class BankTest
