package design.level.low.lldDesigns.parkinglot;

import design.level.low.lldDesigns.parkinglot.service.ParkingSlot;
import design.level.low.lldDesigns.parkinglot.domain.*;
import design.level.low.lldDesigns.parkinglot.usedDesignPattern.PriceFactory;
import design.level.low.lldDesigns.parkinglot.usedDesignPattern.VehicleFactory;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static ParkingSlot parkingSlot;
    public static void main(String[] args) throws InterruptedException {
        parkingSlot= new ParkingSlot();
        ParkingFullMessage message = new ParkingFullMessage();
        parkingSlot.addObserver(message);
        parkingServiceInitializer();
    }

    public static void parkingServiceInitializer(){

        boolean parkingHaveSpace=true;
        while(parkingHaveSpace) {
            Scanner sc = new Scanner(System.in);
            if (parkingSlot.isFull()) {
                System.out.println("For UnParking ! Please enter your  ticket Number: ");
                String ticketNo = sc.nextLine();
                Vehicle vehicle = parkingSlot.unparkedVehicle(ticketNo);
                System.out.println(vehicle);
                parkingHaveSpace = true;
            } else{
                System.out.println("For Parking press 1.");
                System.out.println("For unParking press 2.");
                int ops = Integer.parseInt(sc.nextLine());
                if (ops == 1) {
                    System.out.println("Please Chose the parking type :");
                    System.out.println("for hourly enter hr");
                    System.out.println("for fixed entre fix");
                    Price price = null;
                    Vehicle vehicle = null;
                    try {
                        price = PriceFactory.getPriceType(sc.nextLine());
                        System.out.println("Please enter your vehicle number: ");
                        String licensePlateNo = sc.nextLine();
                        System.out.println("Please enter your vehicle type:");
                        String type = sc.nextLine();
                        vehicle = VehicleFactory.getVehicleObj(type, licensePlateNo);
                        System.out.println("Your Ticket No:" + generateTicket(vehicle, price));
                        System.out.println("Your parking ticket has been issued successfully. Please keep your Ticket Number secure; it will be required when exiting the parking lot.");
                        parkingSlot.parkVehicle(vehicle);
                    } catch (Exception exc) {
                        System.out.println(exc.getMessage());
                    }
                }
                if (ops == 2) {
                    System.out.println("Please enter your  ticket Number: ");
                    String ticketNo = sc.nextLine();
                    Vehicle vehicle = parkingSlot.unparkedVehicle(ticketNo);
                    System.out.println(vehicle);
                }
            }
        }
    }
    public static int generateTicket(Vehicle vehicle,Price price){
        if(parkingSlot.checkSlot(vehicle.getSize())) {
            Ticket ticket = new Ticket();
            int ticketNo = parkingSlot.getTicketNo();
            ticket.setTicketNo(++ ticketNo);
            ticket.setEntryTime(LocalDateTime.now());
            ticket.setPrice(price);
            ticket.setVehicle(vehicle);
            ticket.setLicencePlateNo(vehicle.getLicensePlate());
            parkingSlot.setTicketNo(ticketNo);
            parkingSlot.addTicketToRecord(ticket);
            return ticketNo;
        }else{
            throw new RuntimeException("Sorry No Available Slot to Park Your vehicle");
        }
    }
}
