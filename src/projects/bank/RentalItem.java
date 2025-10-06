package projects.bank;

abstract class RentalItem {

    private final String uid;
    private final String ownerName;
    private RentalItemState itemState;

public RentalItemState getAvailability() { return itemState; }
public String getOwner() { return ownerName; }
public String getUid() { return uid; }
abstract RentalItemType getType();


    public RentalItem(String id, String owner) {
        if (id != null) {
            uid = id;
        } else {
            throw new IllegalArgumentException(
                "Parameter id cannot be null."
            );
        }
        if (owner != null) {
            ownerName = owner;
        } else {
            throw new IllegalArgumentException(
                "Parameter owner cannot be null."
            );
        }
        itemState = RentalItemState.AVAILABLE;
    }
}
