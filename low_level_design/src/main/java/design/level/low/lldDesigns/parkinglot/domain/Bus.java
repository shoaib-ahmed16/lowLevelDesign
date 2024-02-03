package design.level.low.lldDesigns.parkinglot.domain;

public class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(licensePlate, Constants.BUS.getSlotSize(),Constants.BUS.getType());
    }
}
