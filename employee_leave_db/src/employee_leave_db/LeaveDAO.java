package employee_leave_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LeaveDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Apply Leave
    public void applyLeave(LeaveRequest leave) {

        try {

            con = DBConnection.getConnection();

            String sql = "INSERT INTO leave_requests(emp_id, leave_type, from_date, to_date, reason, status) VALUES(?,?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, leave.getEmpId());
            ps.setString(2, leave.getLeaveType());
            ps.setDate(3, leave.getFromDate());
            ps.setDate(4, leave.getToDate());
            ps.setString(5, leave.getReason());
            ps.setString(6, "Pending");

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Leave Applied Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

 // View Leave Requests
    public void viewLeaveRequests() {

        try {

            con = DBConnection.getConnection();

            String sql = "SELECT * FROM leave_requests";

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%-8s %-10s %-20s %-15s %-15s %-15s%n",
                    "ID", "EmpID", "Type", "From", "To", "Status");
            System.out.println("---------------------------------------------------------------------------------------------");

            while (rs.next()) {

                System.out.printf("%-8d %-10d %-20s %-15s %-15s %-15s%n",
                        rs.getInt("leave_id"),
                        rs.getInt("emp_id"),
                        rs.getString("leave_type"),
                        rs.getDate("from_date"),
                        rs.getDate("to_date"),
                        rs.getString("status"));
            }

            System.out.println("---------------------------------------------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Approve Leave (Transaction)
    public void approveLeave(int leaveId, int empId) {

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            // Update leave status
            String sql1 = "UPDATE leave_requests SET status='Approved' WHERE leave_id=?";

            ps = con.prepareStatement(sql1);
            ps.setInt(1, leaveId);
            ps.executeUpdate();

            // Update leave balance
            String sql2 = "UPDATE leave_balance SET leaves_used = leaves_used + 1, remaining_leaves = remaining_leaves - 1 WHERE emp_id=?";

            ps = con.prepareStatement(sql2);
            ps.setInt(1, empId);
            ps.executeUpdate();

            con.commit();

            System.out.println("Leave Approved Successfully.");

        } catch (Exception e) {

            try {
                con.rollback();
                System.out.println("Transaction Rolled Back.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        }

    }

    // Reject Leave
    public void rejectLeave(int leaveId) {

        try {

            con = DBConnection.getConnection();

            String sql = "UPDATE leave_requests SET status='Rejected' WHERE leave_id=?";

            ps = con.prepareStatement(sql);

            ps.setInt(1, leaveId);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Leave Rejected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

 // View Leave Balance
    public void viewLeaveBalance() {

        try {

            con = DBConnection.getConnection();

            String sql = "SELECT * FROM leave_balance";

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            System.out.println("---------------------------------------------------------------");
            System.out.printf("%-10s %-15s %-15s %-15s%n",
                    "EmpID", "Total", "Used", "Remaining");
            System.out.println("---------------------------------------------------------------");

            while (rs.next()) {

                System.out.printf("%-10d %-15d %-15d %-15d%n",
                        rs.getInt("emp_id"),
                        rs.getInt("total_leaves"),
                        rs.getInt("leaves_used"),
                        rs.getInt("remaining_leaves"));
            }

            System.out.println("---------------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}