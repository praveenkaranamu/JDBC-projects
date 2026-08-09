package vehicle_service_db;

import java.sql.Date;

public class ServiceRecord {

    private int serviceId;
    private int vehicleId;
    private String serviceType;
    private Date serviceDate;
    private double cost;

    // Default Constructor
    public ServiceRecord() {
    }

    // Parameterized Constructor
    public ServiceRecord(int serviceId, int vehicleId, String serviceType,
                         Date serviceDate, double cost) {

        this.serviceId = serviceId;
        this.vehicleId = vehicleId;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.cost = cost;
    }

    // Getters and Setters

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}