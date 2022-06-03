
class VehicleDetails{
    private String vehicleNumber;
    private int driverAge;
    public VehicleDetails(String vehicleNumber,int driverAge){
        this.driverAge=driverAge;
        this.vehicleNumber=vehicleNumber;
    }
    public String getVehicleNumber(){
        return this.vehicleNumber;
    }
    public int getDriverAge(){
        return this.driverAge;
    }
}