
-- Assignment 1

USE Library;


SELECT * FROM members;

SELECT member_nm,member_id,category FROM members;


SELECT member_nm,member_id,category FROM members WHERE category = 'F';

SELECT DISTINCT category FROM members;


SELECT member_nm,category FROM members M ORDER BY M.member_nm;

SELECT T.title_nm,S.subJect_nm,P.publisher_nm FROM Titles T,subjects S,Publishers P where T.SUBJECT_ID=S.SUBJECT_ID AND T.PUBLISHER_ID=P.PUBLISHER_ID ;

SELECT category,count(category) from members group by category;


SELECT M1.member_nm, M1.category
FROM Members M1
JOIN Members M
ON M.category = M1.category AND M.member_nm = "Babalu";


SELECT bi.issue_dt, bi.accession_no, bi.member_id, 
    IF (br.return_dt is NULL,"",return_dt) AS return_date
FROM Book_issue bi
LEFT JOIN Book_return br
ON br.accession_no=bi.accession_no and bi.member_id=br.member_id;


