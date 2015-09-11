-- 2015-09-10: Babalu patidar : created.
-- Assignment 1

USE Library;

-- Select command to display all the columns of member table
SELECT * FROM members;

-- Select command to display member nm,member_id and category colmns of members table
SELECT member_nm,member_id,category FROM members;

-- Select command to display member nm,member_id and category colmns of members table where ctategory of members is faculty('F')
SELECT member_nm,member_id,category FROM members WHERE category = 'F';

-- Select command to display various categories of members
SELECT DISTINCT category FROM members;

-- Select command to display ,members name and their categories in the desending order of member name
SELECT member_nm,category FROM members M ORDER BY M.member_nm;

-- Select command to display all the titles ,their subject and publishers.
SELECT T.title_nm,S.subJect_nm,P.publisher_nm FROM Titles T,subjects S,Publishers P where T.SUBJECT_ID=S.SUBJECT_ID AND T.PUBLISHER_ID=P.PUBLISHER_ID ;

-- Select command to display the numbers of members of present in each category .
SELECT category,count(category) from members group by category;

-- Select command to display name of those who belongd to category as to "BABALU"
SELECT M1.member_nm, M1.category
FROM Members M1
JOIN Members M
ON M.category = M1.category AND M.member_nm = "Babalu";

-- Select command to display information on all books issued.
SELECT bi.issue_dt, bi.accession_no, bi.member_id, 
    IF (br.return_dt is NULL,"",return_dt) AS return_date
FROM Book_issue bi
LEFT JOIN Book_return br
ON br.accession_no=bi.accession_no and bi.member_id=br.member_id;


