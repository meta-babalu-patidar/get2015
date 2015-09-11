-- 2015-09-11: Babalu patidar : created.

-- Assignment 3

USE Library1;

-- Select command to display total numbers of student ,total number of faculty and total numbers of others.
SELECT category,COUNT(*) AS total
FROM Members
GROUP BY category;

-- Select command to display information of those titles that have issued more than 2 times.
SELECT b.accession_number, t.title_name,t.title_id
FROM Book_issue b, Books b1, Titles t
WHERE b.accession_number = b1.accession_number AND t.title_id = b1.title_id
GROUP BY t.title_id
HAVING COUNT(t.title_id) >= 2;

-- Select command to display info on books issued to member category other than "F"
SELECT m.member_id, m.member_name, b.accession_number, t.title_name
FROM Book_issue b, Books b1, Members m, Titles t
WHERE b.accession_number = b1.accession_number AND t.title_id = b1.title_id AND b.member_id = m.member_id AND m.category != 'F';

-- Select command to display information on those authers for which at least one book has been purchased.
SELECT DISTINCT author_name
FROM Authors  a, Titles t, Books b, Title_author ta
WHERE a.author_id = ta.author_id AND ta.title_id = t.title_id AND t.title_id = b.title_id;