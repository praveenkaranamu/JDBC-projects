package vehicle_service_db;

import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VehicleDAO dao = new VehicleDAO();

        while (true) {

            System.out.println("\n========== VEHICLE SERVICE CENTER MANAGEMENT ==========");
            System.out.println("1. Customer Registration");
            System.out.println("2. Vehicle Registration");
            System.out.println("3. Service Booking");
            System.out.println("4. View Service History");
            System.out.println("5. Search Vehicle");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Customer customer = new Customer();

                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                customer.setCustomerName(sc.nextLine());

                System.out.print("Enter Phone Number: ");
                customer.setPhone(sc.nextLine());

                System.out.print("Enter City: ");
                customer.setCity(sc.nextLine());

                dao.addCustomer(customer);

                break;

            case 2:

                Vehicle vehicle = new Vehicle();

                System.out.print("Enter Customer ID: ");
                vehicle.setCustomerId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Vehicle Number: ");
                vehicle.setVehicleNumber(sc.nextLine());

                System.out.print("Enter Model: ");
                vehicle.setModel(sc.nextLine());

                System.out.print("Enter Brand: ");
                vehicle.setBrand(sc.nextLine());

                dao.registerVehicle(vehicle);

                break;

            case 3:

                ServiceRecord service = new ServiceRecord();

                System.out.print("Enter Vehicle ID: ");
                service.setVehicleId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Service Type: ");
                service.setServiceType(sc.nextLine());

                System.out.print("Enter Service Date (yyyy-mm-dd): ");
                service.setServiceDate(Date.valueOf(sc.next()));

                System.out.print("Enter Service Cost: ");
                service.setCost(sc.nextDouble());

                dao.bookService(service);

                break;

            case 4:

                dao.viewServiceHistory();

                break;

            case 5:

                sc.nextLine();

                System.out.print("Enter Vehicle Number: ");

                String number = sc.nextLine();

                dao.searchVehicle(number);

                break;

            case 6:

                System.out.println("Thank You!");

                sc.close();

                System.exit(0);

                break;

            default:

                System.out.println("Invalid Choice.");

            }

        }

    }

}