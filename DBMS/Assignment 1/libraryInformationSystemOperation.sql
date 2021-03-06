
-- 2015-09-08: Babalu patidar : created.

-- Change value of addressLine2 column of Members table with “Jaipur”.
UPDATE Members SET addressline2 = "Jaipur";

SELECT * FROM Members;

-- Change value of addressLine1 column of Members table with value “EPIP, Sitapura” for the members belonging to category “F”.
UPDATE Members SET addressline1 = "EPIP Sitapura" WHERE category = 'F';

SELECT * FROM Members;

-- Delete all the rows from Publishers table.
DELETE FROM Publishers;

SELECT * FROM Publishers;

--  Insert the sample data back in Publishers table using substitution variables.
set @Publication1 := "BPB Publications";
set @Publication2 := "Rajasthan Books Publication";
set @Publication3 := "Jain Publication";
set @Publication4 := "Shreenath Publication";
set @Publication5 := "Rajasthan Books Publication";
set @Publication6 := "Indian Books House";

INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(1,@Publication1);
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(2,@Publication2);
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(3,@Publication3);
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(4,@Publication4);
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(5,@Publication5);
INSERT INTO Publishers(publisher_id, publisher_nm) VALUES(6,@Publication6);

SELECT * FROM Publishers;

INSERT INTO Titles(title_id, title_nm, subject_id, publisher_id) VALUES(5001,"History of Rajasthan",501,4);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("History of India",501,1);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Geographical Structure of Earth",503,2);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Reactions of Molecules",502,6);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Dimensions",502,2);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Basics of Computer",506,1);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Computer Graphics",506,1);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("English Grammer",504,3);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Algebra & Coordinate Geomatery",505,5);
INSERT INTO Titles(title_nm, subject_id, publisher_id) VALUES("Diffrentiation & Integretation",505,1);

SELECT * FROM Titles;

-- Delete those rows of Titles table belonging to Publisher with publisher_id = 1
DELETE FROM Titles WHERE publisher_id = 1;

SELECT * FROM Titles;
