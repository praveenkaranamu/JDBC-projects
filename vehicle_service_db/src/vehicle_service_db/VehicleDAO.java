package vehicle_service_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VehicleDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // ======================================================
    // Reusable Line Method
    // ======================================================

    private void printLine(int length) {

        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    // ======================================================
    // Customer Registration
    // ======================================================

    public void addCustomer(Customer customer) {

        try {

            con = DBConnection.getConnection();

            String sql = "INSERT INTO customers(customer_name, phone, city) VALUES(?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getCity());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println();

                printLine(54);
                System.out.println("       Customer Registered Successfully!");
                printLine(54);

                System.out.println();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ======================================================
    // Vehicle Registration
    // ======================================================

    public void registerVehicle(Vehicle vehicle) {

        try {

            con = DBConnection.getConnection();

            String sql = "INSERT INTO vehicles(customer_id, vehicle_number, model, brand) VALUES(?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, vehicle.getCustomerId());
            ps.setString(2, vehicle.getVehicleNumber());
            ps.setString(3, vehicle.getModel());
            ps.setString(4, vehicle.getBrand());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println();

                printLine(54);
                System.out.println("        Vehicle Registered Successfully!");
                printLine(54);

                System.out.println();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ======================================================
    // Service Booking
    // ======================================================

    public void bookService(ServiceRecord service) {

        try {

            con = DBConnection.getConnection();

            String sql = "INSERT INTO service_records(vehicle_id, service_type, service_date, cost) VALUES(?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, service.getVehicleId());
            ps.setString(2, service.getServiceType());
            ps.setDate(3, service.getServiceDate());
            ps.setDouble(4, service.getCost());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println();

                printLine(54);
                System.out.println("          Service Booked Successfully!");
                printLine(54);

                System.out.println();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ======================================================
    // Service History
    // ======================================================

    public void viewServiceHistory() {

        try {

            con = DBConnection.getConnection();

            String sql = "SELECT c.customer_name, v.vehicle_number, v.model, "
                    + "sr.service_type, sr.service_date, sr.cost "
                    + "FROM customers c "
                    + "INNER JOIN vehicles v ON c.customer_id = v.customer_id "
                    + "INNER JOIN service_records sr ON v.vehicle_id = sr.vehicle_id";

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            // Column widths
            int customerWidth = 20;
            int vehicleWidth = 15;
            int modelWidth = 15;
            int serviceWidth = 18;
            int dateWidth = 12;
            int costWidth = 12;

            // Calculate complete table width
            int tableWidth = customerWidth
                    + vehicleWidth
                    + modelWidth
                    + serviceWidth
                    + dateWidth
                    + costWidth
                    + 7 * 3;

            System.out.println();

            printLine(tableWidth);

            System.out.printf(
                    "| %-" + customerWidth + "s "
                    + "| %-" + vehicleWidth + "s "
                    + "| %-" + modelWidth + "s "
                    + "| %-" + serviceWidth + "s "
                    + "| %-" + dateWidth + "s "
                    + "| %" + costWidth + "s |%n",
                    "Customer",
                    "Vehicle No",
                    "Model",
                    "Service",
                    "Date",
                    "Cost"
            );

            printLine(tableWidth);

            while (rs.next()) {

                System.out.printf(
                        "| %-" + customerWidth + "s "
                        + "| %-" + vehicleWidth + "s "
                        + "| %-" + modelWidth + "s "
                        + "| %-" + serviceWidth + "s "
                        + "| %-" + dateWidth + "s "
                        + "| %" + costWidth + ".2f |%n",
                        rs.getString("customer_name"),
                        rs.getString("vehicle_number"),
                        rs.getString("model"),
                        rs.getString("service_type"),
                        rs.getDate("service_date"),
                        rs.getDouble("cost")
                );
            }

            printLine(tableWidth);

            System.out.println();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // ======================================================
    // Search Vehicle
    // ======================================================

    public void searchVehicle(String vehicleNumber) {

        try {

            con = DBConnection.getConnection();

            String sql = "SELECT * FROM vehicles WHERE vehicle_number = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, vehicleNumber);

            rs = ps.executeQuery();

            if (rs.next()) {

                int labelWidth = 18;
                int valueWidth = 27;
                int searchWidth = labelWidth + valueWidth + 5;

                System.out.println();

                printLine(searchWidth);

                System.out.printf(
                        "%-" + searchWidth + "s%n",
                        "VEHICLE FOUND"
                );

                printLine(searchWidth);

                System.out.printf(
                        "%-" + labelWidth + "s : %-" + valueWidth + "s%n",
                        "Vehicle ID",
                        rs.getInt("vehicle_id")
                );

                System.out.printf(
                        "%-" + labelWidth + "s : %-" + valueWidth + "s%n",
                        "Customer ID",
                        rs.getInt("customer_id")
                );

                System.out.printf(
                        "%-" + labelWidth + "s : %-" + valueWidth + "s%n",
                        "Vehicle Number",
                        rs.getString("vehicle_number")
                );

                System.out.printf(
                        "%-" + labelWidth + "s : %-" + valueWidth + "s%n",
                        "Model",
                        rs.getString("model")
                );

                System.out.printf(
                        "%-" + labelWidth + "s : %-" + valueWidth + "s%n",
                        "Brand",
                        rs.getString("brand")
                );

                printLine(searchWidth);

                System.out.println();

            } else {

                int searchWidth = 50;

                System.out.println();

                printLine(searchWidth);

                System.out.printf(
                        "%-" + searchWidth + "s%n",
                        "VEHICLE NOT FOUND"
                );

                printLine(searchWidth);

                System.out.println();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}