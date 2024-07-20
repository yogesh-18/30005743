CREATE DATABASE courier_db;

USE courier_db;

CREATE TABLE parcel (
    parcel_id INT AUTO_INCREMENT PRIMARY KEY,
    tracking_number VARCHAR(50) NOT NULL,
    sender_name VARCHAR(100),
    sender_address VARCHAR(255),
    recipient_name VARCHAR(100),
    recipient_address VARCHAR(255),
    current_status VARCHAR(50),
    delivery_history TEXT
);

CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(15)
);

select * from customer;

INSERT INTO parcel (tracking_number, sender_name, sender_address, recipient_name, recipient_address, current_status, delivery_history)
VALUES 
('TN123456', 'Yogesh', '123, Anna Nagar, Chennai, Tamil Nadu', 'Anita', '456, Mylapore, Chennai, Tamil Nadu', 'In Transit', 'Picked up from Anna Nagar, Chennai, Tamil Nadu'),
('TN654321', 'Tamil', '789, Thillai Nagar, Trichy, Tamil Nadu', 'Lakshmi', '101, KK Nagar, Trichy, Tamil Nadu', 'Delivered', 'Picked up from Thillai Nagar, Trichy, Tamil Nadu; In transit to KK Nagar, Trichy, Tamil Nadu; Delivered in KK Nagar, Trichy, Tamil Nadu'),
('TN112233', 'Arun Vijay', '111, Gandhipuram, Coimbatore, Tamil Nadu', 'Mohan Raj', '222, RS Puram, Coimbatore, Tamil Nadu', 'In Transit', 'Picked up from Gandhipuram, Coimbatore, Tamil Nadu'),
('TN332211', 'Rajesh', '333, Avinashi Road, Coimbatore, Tamil Nadu', 'Vijay Kumar', '444, Peelamedu, Coimbatore, Tamil Nadu', 'Out for Delivery', 'Picked up from Avinashi Road, Coimbatore, Tamil Nadu; In transit to Peelamedu, Coimbatore, Tamil Nadu'),
('TN445566', 'Manick', '555, Velachery, Chennai, Tamil Nadu', 'Geetha', '666, Adyar, Chennai, Tamil Nadu', 'Picked Up', 'Picked up from Velachery, Chennai, Tamil Nadu'),
('TN556677', 'Vimal', '777, Chokkikulam, Madurai, Tamil Nadu', 'Arun', '888, Alagappan Nagar, Madurai, Tamil Nadu', 'In Transit', 'Picked up from Chokkikulam, Madurai, Tamil Nadu'),
('TN667788', 'Mohan', '123, Ranganathan Street, T. Nagar, Chennai, Tamil Nadu', 'Kavitha Natarajan', '123, Ranganathan Street, T. Nagar, Chennai, Tamil Nadu', 'Delivered', 'Picked up from Ranganathan Street, T. Nagar, Chennai, Tamil Nadu; Delivered in Ranganathan Street, T. Nagar, Chennai, Tamil Nadu');

select * from parcel;
