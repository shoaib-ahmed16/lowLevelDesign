package design.level.low.patterns.strategy.with;

import design.level.low.patterns.strategy.with.strategy.DriveStrategy;
import design.level.low.patterns.strategy.with.strategy.OffRoadDriveStrategy;
import design.level.low.patterns.strategy.with.strategy.SportDriveStrategy;

public class OffRoadCarVehicle extends Vehicle{
    public OffRoadCarVehicle() {
        super(new OffRoadDriveStrategy());
    }
}
