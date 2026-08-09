package vehicle_service_db;

public class Vehicle {

    private int vehicleId;
    private int customerId;
    private String vehicleNumber;
    private String model;
    private String brand;

    // Default Constructor
    public Vehicle() {
    }

    // Parameterized Constructor
    public Vehicle(int vehicleId, int customerId, String vehicleNumber,
                   String model, String brand) {

        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.brand = brand;
    }

    // Getters and Setters

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}