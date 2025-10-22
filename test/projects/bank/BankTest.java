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

    @Test
    void testLoadAccounts() {
        String accountsFilename = "data/testaccounts.csv";
        boolean result = bank.loadAccounts(accountsFilename);
        assertEquals(
            true,
            result
        );
        Account[] accounts = bank.getAccounts();
        assertEquals(
            2,
            bank.getCount()
        );

        // check validity of stored rental item
        Account account = accounts[0];
        assertEquals(
            "wz240833",
            account.getId()
        );
        assertEquals(
            "Anna Gomez",
            account.getownerName()
        );
        assertEquals(
            AccountType.SAVINGS,
            account.getType()
        );
        assertEquals(
            8111.00,
            account.getBalance(),
            1e-2
        );

        account = accounts[1];
        assertEquals(
            "hr108256",
            account.getownerName()
        );
        assertEquals(
            AccountType.CHECKING,
            account.getType()
        );
        assertEquals(
            1715.18,
            account.getbalance(),
            1e-2
        );
    } //ending testLoadAccounts

    @Test
    void testWriteAccountsFail() {
        assertEquals(false, bank.writeAccounts("not/a/real.file"));
    }

    @Test
    void testWriteAccounts() {
        String accountsFilename = "data/testaccounts.csv";
        boolean result = bank.loadAccounts(accountsFilename);
        assertEquals(true, result);

        accountsFilename = "data/testaccounts-out.csv";
        bank.writeAccounts(accountsFilename);

        Bank bankReload = new Bank();
        bankReload.loadAccounts(accountsFilename);

        assertEquals(bank.getCount(), bankReload.getCount());

        Account[] bankAccounts = bank.getAccounts();
        Account[] bankReloadAccounts = bank.getAccounts();
        assertEquals(bankAccounts.length, bankReloadAccounts.length);
        fpr (int idx = 0; idx < bank.getCount(); idx++) {
            assertEquals(
                bankAccounts[idx],
                bankReloadAccounts[idx],
                String.format("Rental item percents should match.", idx)
            );
        }
    }

    @Test
    void testProcessTransactionsFailure() {


    }

    @Test
    void testProcessTransactionsSuccess() {

        
    }

} // end: class BankTest
