package banking_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class BankDAO {

    // ==========================
    // Create Customer
    // ==========================
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers(customer_name, phone, address) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAddress());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Customer Added Successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // Create Account
    // ==========================
    public void createAccount(Account account) {
        String sql = "INSERT INTO accounts(customer_id, account_type, balance) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, account.getCustomerId());
            ps.setString(2, account.getAccountType());
            ps.setDouble(3, account.getBalance());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Account Created Successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // Deposit Money
    // ==========================
    public void deposit(int accountNo, double amount) {
        String updateSql = "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";
        String transactionSql = "INSERT INTO transactions(account_no, transaction_type, amount, transaction_date) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement psUpdate = con.prepareStatement(updateSql);
                 PreparedStatement psTrans = con.prepareStatement(transactionSql)) {

                psUpdate.setDouble(1, amount);
                psUpdate.setInt(2, accountNo);
                int rows = psUpdate.executeUpdate();

                if (rows > 0) {
                    psTrans.setInt(1, accountNo);
                    psTrans.setString(2, "Deposit");
                    psTrans.setDouble(3, amount);
                    psTrans.setDate(4, new Date(System.currentTimeMillis()));
                    psTrans.executeUpdate();

                    con.commit();
                    System.out.println("Deposit Successful.");
                } else {
                    System.out.println("Account not found.");
                    con.rollback();
                }

            } catch (SQLException e) {
                con.rollback();
                throw e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // Withdraw Money
    // ==========================
    public void withdraw(int accountNo, double amount) {
        String checkSql = "SELECT balance FROM accounts WHERE account_no=?";
        String updateSql = "UPDATE accounts SET balance = balance - ? WHERE account_no=?";
        String transactionSql = "INSERT INTO transactions(account_no, transaction_type, amount, transaction_date) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement psCheck = con.prepareStatement(checkSql)) {
                psCheck.setInt(1, accountNo);

                try (ResultSet rs = psCheck.executeQuery()) {
                    if (rs.next()) {
                        double balance = rs.getDouble("balance");

                        if (balance >= amount) {
                            try (PreparedStatement psUpdate = con.prepareStatement(updateSql);
                                 PreparedStatement psTrans = con.prepareStatement(transactionSql)) {

                                psUpdate.setDouble(1, amount);
                                psUpdate.setInt(2, accountNo);
                                psUpdate.executeUpdate();

                                psTrans.setInt(1, accountNo);
                                psTrans.setString(2, "Withdrawal");
                                psTrans.setDouble(3, amount);
                                psTrans.setDate(4, new Date(System.currentTimeMillis()));
                                psTrans.executeUpdate();

                                con.commit();
                                System.out.println("Withdrawal Successful.");
                            }
                        } else {
                            System.out.println("Insufficient Balance.");
                            con.rollback();
                        }
                    } else {
                        System.out.println("Account not found.");
                        con.rollback();
                    }
                }
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // Fund Transfer (Transaction)
    // ==========================
    public void fundTransfer(int fromAccount, int toAccount, double amount) {
        String checkSql = "SELECT balance FROM accounts WHERE account_no=?";
        String deductSql = "UPDATE accounts SET balance = balance - ? WHERE account_no=?";
        String addSql = "UPDATE accounts SET balance = balance + ? WHERE account_no=?";
        String transactionSql = "INSERT INTO transactions(account_no, transaction_type, amount, transaction_date) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement psCheck = con.prepareStatement(checkSql)) {
                psCheck.setInt(1, fromAccount);

                try (ResultSet rs = psCheck.executeQuery()) {
                    if (rs.next()) {
                        double balance = rs.getDouble("balance");

                        if (balance >= amount) {
                            // Deduct Money
                            try (PreparedStatement psDeduct = con.prepareStatement(deductSql)) {
                                psDeduct.setDouble(1, amount);
                                psDeduct.setInt(2, fromAccount);
                                psDeduct.executeUpdate();
                            }

                            // Add Money
                            try (PreparedStatement psAdd = con.prepareStatement(addSql)) {
                                psAdd.setDouble(1, amount);
                                psAdd.setInt(2, toAccount);
                                psAdd.executeUpdate();
                            }

                            // Transaction Record - Sender
                            try (PreparedStatement psTrans = con.prepareStatement(transactionSql)) {
                                psTrans.setInt(1, fromAccount);
                                psTrans.setString(2, "Transfer Sent");
                                psTrans.setDouble(3, amount);
                                psTrans.setDate(4, new Date(System.currentTimeMillis()));
                                psTrans.executeUpdate();

                                // Transaction Record - Receiver
                                psTrans.setInt(1, toAccount);
                                psTrans.setString(2, "Transfer Received");
                                psTrans.setDouble(3, amount);
                                psTrans.setDate(4, new Date(System.currentTimeMillis()));
                                psTrans.executeUpdate();
                            }

                            con.commit();
                            System.out.println("Fund Transfer Successful.");

                        } else {
                            System.out.println("Insufficient Balance.");
                            con.rollback();
                        }
                    } else {
                        System.out.println("Sender account not found.");
                        con.rollback();
                    }
                }
            } catch (SQLException e) {
                con.rollback();
                System.out.println("Transfer Failed. Transaction Rolled Back.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // Transaction History
    // ==========================
    public void viewTransactions() {
        String sql = "SELECT * FROM transactions";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

        	System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("%-10s %-12s %-22s %-12s %-15s%n",
                    "ID", "Account No", "Type", "Amount", "Date");
            System.out.println("--------------------------------------------------------------------------------");

            while (rs.next()) {

                System.out.printf("%-10d %-12d %-22s %-12.2f %-15s%n",
                        rs.getInt("transaction_id"),
                        rs.getInt("account_no"),
                        rs.getString("transaction_type"),
                        rs.getDouble("amount"),
                        rs.getDate("transaction_date"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // View Accounts
    // ==========================
    public void viewAccounts() {
        String sql = "SELECT * FROM accounts";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

        	System.out.println("-----------------------------------------------------------------------");
        	System.out.printf("%-12s %-15s %-15s %-15s%n",
        	        "Account No", "Customer ID", "Type", "Balance");
        	System.out.println("-----------------------------------------------------------------------");

        	while(rs.next()) {

        	    System.out.printf("%-12d %-15d %-15s %-15.2f%n",
        	            rs.getInt("account_no"),
        	            rs.getInt("customer_id"),
        	            rs.getString("account_type"),
        	            rs.getDouble("balance"));
        	}

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}