package design.level.low.patterns.strategy.with;

import design.level.low.patterns.strategy.with.strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy drive;
    public Vehicle(DriveStrategy drive){
        this.drive=drive;
    }
    public void drive(){
        drive.drive();
    }
}
