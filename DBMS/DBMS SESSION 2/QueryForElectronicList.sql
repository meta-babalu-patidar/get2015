-- 2015-09-10: Babalu patidar : created.
-- Assignment 3_2

-- Query for to display all the categories along with its Parent category.
-- Result is sorted on Parent Category.
-- Implementing left outer join


SELECT C.name AS Category_name , 
IFNULL(parent1.name,'Top Category') AS parent_name, 
parent2.name AS parent2_name , parent3.name AS parent3_name 
FROM Categories AS C 
LEFT JOIN Categories AS parent1 ON parent1.id = C.parentid  
LEFT JOIN Categories AS parent2 ON parent2.id = parent1.parentid  
LEFT JOIN Categories AS parent3 ON parent3.id = parent2.parentid
ORDER BY parent1.name,parent2.name,parent3.name;

    
-- To select categories if it is top category
SELECT name AS Categories  FROM Categories WHERE parentId IS NULL ;
