package projects.bank;

public class Account {
    String id;
    String ownerName;
    double balance;
    AccountType type;

    public Account(String idValue, String owner, double bal, 
    AccountType typeValue)  {
        if (idValue == null) {
            throw new IllegalArgumentException(
                "idValue cannot be null."
            );
        }
        if (owner == null) {
            throw new IllegalArgumentException(
                "owner cannot be null."
            );    
        }
        if (typeValue == null) {
            throw new IllegalArgumentException(
                "typeValue cannot be null."
            );
        }
        id = idValue;
        ownerName = owner;
        balance = bal;
        type = typeValue;
    }

    public String getId() { return id; }
    public String getownerName() { return ownerName; }
    public double getbalance() { return balance; }
    public AccountType getType() { return type; }

    // stripped-down version of 'equals' override
    // give it a similar sounding name
    public boolean sameAs(Account other) {
        return this.getId().equals(other.getId());
    }
}
