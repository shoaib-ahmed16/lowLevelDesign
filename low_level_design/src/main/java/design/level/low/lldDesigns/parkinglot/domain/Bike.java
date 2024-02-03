package design.level.low.lldDesigns.parkinglot.domain;

public class Bike extends Vehicle {
    private static final int requireSlotSize=1;
    public Bike(String licensePlate) {

        super(licensePlate, Constants.BIKE.getSlotSize(),Constants.BIKE.getType());
    }
}
