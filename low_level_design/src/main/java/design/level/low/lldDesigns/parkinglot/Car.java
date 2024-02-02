package design.level.low.lldDesigns.parkinglot;

public class Car extends Vehicle{

    private static final int requireSlotSize=1;

    public Car(String licensePlate) {
        super(licensePlate, Constants.CAR.getSlotSize(),Constants.CAR.getType());
    }
}
