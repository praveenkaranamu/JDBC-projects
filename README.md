# JDBC-projects

==============================================================
          COMPLAINT MANAGEMENT SYSTEM
==============================================================
  1. Register User
  2. Register Officer
  3. Register Complaint
  4. Assign Officer
  5. Update Complaint Status
  6. View All Complaints
  7. View Resolution
  8. Delete Complaint
  9. Exit
==============================================================
Enter Your Choice :
```

### 1. Register User

``` text
------------- REGISTER USER -------------

Enter User Name : Rahul
Enter Phone     : 9876543210
Enter Address   : Chennai

User Registered Successfully.
```

### 2. Register Officer

``` text
------------ REGISTER OFFICER ------------

Enter Officer Name : Ramesh
Enter Department   : Water Supply

Officer Registered Successfully.
```

### 3. Register Complaint

``` text
----------- REGISTER COMPLAINT -----------

Enter User ID          : 1
Enter Complaint Type   : Water Leakage
Enter Description      : Pipeline leakage near main street

Complaint Registered Successfully.
Status : Pending
```

### 4. Assign Officer

``` text
------------ ASSIGN OFFICER -------------

Enter Complaint ID : 1
Enter Officer ID   : 1

Officer Assigned Successfully.
Complaint Status : In Progress
```

### 5. Update Complaint Status

``` text
--------- UPDATE COMPLAINT STATUS --------

Enter Complaint ID : 1

Available Status:
1. Pending
2. In Progress
3. Resolved

Enter Status : 3
Enter Resolution : Pipeline leakage repaired successfully.

Complaint Status Updated Successfully.
Status     : Resolved
Resolution : Pipeline leakage repaired successfully.
```

### 6. View All Complaints

``` text
=============================================== COMPLAINT DETAILS ===============================================

| ID    | User               | Complaint Type       | Status          | Officer            |
----------------------------------------------------------------------------------------------------------------
| 1     | Rahul              | Water Leakage        | Resolved        | Ramesh             |
| 2     | Priya              | Road Damage          | In Progress     | Suresh             |
| 3     | Arun               | Power Failure        | Resolved        | Mahesh             |
================================================================================================================
```

### 7. View Resolution

``` text
----------- VIEW RESOLUTION --------------

Enter Complaint ID : 1

==============================================================
                  COMPLAINT RESOLUTION
==============================================================
Complaint ID         : 1
User                 : Rahul
Complaint Type       : Water Leakage
Status               : Resolved
Resolution           : Pipeline leakage repaired successfully.
==============================================================
```

### 8. Delete Complaint

``` text
----------- DELETE COMPLAINT -------------

Enter Complaint ID : 1

Complaint Deleted Successfully.
```

### 9. Exit

``` text
==============================================================
       Thank You for Using Complaint Management System
==============================================================
```

==============================================================
          BANKING MANAGEMANT SYSTEM
==============================================================

### 1. Application Start

``` text
Database Connected Successfully.

==========** BANKING MANAGEMENT SYSTEM** ==========
1. Add Customer
2. Create Account
3. Deposit
4. Withdraw
5. Fund Transfer
6. View Accounts
7. View Transaction History
8. Exit
Enter your Choice:
```

The menu options above correspond to the `Main.java` program flow.
fileciteturn2file4L15-L25

------------------------------------------------------------------------

### 2. Add Customer

``` text
========== BANKING MANAGEMENT SYSTEM ==========
1. Add Customer
2. Create Account
3. Deposit
4. Withdraw
5. Fund Transfer
6. View Accounts
7. View Transaction History
8. Exit
Enter your Choice: 1

Enter Customer Name: Rahul
Enter Phone Number: 9876543210
Enter Address: Chennai

Customer Added Successfully.
```

The program asks for customer name, phone number, and address before
calling the DAO method to add the customer.
fileciteturn2file4L31-L48

------------------------------------------------------------------------

### 3. Create Account

``` text
========== BANKING MANAGEMENT SYSTEM ==========
1. Add Customer
2. Create Account
3. Deposit
4. Withdraw
5. Fund Transfer
6. View Accounts
7. View Transaction History
8. Exit
Enter your Choice: 2

Enter Customer ID: 1
Enter Account Type (Savings/Current): Savings
Enter Initial Balance: 10000

Account Created Successfully.
```

The account creation flow accepts customer ID, account type, and initial
balance. fileciteturn2file4L50-L67

------------------------------------------------------------------------

### 4. Deposit

``` text
========== BANKING MANAGEMENT SYSTEM ==========
1. Add Customer
2. Create Account
3. Deposit
4. Withdraw
5. Fund Transfer
6. View Accounts
7. View Transaction History
8. Exit
Enter your Choice: 3

