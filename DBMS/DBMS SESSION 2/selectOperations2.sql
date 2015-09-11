-- 2015-09-10: Babalu patidar : created.

-- Assignment 2
-- Modify Select command of question 9 to display results in ascending order of issue_dt and ascending order of members's name 
SELECT bi.issue_dt, bi.accession_no, bi.member_id, m.member_nm,
   IF (br.return_dt is NULL,"",return_dt) as return_date
FROM Book_issue bi
LEFT JOIN Book_return br
ON br.accession_no=bi.accession_no and bi.member_id=br.member_id
LEFT JOIN members m
ON m.member_id=bi.member_id
ORDER BY bi.issue_dt, member_nm; 
