package complaint_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ComplaintDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;


    // ============================================================
    // 1. REGISTER USER
    // ============================================================

    public void registerUser(User user) {

        try {

            con = DBConnection.getConnection();

            String sql = "INSERT INTO users(user_name, phone, address) VALUES(?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getAddress());

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("\nUser Registered Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ============================================================
    // 2. REGISTER OFFICER
    // ============================================================

    public void registerOfficer(Officer officer) {

        try {

            con = DBConnection.getConnection();

            String sql = "INSERT INTO officers(officer_name, department) VALUES(?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, officer.getOfficerName());
            ps.setString(2, officer.getDepartment());

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("\nOfficer Registered Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ============================================================
    // 3. REGISTER COMPLAINT
    // ============================================================

    public void registerComplaint(Complaint complaint) {

        try {

            con = DBConnection.getConnection();

            String sql = "INSERT INTO complaints"
                    + "(user_id, complaint_type, description, status)"
                    + " VALUES(?,?,?,'Pending')";

            ps = con.prepareStatement(sql);

            ps.setInt(1, complaint.getUserId());
            ps.setString(2, complaint.getComplaintType());
            ps.setString(3, complaint.getDescription());

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("\nComplaint Registered Successfully.");
                System.out.println("Status : Pending");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ============================================================
    // 4. ASSIGN OFFICER
    // ============================================================

    public void assignOfficer(int complaintId, int officerId) {

        try {

            con = DBConnection.getConnection();

            String sql = "UPDATE complaints "
                    + "SET officer_id=?, status='In Progress' "
                    + "WHERE complaint_id=?";

            ps = con.prepareStatement(sql);

            ps.setInt(1, officerId);
            ps.setInt(2, complaintId);

            int row = ps.executeUpdate();

            if (row > 0) {

                System.out.println("\nOfficer Assigned Successfully.");
                System.out.println("Complaint Status : In Progress");

            } else {

                System.out.println("\nComplaint ID Not Found.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ============================================================
    // 5. UPDATE STATUS AND RESOLUTION
    // ============================================================

    public void updateStatus(int complaintId,
                             String status,
                             String resolution) {

        try {

            con = DBConnection.getConnection();

            String sql = "UPDATE complaints "
                    + "SET status=?, resolution=? "
                    + "WHERE complaint_id=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setString(2, resolution);
            ps.setInt(3, complaintId);

            int row = ps.executeUpdate();

            if (row > 0) {

                System.out.println("\nComplaint Status Updated Successfully.");
                System.out.println("Status     : " + status);
                System.out.println("Resolution : " + resolution);

            } else {

                System.out.println("\nComplaint ID Not Found.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ============================================================
    // 6. VIEW ALL COMPLAINTS
    // ============================================================

    public void viewComplaints() {

        try {

            con = DBConnection.getConnection();

            String sql = "SELECT c.complaint_id, "
                    + "u.user_name, "
                    + "c.complaint_type, "
                    + "c.description, "
                    + "c.status, "
                    + "o.officer_name "
                    + "FROM complaints c "
                    + "INNER JOIN users u "
                    + "ON c.user_id = u.user_id "
                    + "LEFT JOIN officers o "
                    + "ON c.officer_id = o.officer_id "
                    + "ORDER BY c.complaint_id";

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            printComplaintHeader();

            while (rs.next()) {

                String officerName = rs.getString("officer_name");

                if (officerName == null) {
                    officerName = "Not Assigned";
                }

                System.out.printf(
                        "| %-5d | %-18s | %-20s | %-15s | %-18s |%n",
                        rs.getInt("complaint_id"),
                        rs.getString("user_name"),
                        rs.getString("complaint_type"),
                        rs.getString("status"),
                        officerName
                );
            }

            printComplaintFooter();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ============================================================
    // 7. VIEW RESOLUTION
    // ============================================================

    public void viewResolution(int complaintId) {

        try {

            con = DBConnection.getConnection();

            String sql = "SELECT c.complaint_id, "
                    + "u.user_name, "
                    + "c.complaint_type, "
                    + "c.status, "
                    + "c.resolution "
                    + "FROM complaints c "
                    + "INNER JOIN users u "
                    + "ON c.user_id = u.user_id "
                    + "WHERE c.complaint_id=?";

            ps = con.prepareStatement(sql);

            ps.setInt(1, complaintId);

            rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n==============================================================");
                System.out.println("                  COMPLAINT RESOLUTION");
                System.out.println("==============================================================");

                System.out.printf("%-20s : %d%n",
                        "Complaint ID",
                        rs.getInt("complaint_id"));

                System.out.printf("%-20s : %s%n",
                        "User",
                        rs.getString("user_name"));

                System.out.printf("%-20s : %s%n",
                        "Complaint Type",
                        rs.getString("complaint_type"));

                System.out.printf("%-20s : %s%n",
                        "Status",
                        rs.getString("status"));

                String resolution = rs.getString("resolution");

                if (resolution == null || resolution.trim().isEmpty()) {
                    resolution = "Resolution not provided yet.";
                }

                System.out.printf("%-20s : %s%n",
                        "Resolution",
                        resolution);

                System.out.println("==============================================================");

            } else {

                System.out.println("\nComplaint ID Not Found.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ============================================================
    // 8. DELETE COMPLAINT
    // ============================================================

    public void deleteComplaint(int complaintId) {

        try {

            con = DBConnection.getConnection();

            String sql = "DELETE FROM complaints WHERE complaint_id=?";

            ps = con.prepareStatement(sql);

            ps.setInt(1, complaintId);

            int row = ps.executeUpdate();

            if (row > 0) {

                System.out.println("\nComplaint Deleted Successfully.");

            } else {

                System.out.println("\nComplaint ID Not Found.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ============================================================
    // 9. COMPLAINT TABLE HEADER
    // ============================================================

    private void printComplaintHeader() {

        System.out.println("\n");
        System.out.println(
                "=============================================== COMPLAINT DETAILS ===============================================");

        System.out.printf(
                "| %-5s | %-18s | %-20s | %-15s | %-18s |%n",
                "ID",
                "User",
                "Complaint Type",
                "Status",
                "Officer");

        System.out.println(
                "----------------------------------------------------------------------------------------------------------------");


    }


    // ============================================================
    // 10. COMPLAINT TABLE FOOTER
    // ============================================================

    private void printComplaintFooter() {

        System.out.println(
                "================================================================================================================\n");

    }

}