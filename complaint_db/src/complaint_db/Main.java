package complaint_db;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ComplaintDAO dao = new ComplaintDAO();

        while (true) {

            System.out.println();
            System.out.println("==============================================================");
            System.out.println("          COMPLAINT MANAGEMENT SYSTEM");
            System.out.println("==============================================================");
            System.out.println("  1. Register User");
            System.out.println("  2. Register Officer");
            System.out.println("  3. Register Complaint");
            System.out.println("  4. Assign Officer");
            System.out.println("  5. Update Complaint Status");
            System.out.println("  6. View All Complaints");
            System.out.println("  7. View Resolution");
            System.out.println("  8. Delete Complaint");
            System.out.println("  9. Exit");
            System.out.println("==============================================================");

            System.out.print("Enter Your Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            // ==================================================
            // 1. REGISTER USER
            // ==================================================

            case 1:

                User user = new User();

                System.out.println();
                System.out.println("------------- REGISTER USER -------------");

                System.out.print("Enter User Name : ");
                user.setUserName(sc.nextLine());

                System.out.print("Enter Phone     : ");
                user.setPhone(sc.nextLine());

                System.out.print("Enter Address   : ");
                user.setAddress(sc.nextLine());

                dao.registerUser(user);

                break;


            // ==================================================
            // 2. REGISTER OFFICER
            // ==================================================

            case 2:

                Officer officer = new Officer();

                System.out.println();
                System.out.println("------------ REGISTER OFFICER ------------");

                System.out.print("Enter Officer Name : ");
                officer.setOfficerName(sc.nextLine());

                System.out.print("Enter Department   : ");
                officer.setDepartment(sc.nextLine());

                dao.registerOfficer(officer);

                break;


            // ==================================================
            // 3. REGISTER COMPLAINT
            // ==================================================

            case 3:

                Complaint complaint = new Complaint();

                System.out.println();
                System.out.println("----------- REGISTER COMPLAINT -----------");

                System.out.print("Enter User ID          : ");
                complaint.setUserId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter Complaint Type   : ");
                complaint.setComplaintType(sc.nextLine());

                System.out.print("Enter Description      : ");
                complaint.setDescription(sc.nextLine());

                dao.registerComplaint(complaint);

                break;


            // ==================================================
            // 4. ASSIGN OFFICER
            // ==================================================

            case 4:

                System.out.println();
                System.out.println("------------ ASSIGN OFFICER -------------");

                System.out.print("Enter Complaint ID : ");
                int complaintId = sc.nextInt();

                System.out.print("Enter Officer ID   : ");
                int officerId = sc.nextInt();

                dao.assignOfficer(complaintId, officerId);

                break;


            // ==================================================
            // 5. UPDATE STATUS
            // ==================================================

            case 5:

                System.out.println();
                System.out.println("--------- UPDATE COMPLAINT STATUS --------");

                System.out.print("Enter Complaint ID : ");
                int updateId = sc.nextInt();
                sc.nextLine();

                System.out.println();
                System.out.println("Available Status:");
                System.out.println("1. Pending");
                System.out.println("2. In Progress");
                System.out.println("3. Resolved");

                System.out.print("Enter Status : ");
                int statusChoice = sc.nextInt();
                sc.nextLine();

                String status;

                if (statusChoice == 1) {
                    status = "Pending";
                } else if (statusChoice == 2) {
                    status = "In Progress";
                } else if (statusChoice == 3) {
                    status = "Resolved";
                } else {
                    System.out.println("Invalid Status.");
                    break;
                }

                System.out.print("Enter Resolution : ");
                String resolution = sc.nextLine();

                dao.updateStatus(updateId, status, resolution);

                break;


            // ==================================================
            // 6. VIEW ALL COMPLAINTS
            // ==================================================

            case 6:

                dao.viewComplaints();

                break;


            // ==================================================
            // 7. VIEW RESOLUTION
            // ==================================================

            case 7:

                System.out.println();
                System.out.println("----------- VIEW RESOLUTION --------------");

                System.out.print("Enter Complaint ID : ");
                int resolutionId = sc.nextInt();

                dao.viewResolution(resolutionId);

                break;


            // ==================================================
            // 8. DELETE COMPLAINT
            // ==================================================

            case 8:

                System.out.println();
                System.out.println("----------- DELETE COMPLAINT -------------");

                System.out.print("Enter Complaint ID : ");
                int deleteId = sc.nextInt();

                dao.deleteComplaint(deleteId);

                break;


            // ==================================================
            // 9. EXIT
            // ==================================================

            case 9:

                System.out.println();
                System.out.println("==============================================================");
                System.out.println("       Thank You for Using Complaint Management System");
                System.out.println("==============================================================");

                sc.close();

                System.exit(0);

                break;


            default:

                System.out.println();
                System.out.println("Invalid Choice. Please Try Again.");

            }
        }
    }
}