  
-- 2015-09-14: Babalu patidar : created.

    USE Library1;
  
-- 1.1 SELECT command to display name of those members who belong to the category as to which member “Babalu” belongs.

    SELECT member_name FROM members 
    WHERE category=(SELECT category FROM members WHERE Member_name='Babalu');

-- 1.2 Write a SELECT command to display information on the books that have not been returned till date. 

    SELECT * FROM book_issue 
    WHERE accession_number NOT IN(SELECT accession_number FROM book_return br WHERE return_date<now() );


-- 1.3  Write a SELECT command to display information on the books that have been returned after their due dates.

    SELECT bi.issue_date,m.member_name,t.title_name,bi.Due_date 
    FROM book_issue bi,members m,titles t,books b
    WHERE due_date < (SELECT return_date FROM book_return  where bi.accession_number = accession_number) 
    AND m.member_id=bi.member_id AND bi.accession_number= b.accession_number AND b.title_id = t.title_id ;

-- 1.4 Write a SELECT command to display information of those books whose price is equal to the most expensive book purchase so far.

    SELECT * FROM books WHERE price = (SELECT max(price) FROM books);


-- 1.5 Write a SELECT command to display the second maximum price of a book. 

    SELECT * FROM books 
    WHERE price = (SELECT max(price) 
    FROM books 
    WHERE price != (SELECT MAX(price) FROM books));

	
-- 2.1 Create a View which can be used to display member name and all issue details of the member using a simple SELECT command.

    CREATE VIEW Member_Book_Issue	 
    AS

    SELECT m.member_name , bi.accession_number,bi.issue_date,bi.due_date 
    FROM members m,book_issue bi
    WHERE m.member_id=bi.member_id
    ORDER BY m.member_name ;
    
    SELECT * FROM Member_Book_Issue;

-- 2.2 Create a View which contains three columns, member name,member id and full description of category,
--      i.e., Faculty, Students and Others instead of F,S and O.

    CREATE VIEW Member_Details
    AS
    SELECT member_name AS Member_Name,member_id,IF(category='F',"FACULTY",IF(category='S',"STUDENT","OTHER")) AS Member_category 
    FROM members;

    SELECT * FROM Member_Details;


-- 2.3	Create a View which contains the information – subject name,title, member name, category, issue date, due date and return date.


    CREATE VIEW Issued_Books_Details
    AS

    SELECT s.subject_name AS Subject_NAME,t.title_name AS TItle_name,m.member_name AS Member_name,IF(m.category='F',"FACULTY",IF(m.category='S',"STUDENT","OTHER")) AS Member_category,bi.issue_date AS Issue_Date,bi.due_date AS Due_date,br.return_date AS Return_Date 
    FROM titles t,subjects s,members m,books b,book_issue bi
    LEFT JOIN
    book_return br on bi.accession_number=br.accession_number and br.return_date<now()
    WHERE bi.accession_number=b.accession_number 
    AND bi.member_id=m.member_id AND b.title_id=t.title_id AND t.subject_id=s.subject_id
    ORDER BY S.Subject_Name;

    SELECT * FROM Issued_Books_Details;


