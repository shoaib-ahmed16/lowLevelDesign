package design.level.low.lldDesigns.parkinglot;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingSlot {
    private final int totalParkingSlot;
    private int vacantParkingSlot;
    private int occupiedParkingSlot;

    private static int ticketNo=0;
    private Map<Integer,Ticket> ticketNumber;
    private List<Vehicle> parkedVehicle;

    public  ParkingSlot(){
        this.totalParkingSlot=Constants.ParkingSpace.getSlotSize();
        this.vacantParkingSlot=Constants.ParkingSpace.getSlotSize();
        ticketNumber= new HashMap<>();
        parkedVehicle = new ArrayList<>();
        parkingServiceInitializer();
    }
    public void parkingServiceInitializer(){
        boolean parkingHaveSpace=true;
        while(parkingHaveSpace){
            Scanner sc= new Scanner(System.in);
            System.out.println("For parking press 1.");
            System.out.println("For Leaving press 2.");
            int ops=Integer.parseInt(sc.nextLine());
            if(ops==1){
                System.out.println("Please Chose the parking type :");
                System.out.println("for hourly enter hr");
                System.out.println("for fixed entre fix");
                Price price=null;
                Vehicle vehicle=null;
                try{
                    price=PriceFactory.getPriceType(sc.nextLine());
                    System.out.println("Please enter your vehicle number: ");
                    String licensePlateNo=sc.nextLine();
                    System.out.println("Please enter your vehicle type:");
                    String type=sc.nextLine();
                    vehicle= VehicleFactory.getVehicleObj(type,licensePlateNo);
                    System.out.println("Your Ticket No:"+generateTicket(vehicle,price));
                    System.out.println("Your parking ticket has been issued successfully. Please keep your Ticket Number secure; it will be required when exiting the parking lot.");

                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }
            }
            if(ops==2){

            }
            if(occupiedParkingSlot>=totalParkingSlot){
                System.out.println("Parking is fully Occupied. Sorry For the inconvenience");
                parkingHaveSpace=false;
            }
        }
    }

    public int generateTicket(Vehicle vehicle,Price price){
        Ticket ticket =new Ticket();
        ticket.setTicketNo(++ticketNo);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setPrice(price);
        ticket.setVehicle(vehicle);
        ticket.setLicencePlateNo(vehicle.getLicensePlate());
        ticketNumber.put(ticketNo,ticket);
        return ticketNo;
    }
    public String parkVehicle(Vehicle vehicle){
        return "hello";
    }



}
