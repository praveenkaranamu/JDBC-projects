package employee_leave_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Add Employee
    public void addEmployee(Employee emp) {

        try {

            con = DBConnection.getConnection();

            String sql = "INSERT INTO employees(emp_name, department, email, phone) VALUES(?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, emp.getEmpName());
            ps.setString(2, emp.getDepartment());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getPhone());

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Employee Added Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 // View Employees
    public void viewEmployees() {

        try {

            con = DBConnection.getConnection();

            String sql = "SELECT * FROM employees";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println();
            System.out.println("================================================================================");
            System.out.printf("%-5s | %-12s | %-25s | %-25s | %-12s%n",
                    "ID", "Name", "Department", "Email", "Phone");
            System.out.println("--------------------------------------------------------------------------------");

            while (rs.next()) {

                int id = rs.getInt("emp_id");
                String name = rs.getString("emp_name");
                String department = rs.getString("department");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                // Limit department length so the table stays properly aligned
                if (department.length() > 25) {
                    department = department.substring(0, 22) + "...";
                }

                // Limit email length so the table stays properly aligned
                if (email.length() > 25) {
                    email = email.substring(0, 22) + "...";
                }

                System.out.printf(
                        "%-5d | %-12s | %-25s | %-25s | %-12s%n",
                        id,
                        name,
                        department,
                        email,
                        phone
                );
            }

            System.out.println("================================================================================");
            System.out.println();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
   
    // Update Employee
    public void updateEmployee(Employee emp) {

        try {

            con = DBConnection.getConnection();

            String sql = "UPDATE employees SET emp_name=?, department=?, email=?, phone=? WHERE emp_id=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, emp.getEmpName());
            ps.setString(2, emp.getDepartment());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getPhone());
            ps.setInt(5, emp.getEmpId());

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Employee Updated Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Delete Employee
    public void deleteEmployee(int empId) {

        try {

            con = DBConnection.getConnection();

            String sql = "DELETE FROM employees WHERE emp_id=?";

            ps = con.prepareStatement(sql);

            ps.setInt(1, empId);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Employee Deleted Successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}