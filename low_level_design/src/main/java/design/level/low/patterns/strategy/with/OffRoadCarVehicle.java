package design.level.low.patterns.strategy.with;

import design.level.low.patterns.strategy.with.strategy.OffRoadDriveStrategy;

public class OffRoadCarVehicle extends Vehicle{
    public OffRoadCarVehicle() {
        super(new OffRoadDriveStrategy());
    }
}
