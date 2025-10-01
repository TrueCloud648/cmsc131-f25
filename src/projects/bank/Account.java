package projects.bank;

public class Account {
    String ID; // TODO camelCase should use lowercase first letter
    String ownerName; // correct camelCase variable name
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

    public String getID() { return ID; }
    public String getownerName() { return ownerName; }
    public double getbalance() { return balance; }

    // stripped-down version of 'equals' override
    // give it a similar sounding name
    public boolean sameAs(Account other) {
        return this.getID().equals(other.getID());
    }
}
