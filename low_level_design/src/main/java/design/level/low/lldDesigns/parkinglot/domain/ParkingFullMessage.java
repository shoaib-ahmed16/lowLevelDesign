package design.level.low.lldDesigns.parkinglot.domain;

import design.level.low.lldDesigns.parkinglot.usedDesignPattern.ParkingLotObserver;

public class ParkingFullMessage implements ParkingLotObserver {
    @Override
    public void parkingLotFull() {
        System.out.println("Parking is fully Occupied. Sorry For the inconvenience");
        try {
            Thread.sleep(500);
        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}
