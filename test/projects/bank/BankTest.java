package projects.bank;

import static org.junit.jupiter.api.Assertions.*;
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
    void testAddDataValidation() {
        Exception e = assertThrows(
        IllegalArgumentException.class,
        () -> {bank.add(null);}
        );
        assertEquals("Account must not be null.", e.getMessage());
    }

    @Test
    void testAddAccount() {
        // add account that's absent from bank's accounts
        boolean addAccountResult = bank.add(acct);
        assertEquals(
            true,
            addAccountResult,
            "bank.add should return true."
        );
        assertEquals(
            1,
            bank.getCount(),
            "bank.getCount should be 1."
        );

        // add account that's present in bank's accounts (no effect)
        addAccountResult = bank.add(acct);
        assertEquals(
            false,
            addAccountResult,
            "bank.add should return false."
        );
        assertEquals(
            1,
            bank.getCount(),
            "bank.getCount should still be 1."
        );
    }

    @Test
    void testAddAccountOverflow() {
        for (int idx = 0; idx <= 100; idx++) {
            Integer id = idx;
            bank.add(
                new Account(
                    id.toString(),
                    "Owner Name",
                    1.0,
                    AccountType.CHECKING
                )
            );
        }

        assertEquals(
            101,
            bank.getCount(),
            "bank should hold 101 accounts."
        );
    }

    @Test
    void testFindDataValidation() {
        Exception e = assertThrows(
            IllegalArgumentException.class,
            () -> {bank.find(null);}
        );
        assertEquals("accountID must not be null.", e.getMessage());
    }

    @Test
    void testFind() {
        // add account and check its returned value
        bank.add(acct);
        assertEquals(
            0,
            bank.find(acct.getID()),
            "acct should be at index 0."
        );
        // check returned value for account not in bank
        assertEquals(
            -1,
            bank.find("id1"),
            "Result should be -1 when finding absent account."
        );
    }

} // end: class BankTest
