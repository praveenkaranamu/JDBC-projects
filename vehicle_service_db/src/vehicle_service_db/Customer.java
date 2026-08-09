package vehicle_service_db;

public class Customer {

    private int customerId;
    private String customerName;
    private String phone;
    private String city;

    // Default Constructor
    public Customer() {
    }

    // Parameterized Constructor
    public Customer(int customerId, String customerName, String phone, String city) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
        this.city = city;
    }

    // Getters and Setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}