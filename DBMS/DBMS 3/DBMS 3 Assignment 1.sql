

-- 2015-09-11: Babalu patidar : created.

-- Assignment 1

USE Library1;

-- Select to display information on books issued for more than two months.
SELECT member_name AS Member_Name, b.member_id AS Member_Id, r.issue_date AS Issue_Date, b.due_date AS Due_Date, r.accession_number
FROM Book_issue b, Members m, Book_return r
WHERE m.member_id = b.member_id AND DATEDIFF(IF(return_date != '0000-00-00', return_date, NOW()), r.issue_date) >= 60
        AND b.accession_number = r.accession_number AND b.member_id = r.member_id AND b.issue_date = r.issue_date;
        
-- Select command to display those rows from member having maximum length of mamber_nm
        
SELECT member_name AS Member_Name, LENGTH(member_name) AS Name_length
FROM Members m
WHERE LENGTH(m.member_name) = ( SELECT MAX(LENGTH(m1.member_name))
                                FROM Members m1);

-- Select comman to display count of mumber of books issued so far
SELECT COUNT(*) AS Total_Books_Issue
FROM Book_issue;



 