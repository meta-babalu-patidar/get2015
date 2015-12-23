CREATE DATABASE employee;

USE employee;

CREATE TABLE Customer(
customer_id INT AUTO_INCREMENT,
first_name VARCHAR(10) NOT NULL,
last_name VARCHAR(30) NOT NULL,
PRIMARY KEY(customer_id)
);

CREATE TABLE Orders(
order_id INT AUTO_INCREMENT,
order_name VARCHAR(10) NOT NULL,
customer_id INT,
PRIMARY KEY(order_id),
FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE
);

INSERT INTO Customer(first_name,last_name) values ("Customer","Patel");

INSERT INTO Orders(order_name,customer_id) values ("Order",1);