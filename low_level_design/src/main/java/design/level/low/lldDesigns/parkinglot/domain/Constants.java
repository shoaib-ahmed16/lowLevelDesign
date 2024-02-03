package design.level.low.lldDesigns.parkinglot.domain;

public enum Constants {
    BIKE(1,"BIKE"),
    CAR(2,"CAR"),
    BUS(4,"BUS"),
    ParkingSpace(6,"intialParkingSpace");
    private  final int slotSize;
    private final String type;
    public int getSlotSize(){
        return  this.slotSize;
    }
    public String getType(){
        return this.type;
    }
    Constants(int slotSize,String type){
        this.slotSize=slotSize;
        this.type=type;
    }
}
