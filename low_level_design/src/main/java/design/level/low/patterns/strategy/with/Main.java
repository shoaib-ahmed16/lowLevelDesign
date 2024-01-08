package design.level.low.patterns.strategy.with;

public class Main {
    public  static void main(String[] args){
        Vehicle vehicle = new OffRoadCarVehicle();
        vehicle.drive();
    }
}
