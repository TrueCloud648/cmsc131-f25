package projects.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TODO write test coverage

public class AccountTest {

    private Account accounts;
    
    @BeforeEach
    void setupAccount() {
        accounts = new Account(
            "wz240833",
            "Anna Gomez"
            8111.00,
            AccountType.SAVINGS
        );
    }

    @Test
    void testDataValidation() {
        Exception e = assertThrows(
            IllegalArgumentException.class,
            () -> {new Account(null, "name", 0.0, AccountType.CHECKING);}
        );
        assertEquals("id cannot be null.", e.getMessage());

        e = assertThrows(
            IllegalArgumentException.class,
            () -> {new Account("id", null, 0.0, AccountType.CHECKING);}
        );
        assertEquals("ownerName cannot be null.", e.getMessage());

        e = assertThrows(
            IllegalArgumentException.class,
            () -> {new Account("id", "Owner Name", 0.0, null);}
        );
        assertEquals("Type cannot be null.", e.getMessage());
    }

    @Test
    void testMakeThrowsOnNullInput() {
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> {Account.make(null);}
        );
        assertEquals(
            "inputLine cannot be null.",
            exception.getMessage()
        );
    }

    @Test
    void testMakePreservesData() {
        Account account2 = Account.make(
            "savings,wz240833,Anna Gomez,8111.00"
        );
        assertEquals(
            accounts.getId(),
            account2.getId()
        );
        assertEquals(
            accounts.getownerName(),
            account2.getownerName()
        );
        assertEquals(
            accounts.getType(),
            account2.getType()
        );
        assertEquals(
            accounts.getbalance(),
            account2.getbalance(),
            1e-2
        );
    }

}
