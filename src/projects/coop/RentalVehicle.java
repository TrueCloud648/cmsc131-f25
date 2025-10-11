package projects.bank;

public class RentalVehicle extends RentalItem {

    public RentalVehicle(String id, String owner) {
        super(id, owner);
    }

    @Override
    public RentalItemType getType() {
        return RentalItemType.VEHICLE;
    }

}
