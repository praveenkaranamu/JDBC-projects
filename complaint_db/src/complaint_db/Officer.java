package complaint_db;

public class Officer {

    private int officerId;
    private String officerName;
    private String department;

    // Default Constructor
    public Officer() {
    }

    // Parameterized Constructor
    public Officer(int officerId, String officerName, String department) {

        this.officerId = officerId;
        this.officerName = officerName;
        this.department = department;
    }

    // Getters and Setters

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}