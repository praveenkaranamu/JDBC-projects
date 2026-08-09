package banking_db;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankDAO dao = new BankDAO();

        while (true) {

            System.out.println("\n========== BANKING MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Fund Transfer");
            System.out.println("6. View Accounts");
            System.out.println("7. View Transaction History");
            System.out.println("8. Exit");

            System.out.print("Enter your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Customer customer = new Customer();

                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                customer.setCustomerName(sc.nextLine());

                System.out.print("Enter Phone Number: ");
                customer.setPhone(sc.nextLine());

                System.out.print("Enter Address: ");
                customer.setAddress(sc.nextLine());

                dao.addCustomer(customer);

                break;

            case 2:

                Account account = new Account();

                System.out.print("Enter Customer ID: ");
                account.setCustomerId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Account Type (Savings/Current): ");
                account.setAccountType(sc.nextLine());

                System.out.print("Enter Initial Balance: ");
                account.setBalance(sc.nextDouble());

                dao.createAccount(account);

                break;

            case 3:

                System.out.print("Enter Account Number: ");
                int depositAcc = sc.nextInt();

                System.out.print("Enter Deposit Amount: ");
                double depositAmt = sc.nextDouble();

                dao.deposit(depositAcc, depositAmt);

                break;

            case 4:

                System.out.print("Enter Account Number: ");
                int withdrawAcc = sc.nextInt();

                System.out.print("Enter Withdrawal Amount: ");
                double withdrawAmt = sc.nextDouble();

                dao.withdraw(withdrawAcc, withdrawAmt);

                break;

            case 5:

                System.out.print("Enter From Account Number: ");
                int fromAcc = sc.nextInt();

                System.out.print("Enter To Account Number: ");
                int toAcc = sc.nextInt();

                System.out.print("Enter Transfer Amount: ");
                double transferAmt = sc.nextDouble();

                dao.fundTransfer(fromAcc, toAcc, transferAmt);

                break;

            case 6:

                dao.viewAccounts();

                break;

            case 7:

                dao.viewTransactions();

                break;

            case 8:

                System.out.println("Thank You!");
                sc.close();
                System.exit(0);

                break;

            default:

                System.out.println("Invalid Choice!");

            }

        }

    }

}