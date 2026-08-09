package complaint_db;

public class Complaint {

    private int complaintId;
    private int userId;
    private int officerId;
    private String complaintType;
    private String description;
    private String status;
    private String resolution;

    // Default Constructor
    public Complaint() {
    }

    // Parameterized Constructor
    public Complaint(int complaintId, int userId, int officerId,
                     String complaintType, String description,
                     String status, String resolution) {

        this.complaintId = complaintId;
        this.userId = userId;
        this.officerId = officerId;
        this.complaintType = complaintType;
        this.description = description;
        this.status = status;
        this.resolution = resolution;
    }

    // Getters and Setters

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}