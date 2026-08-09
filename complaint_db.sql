CREATE DATABASE complaint_db;

USE complaint_db;

-- ==============================
-- USERS TABLE
-- ==============================

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    address VARCHAR(150)
);


-- ==============================
-- OFFICERS TABLE
-- ==============================

CREATE TABLE officers (
    officer_id INT AUTO_INCREMENT PRIMARY KEY,
    officer_name VARCHAR(100) NOT NULL,
    department VARCHAR(100)
);


-- ==============================
-- COMPLAINTS TABLE
-- ==============================

CREATE TABLE complaints (
    complaint_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    officer_id INT,
    complaint_type VARCHAR(100),
    description VARCHAR(300),
    status VARCHAR(30) DEFAULT 'Pending',
    resolution VARCHAR(300),

    FOREIGN KEY (user_id)
        REFERENCES users(user_id),

    FOREIGN KEY (officer_id)
        REFERENCES officers(officer_id)
);


-- ==============================
-- SAMPLE USERS
-- ==============================

INSERT INTO users(user_name, phone, address)
VALUES
('Rahul', '9876543210', 'Chennai'),
('Priya', '9876543211', 'Hyderabad'),
('Arun', '9876543212', 'Bangalore');


-- ==============================
-- SAMPLE OFFICERS
-- ==============================

INSERT INTO officers(officer_name, department)
VALUES
('Ramesh', 'Water Supply'),
('Suresh', 'Road Maintenance'),
('Mahesh', 'Electricity');


-- ==============================
-- SAMPLE COMPLAINTS
-- ==============================

INSERT INTO complaints
(user_id, officer_id, complaint_type, description, status, resolution)
VALUES
(1, 1, 'Water Leakage',
 'Pipeline leakage near main street',
 'Pending',
 NULL),

(2, 2, 'Road Damage',
 'Large potholes on main road',
 'In Progress',
 NULL),

(3, 3, 'Power Failure',
 'Frequent power cuts in the area',
 'Resolved',
 'Electrical issue repaired successfully');


-- ==============================
-- CHECK TABLES
-- ==============================

SELECT * FROM users;

SELECT * FROM officers;

SELECT * FROM complaints;