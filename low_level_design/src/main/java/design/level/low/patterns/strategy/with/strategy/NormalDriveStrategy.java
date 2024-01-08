package design.level.low.patterns.strategy.with.strategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal Drive Strategy.");
    }
}
