-- 2015-09-11: Babalu patidar : created.

-- Assignment 2

USE Library1;

-- Select to display subjectwise information on number of book purchased.
SELECT subject_name, s.subject_id, COUNT(b.accession_number) AS no_of_books
FROM Subjects s, Titles t, Books b
WHERE s.subject_id = t.subject_id AND t.title_id = b.title_id
GROUP BY subject_name;

-- Select to display those rows from the books issue where a book can be returned after two months.
SELECT member_name AS Member_Name, b.member_id AS Member_Id, issue_date AS Issue_Date, due_date AS Due_Date
FROM Book_issue b, Members m
WHERE m.member_id = b.member_id AND DATEDIFF(due_date,issue_date) >= 60;

-- Select  command to display the list of books having price greater than the min prce of book purchased so far.
SELECT t.title_name, b.price
FROM Books b, Titles t
WHERE b.title_id = t.title_id AND b.price > (SELECT MIN(b1.price)
                    FROM Books b1);
                    
                    
