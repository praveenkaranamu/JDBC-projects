package employee_leave_db;

import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        LeaveDAO leaveDAO = new LeaveDAO();

        while (true) {

            System.out.println("\n========== Employee Leave Management System ==========");
            System.out.println("1. Register Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Apply Leave");
            System.out.println("6. Approve Leave");
            System.out.println("7. Reject Leave");
            System.out.println("8. View Leave Requests");
            System.out.println("9. View Leave Balance");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Employee emp = new Employee();

                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                emp.setEmpName(sc.nextLine());

                System.out.print("Enter Department: ");
                emp.setDepartment(sc.nextLine());

                System.out.print("Enter Email: ");
                emp.setEmail(sc.nextLine());

                System.out.print("Enter Phone: ");
                emp.setPhone(sc.nextLine());

                employeeDAO.addEmployee(emp);

                break;

            case 2:

                employeeDAO.viewEmployees();

                break;

            case 3:

                Employee updateEmp = new Employee();

                System.out.print("Enter Employee ID: ");
                updateEmp.setEmpId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter New Name: ");
                updateEmp.setEmpName(sc.nextLine());

                System.out.print("Enter New Department: ");
                updateEmp.setDepartment(sc.nextLine());

                System.out.print("Enter New Email: ");
                updateEmp.setEmail(sc.nextLine());

                System.out.print("Enter New Phone: ");
                updateEmp.setPhone(sc.nextLine());

                employeeDAO.updateEmployee(updateEmp);

                break;

            case 4:

                System.out.print("Enter Employee ID to Delete: ");
                int deleteId = sc.nextInt();

                employeeDAO.deleteEmployee(deleteId);

                break;

            case 5:

                LeaveRequest leave = new LeaveRequest();

                System.out.print("Enter Employee ID: ");
                leave.setEmpId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Leave Type: ");
                leave.setLeaveType(sc.nextLine());

                System.out.print("Enter From Date (yyyy-mm-dd): ");
                leave.setFromDate(Date.valueOf(sc.next()));

                System.out.print("Enter To Date (yyyy-mm-dd): ");
                leave.setToDate(Date.valueOf(sc.next()));

                sc.nextLine();

                System.out.print("Enter Reason: ");
                leave.setReason(sc.nextLine());

                leaveDAO.applyLeave(leave);

                break;

            case 6:

                System.out.print("Enter Leave ID: ");
                int leaveId = sc.nextInt();

                System.out.print("Enter Employee ID: ");
                int empId = sc.nextInt();

                leaveDAO.approveLeave(leaveId, empId);

                break;

            case 7:

                System.out.print("Enter Leave ID: ");
                int rejectId = sc.nextInt();

                leaveDAO.rejectLeave(rejectId);

                break;

            case 8:

                leaveDAO.viewLeaveRequests();

                break;

            case 9:

                leaveDAO.viewLeaveBalance();

                break;

            case 10:

                System.out.println("Thank You...");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice.");

            }

        }

    }

}