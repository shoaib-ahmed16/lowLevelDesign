package design.level.low.patterns.strategy.with;

import design.level.low.patterns.strategy.with.strategy.DriveStrategy;
import design.level.low.patterns.strategy.with.strategy.SportDriveStrategy;

public class SportCarVehicle extends Vehicle{
    public SportCarVehicle() {
        super(new SportDriveStrategy());
    }
}
