package SIQ_PE1;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ParkingLot parkingLot =ParkingLot.getInstance();
        URL url = Main.class.getResource("input.txt");//input from input.txt in the class path
        File file = new File(url.getPath());
        Scanner sc =new Scanner(file);
        while(sc.hasNext()) {
            String query = sc.nextLine();// reading each query from the file
            if (query.split(" ")[0].equals("Create_parking_lot")) {
                parkingLot.createParkingLot(Integer.parseInt(query.split(" ")[1]));
            } else if (query.split(" ")[0].equals("Park")) {
                parkingLot.park(query.split(" ")[1], Integer.parseInt(query.split(" ")[3]));
            } else if (query.split(" ")[0].equals("Slot_numbers_for_driver_of_age")) {
                parkingLot.slotNumbersOfDriversOfAge(Integer.parseInt(query.split(" ")[1]));
            } else if (query.split(" ")[0].equals("Slot_number_for_car_with_number")) {
                parkingLot.slotNumberForCarWithNumber(query.split(" ")[1]);
            } else if (query.split(" ")[0].equals("Leave")) {
                parkingLot.leave(Integer.parseInt(query.split(" ")[1]));
            } else if (query.split(" ")[0].equals("Vehicle_registration_number_for_driver_of_age")) {
                parkingLot.vehicleRegistrationNumberForDriverOfAge(Integer.parseInt(query.split(" ")[1]));
            }
        }
    }
}
