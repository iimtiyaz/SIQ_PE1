
import java.util.*;
class ParkingLot {
    private static ParkingLot parkingLot_instance = null;
    // Static method to create instance of ParkingLot class
    public static ParkingLot getInstance()
    {
        if (parkingLot_instance == null)
            parkingLot_instance = new ParkingLot();
        return parkingLot_instance;
    }
    private VehicleDetails[] slots;
    private Map<String,Integer>  vehicleNumberToSlotMapping;
    private Map<Integer,Set<String>> ageToVehiclesMapping;
    private PriorityQueue<Integer> slotsAvailable;
    public void createParkingLot(int N){
        slots =new VehicleDetails[N+1];
        slotsAvailable =new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            slotsAvailable.add(i);
        }
        vehicleNumberToSlotMapping =new HashMap<>();
        ageToVehiclesMapping =new HashMap<>();
        System.out.println("Created parking of "+N+" slots");
    }
    public void park(String vehicleNumber,int age){
        if(slotsAvailable.size()>0){
            int slot = slotsAvailable.poll();
            if(vehicleNumberToSlotMapping.containsKey(vehicleNumber)){
                System.out.println("vehicle number "+vehicleNumber+" is already parked.");
                return;
            }
            vehicleNumberToSlotMapping.put(vehicleNumber,slot);//assuming same vehicle number already parked would be parked again
            slots[slot]=new VehicleDetails(vehicleNumber,age);
            if(ageToVehiclesMapping.containsKey(age)){
                ageToVehiclesMapping.get(age).add(vehicleNumber);
            }
            else{
                Set<String> vehicles =new HashSet<>();
                vehicles.add(vehicleNumber);
                ageToVehiclesMapping.put(age,vehicles);
            }
            System.out.println("Car with vehicle registration number "+"\""+vehicleNumber+"\"" +" has been parked at slot number "+slot);
        }
        else{
            System.out.println("parking lot is full");
        }
    }
    public void slotNumbersOfDriversOfAge(int age){
    
        if(ageToVehiclesMapping.containsKey(age)){
            Iterator value = ageToVehiclesMapping.get(age).iterator();
        while (value.hasNext()) { System.out.print(vehicleNumberToSlotMapping.get(value.next()));
          if(value.hasNext()){
            System.out.print(",");
          }
        }
          System.out.println();
        }
        else{
            System.out.println("No car with drivers age "+age+" available in the parking lot.");
        }
    }
    public void slotNumberForCarWithNumber(String vehicleNumber){
        if(vehicleNumberToSlotMapping.containsKey(vehicleNumber)){
            System.out.println(vehicleNumberToSlotMapping.get(vehicleNumber));
        }
        else{
            System.out.println("No vehicle number "+vehicleNumber+" present in the parking lot");
        }
    }
    public void leave(int slot){
        if(slot>slots.length || slot<=0){
            System.out.println("please insert a valid slot number");
            return;
        }
        slotsAvailable.add(slot);
        VehicleDetails vehicle =slots[slot];
        if(vehicle==null){
            System.out.println("please insert a valid slot number");
            return;
        }
        vehicleNumberToSlotMapping.remove(vehicle.getVehicleNumber());
        if(ageToVehiclesMapping.get(vehicle.getDriverAge()).size()==1){
            ageToVehiclesMapping.remove(vehicle.getDriverAge());
        }
        else{
            ageToVehiclesMapping.get(vehicle.getDriverAge()).remove(vehicle.getVehicleNumber());
        }
        System.out.println("Slot number "+slot+" vacated, the car with vehicle registration number "+"\""+vehicle.getVehicleNumber()+"\""+ " left the space, the driver of the car was of age "+vehicle.getDriverAge());
        slots[slot]=null;
    }
    public void vehicleRegistrationNumberForDriverOfAge(int age){
        if(ageToVehiclesMapping.containsKey(age)){
            for(String vehicle : ageToVehiclesMapping.get(age)){
                System.out.println(vehicle);
            }
        }
        else{
            System.out.println("No vehicle with drivers age "+age+" available in the parking lot.");
        }
    }
}