package design.level.low.patterns.strategy.with;

import design.level.low.patterns.strategy.with.strategy.DriveStrategy;
import design.level.low.patterns.strategy.with.strategy.NormalDriveStrategy;

public class PassengerCarVehicle extends Vehicle{
    public PassengerCarVehicle() {
        super(new NormalDriveStrategy());
    }
}
