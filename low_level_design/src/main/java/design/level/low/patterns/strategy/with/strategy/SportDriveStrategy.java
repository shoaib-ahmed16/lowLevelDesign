package design.level.low.patterns.strategy.with.strategy;

public class SportDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sport Drive Strategy.");
    }
}
