CREATE DATABASE employee_leave_db;
USE employee_leave_db;

-- Employees Table
CREATE TABLE employees (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(15)
);

-- Leave Balance Table
CREATE TABLE leave_balance (
    balance_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT,
    total_leaves INT,
    leaves_used INT,
    remaining_leaves INT,
    FOREIGN KEY (emp_id) REFERENCES employees(emp_id)
);

-- Leave Requests Table
CREATE TABLE leave_requests (
    leave_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT,
    leave_type VARCHAR(30),
    from_date DATE,
    to_date DATE,
    reason VARCHAR(200),
    status VARCHAR(20),
    FOREIGN KEY (emp_id) REFERENCES employees(emp_id)
);

-- Sample Employees
INScustomersERT INTO employees(emp_name, department, email, phone) VALUES
('Rahul','IT','rahul@gmail.com','9876543210'),
('Priya','HR','priya@gmail.com','9876543211'),
('Arun','Finance','arun@gmail.com','9876543212'),
('Sneha','Testing','sneha@gmail.com','9876543213'),
('Kiran','Development','kiran@gmail.com','9876543214');

-- Sample Leave Balance
INSERT INTO leave_balance(emp_id,total_leaves,leaves_used,remaining_leaves) VALUES
(1,20,5,15),
(2,20,2,18),
(3,20,4,16),
(4,20,1,19),
(5,20,6,14);

-- Sample Leave Requests
INSERT INTO leave_requests(emp_id,leave_type,from_date,to_date,reason,status) VALUES
(1,'Casual','2026-08-10','2026-08-12','Personal Work','Pending'),
(2,'Sick','2026-08-15','2026-08-17','Fever','Approved'),
(3,'Earned','2026-08-20','2026-08-25','Vacation','Pending');

-- Verify
SELECT * FROM employees;
SELECT * FROM leave_balance;
SELECT * FROM leave_requests;