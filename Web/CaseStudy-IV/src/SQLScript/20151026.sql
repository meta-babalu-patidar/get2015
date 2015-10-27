
CREATE DATABASE vehicle;

USE vehicle;

CREATE TABLE admin(name VARCHAR(100),email VARCHAR(100),password VARCHAR(100),contact VARCHAR(100),address VARCHAR(100));

INSERT INTO ADMIN VALUES ("Babalu Patidar","babalupatidar@gmail.com","123456","9928448367","Jhalawar Rajasthan");

CREATE TABLE Vehicle(
vehicle_id INT AUTO_INCREMENT,
created_by VARCHAR(10) NOT NULL,
created_time DATE NOT NULL,
make VARCHAR(20) NOT NULL,
model VARCHAR(20) NOT NULL,
engine_cc INT NOT NULL,
fuel_capacity INT NOT NULL,
milage INT NOT NULL,
price REAL NOT NULL,
roadTax REAL NOT NULL,
PRIMARY KEY(vehicle_id)
);

CREATE TABLE Car(
id INT AUTO_INCREMENT,
ac VARCHAR(10) NOT NULL,
powersteering VARCHAR(10) NOT NULL,
accessorykit VARCHAR(10) NOT NULL,
vehicle_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id) ON DELETE CASCADE
);

CREATE TABLE Bike(
id INT AUTO_INCREMENT,
selfstart VARCHAR(10) NOT NULL,
helmetprice REAL NOT NULL,
vehicle_id INT,
PRIMARY KEY(id),
FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id) ON DELETE CASCADE
);

ALTER TABLE Car AUTO_INCREMENT = 1001;
ALTER TABLE Bike AUTO_INCREMENT = 10001;
