package projects.bank;

public class RentalTool extends RentalItem {

    public RentalTool(String id, String owner) {
        super(id, owner);
    }

    @Override
    public RentalItemType getType() {
        return RentalItemType.TOOL;
    }
    
}
