public class Account {
    String ID;
    String ownerName;
    double balance;
    AccountType type;

    public Account(
    String idValue,
    String owner,
    double bal,
    AccountType typeValue
    )  {
        // TODO: Validate that String parameters are not null
        ID = idValue;
        ownerName = owner;
        balance = bal;
        type = typeValue;
    }

    public String getID() { return accountID; }

    // stripped-down version of 'equals' override
    // give it a similar sounding name
    public boolean sameAs(Account other) {
        return this.GetID().equals(other.getID())
    }
}
