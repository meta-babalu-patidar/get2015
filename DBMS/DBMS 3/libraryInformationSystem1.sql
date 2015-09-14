-- 2015-09-11: Babalu patidar : created.

CREATE DATABASE Library1;

USE Library1;

-- Creating Members table
CREATE TABLE Members(
member_id INT auto_increment PRIMARY KEY,
member_name VARCHAR(100),
addressline1 VARCHAR(100),
addressline2 VARCHAR(100),
category char(1)
);

-- Creating subjects table 
CREATE TABLE Subjects(
subject_id INT auto_increment PRIMARY KEY,
subject_name VARCHAR(100)
);

-- Creating publishres table
CREATE TABLE Publishers(
publisher_id INT PRIMARY KEY,
publisher_name VARCHAR(100)
);

-- Creating authors table
CREATE TABLE Authors(
author_id INT auto_increment PRIMARY KEY,
author_name VARCHAR(100)
);

-- Creating titles table
CREATE TABLE Titles(
title_id INT auto_increment PRIMARY KEY,
title_name VARCHAR(100),
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
accession_number INT auto_increment PRIMARY KEY,
title_id INT,
purchase_date DATE,
price REAL,
status INT
CHECK (status = 0 OR status = 1),
FOREIGN KEY (title_id) REFERENCES Titles(title_id) ON DELETE CASCADE
);

-- Creating book_issue table
CREATE TABLE Book_issue(
issue_date DATE,
accession_number INT,
member_id INT,
due_date DATE,
PRIMARY KEY(issue_date, accession_number, member_id),
FOREIGN KEY (accession_number) REFERENCES Books(accession_number) ON DELETE CASCADE,
FOREIGN KEY (member_id) REFERENCES Members(member_id) ON DELETE CASCADE
);

-- Creating book_return table
CREATE TABLE Book_return(
return_date DATE,
accession_number INT,
member_id INT,
issue_date DATE,
PRIMARY KEY(return_date, accession_number, member_id),
FOREIGN KEY (accession_number) REFERENCES Books(accession_number) ON DELETE CASCADE,
FOREIGN KEY (member_id) REFERENCES Members(member_id) ON DELETE CASCADE
);



ALTER TABLE `Book_issue` MODIFY COLUMN `issue_date` TIMESTAMP NOT NULL DEFAULT NOW();
DELIMITER ;;
CREATE TRIGGER book_due_date BEFORE INSERT ON Book_issue FOR EACH ROW
BEGIN
    SET NEW.due_date = DATE_ADD(NOW(), INTERVAL 15 DAY);
END;;
DELIMITER ;

DROP TRIGGER book_due_date;
SHOW TABLES;