Enter Account Number: 1001
Enter Deposit Amount: 5000

Amount Deposited Successfully.
```

The deposit operation asks for an account number and deposit amount.
fileciteturn2file4L69-L79

------------------------------------------------------------------------

### 5. Withdrawal

``` text
========== BANKING MANAGEMENT SYSTEM ==========
1. Add Customer
2. Create Account
3. Deposit
4. Withdraw
5. Fund Transfer
6. View Accounts
7. View Transaction History
8. Exit
Enter your Choice: 4

Enter Account Number: 1001
Enter Withdrawal Amount: 2000

Amount Withdrawn Successfully.
```

The withdrawal operation accepts an account number and withdrawal
amount. fileciteturn2file4L81-L91

------------------------------------------------------------------------

### 6. Fund Transfer

``` text
========== BANKING MANAGEMENT SYSTEM ==========
1. Add Customer
2. Create Account
3. Deposit
4. Withdraw
5. Fund Transfer
6. View Accounts
7. View Transaction History
8. Exit
Enter your Choice: 5

Enter From Account Number: 1001
Enter To Account Number: 1002
Enter Transfer Amount: 1000

Fund Transfer Successful.
```

The fund transfer flow takes a source account, destination account, and
transfer amount. fileciteturn2file4L93-L105

------------------------------------------------------------------------

### 7. View Accounts

``` text
================================================================================
                         ACCOUNT DETAILS
================================================================================
| Account No  | Customer ID  | Type          | Balance        |
--------------------------------------------------------------------------------
| 1001        | 1            | Savings       | 13000.00       |
| 1002        | 2            | Savings       | 11000.00       |
================================================================================
```

The application provides a dedicated **View Accounts** option from the
main menu. fileciteturn2file4L20-L23

------------------------------------------------------------------------

### 8. View Transaction History

``` text
=============================================================================================
                              TRANSACTION HISTORY
=============================================================================================
| ID       | Account No   | Transaction Type       | Amount       | Date        |
---------------------------------------------------------------------------------------------
| 1        | 1001         | Deposit                | 5000.00      | 2026-08-09  |
| 2        | 1001         | Withdrawal             | 2000.00      | 2026-08-09  |
| 3        | 1001         | Transfer Sent          | 1000.00      | 2026-08-09  |
| 4        | 1002         | Transfer Received      | 1000.00      | 2026-08-09  |
=============================================================================================
```

The `Transaction` model stores transaction ID, account number,
transaction type, amount, and transaction date.
fileciteturn2file5L5-L11

------------------------------------------------------------------------

### 9. Exit

``` text
========== BANKING MANAGEMENT SYSTEM ==========
1. Add Customer
2. Create Account
3. Deposit
4. Withdraw
5. Fund Transfer
6. View Accounts
7. View Transaction History
8. Exit
Enter your Choice: 8

Thank You!
```
==============================================================
          VEHICLE SERVICE CENTER MANAGEMENT
==============================================================

### Application Start

``` text
Database Connected Successfully.

========== VEHICLE SERVICE CENTER MANAGEMENT ==========
1. Customer Registration
2. Vehicle Registration
3. Service Booking
4. View Service History
5. Search Vehicle
6. Exit

Enter Your Choice:
```

The menu contains the six options shown above.

------------------------------------------------------------------------

### 1. Customer Registration

``` text
========== VEHICLE SERVICE CENTER MANAGEMENT ==========
1. Customer Registration
2. Vehicle Registration
3. Service Booking
4. View Service History
5. Search Vehicle
6. Exit

Enter Your Choice: 1

Enter Customer Name: Rahul
Enter Phone Number: 9876543210
Enter City: Chennai

Customer Added Successfully!
```

------------------------------------------------------------------------

### 2. Vehicle Registration

``` text
========== VEHICLE SERVICE CENTER MANAGEMENT ==========
1. Customer Registration
2. Vehicle Registration
3. Service Booking
4. View Service History
5. Search Vehicle
6. Exit

Enter Your Choice: 2

Enter Customer ID: 1
Enter Vehicle Number: TN10AB1234
Enter Model: Swift
Enter Brand: Maruti

Vehicle Registered Successfully!
```

The program requests customer ID, vehicle number, model, and brand
before registering the vehicle.

------------------------------------------------------------------------

### 3. Service Booking

``` text
========== VEHICLE SERVICE CENTER MANAGEMENT ==========
1. Customer Registration
2. Vehicle Registration
3. Service Booking
4. View Service History
5. Search Vehicle
6. Exit

Enter Your Choice: 3

Enter Vehicle ID: 1
Enter Service Type: Engine Repair
Enter Service Date (yyyy-mm-dd): 2026-08-09
Enter Service Cost: 5000

