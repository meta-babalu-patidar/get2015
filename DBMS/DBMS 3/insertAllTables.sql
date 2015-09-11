 -- 2015-09-11: Babalu patidar : created.
 
-- Inserting in authors table
 USE Library1;
 
INSERT INTO Authors(author_id, author_name) VALUES(101, "John");
INSERT INTO Authors(author_name) VALUES("Steve");
INSERT INTO Authors(author_name) VALUES("Smith");
INSERT INTO Authors(author_name) VALUES("Bannet");
INSERT INTO Authors(author_name) VALUES("Marsh");
INSERT INTO Authors(author_name) VALUES("Carson");
INSERT INTO Authors(author_name) VALUES("Deph");

SELECT * FROM Authors;
-- Inserting in publishers table
INSERT INTO Publishers(publisher_id, publisher_name) VALUES(1001,"BPB Publication");
INSERT INTO Publishers(publisher_id, publisher_name) VALUES(1002,"Rajasthan Books Publication");
INSERT INTO Publishers(publisher_id, publisher_name) VALUES(1003,"Jain Publication");
INSERT INTO Publishers(publisher_id, publisher_name) VALUES(1004,"Shreenath Publication");
INSERT INTO Publishers(publisher_id, publisher_name) VALUES(1005,"Rajasthan Books Publication");
INSERT INTO Publishers(publisher_id, publisher_name) VALUES(1006,"Indian Books House");

SELECT * FROM Publishers;

-- Inserting in subjects table
INSERT INTO Subjects(subject_id, subject_name) VALUES(501,"History");
INSERT INTO Subjects(subject_name) VALUES("Science");
INSERT INTO Subjects(subject_name) VALUES("Geography");
INSERT INTO Subjects(subject_name) VALUES("Mathematics");
INSERT INTO Subjects(subject_name) VALUES("English & Communication Skills");
INSERT INTO Subjects(subject_name) VALUES("Computer");

SELECT * FROM Subjects;
-- Inserting in members table
INSERT INTO Members(member_id, member_name, addressline1, addressline2, category) VALUES(10001,"Babalu","Durgapura","Jaipur",'F');
INSERT INTO Members(member_name, addressline1, addressline2, category) VALUES("Avinash","Sitapura","Udaipur",'S');
INSERT INTO Members(member_name, addressline1, addressline2, category) VALUES("Amit","Jhotwara","Alwar",'F');
INSERT INTO Members(member_name, addressline1, addressline2, category) VALUES("Arushi","Kumbhamarg","Jaipur",'O');
INSERT INTO Members(member_name, addressline1, addressline2, category) VALUES("Deepali","Pratapnagar","Jaipur",'S');
INSERT INTO Members(member_name, addressline1, addressline2, category) VALUES("Akshat","Mansarovar","Dausa",'S');

SELECT * FROM Members;

-- Inserting in titles table
INSERT INTO Titles(title_id, title_name, subject_id, publisher_id) VALUES(5001,"History of Rajasthan",501,1004);
INSERT INTO Titles(title_name, subject_id, publisher_id) VALUES("Geographical Structure of Earth",503,1002);
INSERT INTO Titles(title_name, subject_id, publisher_id) VALUES("Reactions of Molecules",502,1006);
INSERT INTO Titles(title_name, subject_id, publisher_id) VALUES("Basics of Computer",506,1001);
INSERT INTO Titles(title_name, subject_id, publisher_id) VALUES("English Grammer",505,1003);
INSERT INTO Titles(title_name, subject_id, publisher_id) VALUES("Algebra & Coordinate Geomatery",504,1005);
INSERT INTO Titles(title_name, subject_id, publisher_id) VALUES("Communication Skills",505,1006);

SELECT * FROM Titles;

-- Inserting in title_author table
INSERT INTO Title_author(title_id, author_id) VALUES(5001,104);
INSERT INTO Title_author(title_id, author_id) VALUES(5002,102);
INSERT INTO Title_author(title_id, author_id) VALUES(5003,103);
INSERT INTO Title_author(title_id, author_id) VALUES(5004,106);
INSERT INTO Title_author(title_id, author_id) VALUES(5005,101);
INSERT INTO Title_author(title_id, author_id) VALUES(5006,105);
INSERT INTO Title_author(title_id, author_id) VALUES(5007,107);

SELECT * FROM Title_author;

-- Inserting in books table
INSERT INTO Books(accession_number, title_id, purchase_date, price, status) VALUES(201,5001,'2008-04-01', 500.64, 1);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5002,'2010-12-25', 250.54, 1);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5003,'2011-06-22', 275.54, 1);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5004,'2013-03-12', 450.54, 1);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5002,'2014-08-13', 650.54, 1);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5006,'2014-10-18', 350.54, 1);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5002,'2014-10-18', 250.54, 0);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5003,'2014-10-18', 275.54, 0);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5003,'2014-10-18', 500.64, 1);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5004,'2014-10-18', 450.54, 1);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5006,'2014-10-18', 350.54, 1);
INSERT INTO Books(title_id, purchase_date, price, status) VALUES(5005,'2014-10-18', 650.54, 1);

SELECT * FROM Books;

-- Inserting in book_issue table
INSERT INTO Book_issue(issue_date, accession_number, member_id, due_date) VALUES('2015-06-08',209,10003,'2015-08-10');
INSERT INTO Book_issue(issue_date, accession_number, member_id, due_date) VALUES('2015-06-08',210,10004,'2015-08-10');
INSERT INTO Book_issue(issue_date, accession_number, member_id, due_date) VALUES('2015-06-08',211,10001,'2015-08-10');
INSERT INTO Book_issue(issue_date, accession_number, member_id, due_date) VALUES('2015-06-08',212,10002,'2015-08-10');
INSERT INTO Book_issue(accession_number, member_id, due_date) VALUES(202,10002,'2015-10-08');
INSERT INTO Book_issue(accession_number, member_id, due_date) VALUES(205,10004,'2015-10-08');
INSERT INTO Book_issue(accession_number, member_id, due_date) VALUES(206,10006,'2015-10-08');
INSERT INTO Book_issue(accession_number, member_id, due_date) VALUES(204,10005,'2015-10-08');
INSERT INTO Book_issue(accession_number, member_id, due_date) VALUES(203,10001,'2015-10-08');

SELECT * FROM Book_issue;


-- Inserting in book_return table
INSERT INTO Book_return(return_date, accession_number, member_id, issue_date) VALUES('2015-07-03',209,10003,'2015-06-08');
INSERT INTO Book_return(return_date, accession_number, member_id, issue_date) VALUES('2015-07-03',210,10004,'2015-06-08');
INSERT INTO Book_return(accession_number, member_id, issue_date) VALUES(211,10001,'2015-06-08');
INSERT INTO Book_return(accession_number, member_id, issue_date) VALUES(212,10002,'2015-06-08');
INSERT INTO Book_return(accession_number, member_id, issue_date) VALUES(202,10002,'2015-09-10');
INSERT INTO Book_return(accession_number, member_id, issue_date) VALUES(204,10005,'2015-09-10');
INSERT INTO Book_return(accession_number, member_id, issue_date) VALUES(203,10001,'2015-09-10');



SELECT * FROM Book_return;
