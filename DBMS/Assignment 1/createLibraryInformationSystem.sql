-- 2015-09-08: Babalu patidar : created.


CREATE DATABASE Library;

USE Library;
-- Creating Members table
CREATE TABLE Members(
member_id INT auto_increment PRIMARY KEY,
member_nm VARCHAR(100),
addressline1 VARCHAR(100),
addressline2 VARCHAR(100),
category char(1)
);

-- Creating subjects table 
CREATE TABLE Subjects(
subject_id INT auto_increment PRIMARY KEY,
subject_nm VARCHAR(100)
);

-- Creating publishres table
CREATE TABLE Publishers(
publisher_id INT PRIMARY KEY,
publisher_nm VARCHAR(100)
);

-- Creating authors table
CREATE TABLE Authors(
author_id INT auto_increment PRIMARY KEY,
author_nm VARCHAR(100)
);

-- Creating titles table
CREATE TABLE Titles(
title_id INT auto_increment PRIMARY KEY,
title_nm VARCHAR(100),
subject_id INT,
publisher_id INT,
FOREIGN KEY (subject_id) REFERENCES Subjects(subject_id) ON DELETE CASCADE,
FOREIGN KEY (publisher_id) REFERENCES Publishers(publisher_id) ON DELETE CASCADE
);

-- Creating title_author table 
CREATE TABLE Title_author(
title_id INT,
author_id INT,
PRIMARY KEY(title_id, author_id),
FOREIGN KEY (title_id) REFERENCES Titles(title_id) ON DELETE CASCADE,
FOREIGN KEY (author_id) REFERENCES Authors(author_id) ON DELETE CASCADE
);


-- Creating books table
CREATE TABLE Books(
accession_no INT auto_increment PRIMARY KEY,
title_id INT,
purchase_dt DATE,
price REAL,
status INT,
FOREIGN KEY (title_id) REFERENCES Titles(title_id) ON DELETE CASCADE
);


-- Creating book_issue table
CREATE TABLE Book_issue(
issue_dt DATE,
accession_no INT,
member_id INT,
due_dt DATE,
PRIMARY KEY(issue_dt, accession_no, member_id),
FOREIGN KEY (accession_no) REFERENCES Books(accession_no) ON DELETE CASCADE,
FOREIGN KEY (member_id) REFERENCES Members(member_id) ON DELETE CASCADE
);


-- Creating book_return table
CREATE TABLE Book_return(
return_dt DATE,
accession_no INT,
member_id INT,
issue_dt DATE,
PRIMARY KEY(return_dt, accession_no, member_id),
FOREIGN KEY (accession_no) REFERENCES Books(accession_no) ON DELETE CASCADE,
FOREIGN KEY (member_id) REFERENCES Members(member_id) ON DELETE CASCADE
);

SHOW TABLES;

-- Alter definitions of following LIS tables to provide the default constraints

ALTER TABLE Book_issue MODIFY COLUMN issue_dt TIMESTAMP NOT NULL DEFAULT NOW();
DELIMITER ;;
CREATE TRIGGER book_due_date BEFORE INSERT ON Book_issue FOR EACH ROW
BEGIN
    UPDATE Book_issue SET due_dt = DATE_ADD(NOW(), INTERVAL 15 DAY) where issue_dt = NOW();
END;;
DELIMITER ;

-- Remove Members table of the LIS database.
DROP TRIGGER book_due_date;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE Members;
SET FOREIGN_KEY_CHECKS=1;
SHOW TABLES;

-- Creating the members table again
CREATE TABLE Members(
member_id INT auto_increment PRIMARY KEY,
member_nm VARCHAR(100),
addressline1 VARCHAR(100),
addressline2 VARCHAR(100),
category char(1)
);

SHOW TABLES;

