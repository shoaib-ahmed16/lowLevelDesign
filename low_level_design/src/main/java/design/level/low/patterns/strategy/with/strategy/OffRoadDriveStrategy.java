package design.level.low.patterns.strategy.with.strategy;

public class OffRoadDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("OffRoad Drive Strategy.");
    }
}
