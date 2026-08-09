package complaint_db;

public class User {

    private int userId;
    private String userName;
    private String phone;
    private String address;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(int userId, String userName, String phone, String address) {

        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}