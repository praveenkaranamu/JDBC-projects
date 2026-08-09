CREATE DATABASE banking_db;

USE banking_db;

-- Customers Table
CREATE TABLE customers(
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    phone VARCHAR(15),
    address VARCHAR(100)
);

-- Accounts Table
CREATE TABLE accounts(
    account_no INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    account_type VARCHAR(30),
    balance DECIMAL(10,2),
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

-- Transactions Table
CREATE TABLE transactions(
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_no INT,
    transaction_type VARCHAR(30),
    amount DECIMAL(10,2),
    transaction_date DATE,
    FOREIGN KEY(account_no) REFERENCES accounts(account_no)
);

-- Sample Customers
INSERT INTO customers(customer_name,phone,address)
VALUES
('Rahul','9876543210','Chennai'),
('Priya','9876543211','Hyderabad'),
('Arun','9876543212','Bangalore');

-- Sample Accounts
INSERT INTO accounts(customer_id,account_type,balance)
VALUES
(1,'Savings',10000),
(2,'Savings',15000),
(3,'Current',25000);

-- Sample Transactions
INSERT INTO transactions(account_no,transaction_type,amount,transaction_date)
VALUES
(1,'Deposit',5000,'2026-08-01'),
(2,'Withdrawal',2000,'2026-08-02'),
(3,'Deposit',3000,'2026-08-03');

SELECT * FROM customers;
SELECT * FROM accounts;
SELECT * FROM transactions;