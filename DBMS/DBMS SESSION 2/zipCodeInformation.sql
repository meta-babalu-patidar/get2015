 
 -- Assignment 4
 
 -- Consider a form where providing a Zip Code populates associated City and State.
 
 CREATE DATABASE ZipCodeInfo; 
 
 USE ZipCodeInfo;
 
 -- Creating ZipCodeNumber table
 CREATE TABLE ZipCodeNumber(
 zipcode int PRIMARY KEY AUTO_INCREMENT
 );
  
 -- Creating StateInfo table
 CREATE TABLE StateInfo
 (
 zipcode int UNIQUE,
 stateName varchar(20),
 PRIMARY KEY(zipcode, stateName),
 FOREIGN KEY (zipcode) REFERENCES zipcodeNumber(zipcode) 
 );
 
-- Creating CityInfo table
 CREATE TABLE CityInfo
 (
 zipcode int UNIQUE,
 cityName varchar(20),
 PRIMARY KEY(zipcode, cityName),
 FOREIGN KEY (zipcode) REFERENCES StateInfo(zipcode) 
 );
 
 -- Inserting in ZipCodeNumber table
 INSERT INTO ZipcodeNumber(zipcode) VALUES (800001);
 INSERT INTO ZipcodeNumber(zipcode) VALUES (800002);
 INSERT INTO ZipcodeNumber(zipcode) VALUES (800003);
 INSERT INTO ZipcodeNumber(zipcode) VALUES (800004);
 INSERT INTO ZipcodeNumber(zipcode) VALUES (800005);
 INSERT INTO ZipcodeNumber VALUES (); 
 INSERT INTO ZipcodeNumber VALUES ();
 INSERT INTO ZipcodeNumber VALUES ();
 INSERT INTO ZipcodeNumber VALUES ();
 
 SELECT * FROM ZipcodeNumber;
 
  -- Inserting in StateInfo table
 INSERT INTO StateInfo(zipcode,stateName) VALUES (800001,'Rajasthan');
 INSERT INTO StateInfo(zipcode,stateName) VALUES (800002,'Gujrat');
 INSERT INTO StateInfo(zipcode,stateName) VALUES (800003,'Bihar');
 INSERT INTO StateInfo(zipcode,stateName) VALUES (800004,'Maharastra');
 INSERT INTO StateInfo(zipcode,stateName) VALUES (800005,'Rajasthan');
 INSERT INTO StateInfo(zipcode,stateName) VALUES (800006,'Rajasthan');
 INSERT INTO StateInfo(zipcode,stateName) VALUES (800007,'Gujrat');
 INSERT INTO StateInfo(zipcode,stateName) VALUES (800008,'Maharastra');
 INSERT INTO StateInfo(zipcode,stateName) VALUES (800009,'Rajasthan');
 
 SELECT * FROM StateInfo;
 
  -- Inserting in CityInfo table
 INSERT INTO CityInfo(zipcode,cityName) VALUES (800001,'Jaipur');
 INSERT INTO CityInfo(zipcode,cityName) VALUES (800005,'Alwar');
 INSERT INTO CityInfo(zipcode,cityName) VALUES (800006,'Udaipur');
 INSERT INTO CityInfo(zipcode,cityName) VALUES (800009,'Kota');
 INSERT INTO CityInfo(zipcode,cityName) VALUES (800002,'Gandhinagar');
 INSERT INTO CityInfo(zipcode,cityName) VALUES (800007,'Ahemdabad');
 INSERT INTO CityInfo(zipcode,cityName) VALUES (800003,'Patna');
 INSERT INTO CityInfo(zipcode,cityName) VALUES (800004,'Bombay');
 INSERT INTO CityInfo(zipcode,cityName) VALUES (800008,'Pune');
 
 SELECT * FROM CityInfo;
 
 
 
 SELECT z.zipcode,stateName,cityName 
 FROM ZipcodeNumber z, StateInfo s, CityInfo c 
 WHERE ((s. zipcode=c.zipcode) AND (z.zipcode = s.zipcode))
 ORDER BY stateName ASC , cityName ASC;
