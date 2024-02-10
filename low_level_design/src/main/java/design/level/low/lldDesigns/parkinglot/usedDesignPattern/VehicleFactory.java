package design.level.low.lldDesigns.parkinglot.usedDesignPattern;

import design.level.low.lldDesigns.parkinglot.domain.Bike;
import design.level.low.lldDesigns.parkinglot.domain.Bus;
import design.level.low.lldDesigns.parkinglot.domain.Car;
import design.level.low.lldDesigns.parkinglot.domain.Vehicle;

public class VehicleFactory {

    public static Vehicle getVehicleObj(String str, String numberPlate){
        if(str.equalsIgnoreCase("car"))
            return new Car(numberPlate);
        else if(str.equalsIgnoreCase("bike")){
            return new Bike(numberPlate);
        }else if(str.equalsIgnoreCase("bus"))
            return new Bus(numberPlate);
        else
            throw new RuntimeException("Unknown Vehicle type.");
    }
    private VehicleFactory(){
    }
}