------------------------------------------------------
          Service Booked Successfully!
------------------------------------------------------
```

The service booking method inserts the vehicle ID, service type, service
date, and service cost into the service records.

------------------------------------------------------------------------

### 4. View Service History

``` text
========== VEHICLE SERVICE CENTER MANAGEMENT ==========
1. Customer Registration
2. Vehicle Registration
3. Service Booking
4. View Service History
5. Search Vehicle
6. Exit

Enter Your Choice: 4

----------------------------------------------------------------------------------------------------------------
| Customer             | Vehicle No      | Model           | Service            | Date         |         Cost |
----------------------------------------------------------------------------------------------------------------
| Rahul                | TN10AB1234      | Swift           | Engine Repair      | 2026-08-09   |      5000.00 |
| Priya                | AP31CD5678      | i20             | General Service   | 2026-08-08   |      2500.00 |
| Arun                 | KA05EF9012      | City            | Oil Change        | 2026-08-07   |      1500.00 |
----------------------------------------------------------------------------------------------------------------
```

The service history uses SQL `INNER JOIN`s between customers, vehicles,
and service records and formats the result into aligned columns.

------------------------------------------------------------------------

### 5. Search Vehicle

``` text
========== VEHICLE SERVICE CENTER MANAGEMENT ==========
1. Customer Registration
2. Vehicle Registration
3. Service Booking
4. View Service History
5. Search Vehicle
6. Exit

Enter Your Choice: 5

Enter Vehicle Number: TN10AB1234

--------------------------------------------------
VEHICLE FOUND
--------------------------------------------------
Vehicle ID        : 1
Customer ID       : 1
Vehicle Number    : TN10AB1234
Model             : Swift
Brand             : Maruti
--------------------------------------------------
```

The search operation uses the vehicle number as a parameter and displays
the matching vehicle details in a formatted section.

------------------------------------------------------------------------

### 6. Exit

``` text
========== VEHICLE SERVICE CENTER MANAGEMENT ==========
1. Customer Registration
2. Vehicle Registration
3. Service Booking
4. View Service History
5. Search Vehicle
6. Exit

Enter Your Choice: 6

Thank You!
```

==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice:
```

---

## 1. Register Employee

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 1

Enter Employee Name : Rahul
Enter Department     : IT
Enter Email          : rahul@gmail.com
Enter Phone          : 9876543210

Employee Added Successfully.
```

---

## 2. View Employees

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 2


==============================================================================================================
ID       Name                           Department                     Email                               Phone
==============================================================================================================
1        Rahul                          IT                             rahul@gmail.com                    9876543210
2        Priya                          HR                             priya@gmail.com                    9876543211
3        Arun                           Finance                        arun@gmail.com                     9876543212
==============================================================================================================
```

---

## 3. Update Employee

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 3

Enter Employee ID : 1
Enter Employee Name : Rahul Kumar
Enter Department : IT
Enter Email : rahulkumar@gmail.com
Enter Phone : 9876543210

Employee Updated Successfully.
```

---

## 4. Delete Employee

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 4

Enter Employee ID : 1

Employee Deleted Successfully.
```

---

## 5. Apply Leave

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 5

Enter Employee ID : 2
Enter Leave Type  : Casual Leave
Enter From Date   : 2026-08-10
Enter To Date     : 2026-08-12
Enter Reason      : Personal work

Leave Applied Successfully.
```

---

## 6. Approve Leave

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 6

Enter Leave ID : 1

Leave Approved Successfully.
```

---

## 7. Reject Leave

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 7

Enter Leave ID : 2

Leave Rejected Successfully.
```

---

## 8. View Leave Requests

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 8


==============================================================================================================
ID       Employee Name             Leave Type          From Date       To Date         Status
==============================================================================================================
1        Rahul Kumar               Casual Leave        2026-08-10      2026-08-12      Approved
2        Priya                     Sick Leave          2026-08-15      2026-08-16      Rejected
3        Arun                      Earned Leave        2026-08-20      2026-08-22      Pending
==============================================================================================================
```

---

## 9. View Leave Balance

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 9


================================================================================
ID       Employee Name             Total Leaves     Used Leaves     Remaining
================================================================================
1        Rahul Kumar               20               5               15
2        Priya                     20               3               17
3        Arun                      20               2               18
================================================================================
```

---

## 10. Exit

```text
==============================================================
          Employee Leave Management System
==============================================================
1. Register Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Apply Leave
6. Approve Leave
7. Reject Leave
8. View Leave Requests
9. View Leave Balance
10. Exit
==============================================================
Enter your choice: 10


==============================================================
       Thank You for Using Employee Leave Management System
==============================================================
```

