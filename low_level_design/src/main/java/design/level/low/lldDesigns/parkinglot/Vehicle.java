package design.level.low.lldDesigns.parkinglot;

public class Vehicle {
    private String licensePlate;
    private int size;
    private String type;

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
    public String getLicensePlate() {

        return licensePlate;
    }


    public Vehicle(String licensePlate, int size,String type){
        this.licensePlate=licensePlate;
        this.size=size;
        this.type=type;
    }

}
