package projects.bank;

import java.lang.reflect.Array;

public class Bank {

    private Account[] accounts;
    private int idxNextAccount;
    private final int newAccountsIncrement = 100;

    public Bank() {
        accounts = new Account[newAccountsIncrement];
    }

    public boolean add (Account acct) {
        if (acct == null) {
            throw new IllegalArgumentException(
                "Account cannot be null."
            );
        }
        if (find(acct.getID()) == -1) {
            try {accounts[idxNextAccount] = acct;
            } catch(ArrayIndexOutOfBoundsException e) {
                Account[] accountsExtended = new Account[
                    accounts.length + newAccountsIncrement
                ];
                for (int idx = 0; idx < accounts.length; idx++) {
                    accountsExtended[idx] = accounts[idx];
                }
                accountsExtended[idxNextAccount] = acct;
                accounts = accountsExtended;
            }
            idxNextAccount++;
            return true;
        } else {
            return false;
        }
    }

    public int find(String accountID) {
        if (accountID == null) {
            throw new IllegalArgumentException(
                "AccountID cannot be null."
            );
        }
        for (int idxAcct = 0; idxAcct < idxNextAccount; idxAcct++) {
            if (accounts[idxAcct].getID().equals(accountID)) {
                return idxAcct;
            }
        }
        return -1;
    }

    public int getCount() {
        return idxNextAccount;
    }
}