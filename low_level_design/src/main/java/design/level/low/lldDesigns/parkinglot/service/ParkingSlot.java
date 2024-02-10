package design.level.low.lldDesigns.parkinglot.service;

import design.level.low.lldDesigns.parkinglot.domain.*;
import design.level.low.lldDesigns.parkinglot.usedDesignPattern.ParkingLotObserver;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ParkingSlot {
    private final int totalParkingSlot;
    private int vacantParkingSlot;
    private int occupiedParkingSlot;

    private int ticketNo=0;

    private Map<String, Ticket> parkingTicketRecords;
    private Set<Vehicle> parkedVehicle;

    private List<ParkingLotObserver> observers = new ArrayList<>();

    public int getTotalParkingSlot() {
        return totalParkingSlot;
    }

    public int getVacantParkingSlot() {
        return vacantParkingSlot;
    }


    public int getOccupiedParkingSlot() {
        return occupiedParkingSlot;
    }

    public  int getTicketNo() {
        return this.ticketNo;
    }

    public  void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }


    public Set<Vehicle> getParkedVehicle() {
        return parkedVehicle;
    }

    public void addObserver(ParkingLotObserver observer) {
        observers.add(observer);
    }

    public  ParkingSlot(){
        this.totalParkingSlot= Constants.ParkingSpace.getSlotSize();
        this.vacantParkingSlot=Constants.ParkingSpace.getSlotSize();
        parkingTicketRecords= new HashMap<>();
        parkedVehicle = new HashSet<>();

    }
    public void addTicketToRecord(Ticket ticket){
        parkingTicketRecords.put(String.valueOf(ticket.getTicketNo()),ticket);
    }
    public Ticket  removeTicketToRecord(String ticketNo){
       return parkingTicketRecords.remove(ticketNo);
    }

    private void notifyObservers(){
        for (ParkingLotObserver observer : observers) {
            observer.parkingLotFull();
        }
    }
    public String parkVehicle(Vehicle vehicle){
            parkedVehicle.add(vehicle);
            this.occupiedParkingSlot+=vehicle.getSize();
            this.vacantParkingSlot-=vehicle.getSize();
            if (isFull()) {
                notifyObservers();
            }
            return "Your Vehicle No: +" +vehicle.getLicensePlate() +" is successfully parked " ;
    }

    public Vehicle unparkedVehicle(String ticketNo){
        Ticket ticket=null;
        if(!parkingTicketRecords.containsKey(ticketNo)){
            System.out.println("No record Found for this Parking ticket");
            return null;
        }else{
            ticket =removeTicketToRecord(ticketNo);
            ticket.setExitTime(LocalDateTime.now());
            Vehicle vehicle =ticket.getVehicle();
            parkedVehicle=parkedVehicle.stream().dropWhile(p->p.getLicensePlate().equals(vehicle.getLicensePlate())).collect(Collectors.toSet());
            this.vacantParkingSlot+=vehicle.getSize();
            this.occupiedParkingSlot-=vehicle.getSize();
            return vehicle;
        }
    }

    public boolean isFull(){
        return this.getOccupiedParkingSlot() >= this.getTotalParkingSlot();
    }

    public boolean checkSlot(int size){
        return (this.vacantParkingSlot-size>=0);
    }

}
