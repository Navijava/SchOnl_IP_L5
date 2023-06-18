1. SELECT * FROM students ORDER BY lastname ASC

2. SELECT lecture_name, add_mat_quantity FROM lectures WHERE lecture_date < '2023-01-01' ORDER BY lecture_date

3. SELECT  * FROM lectures ORDER BY hw_quantity DESC, lecture_date ASC LIMIT 1

4. SELECT mat_type, COUNT(mat_type) FROM add_mat GROUP BY mat_type

5. SELECT * FROM lectors WHERE lastname >= 'a' AND lastname < 'n' OR lastname >= 'а' AND lastname < 'н'

6. SELECT * FROM students ORDER BY course_quantity ASC, lastname ASC

SELECT * FROM students WHERE course_quantity = 1 ORDER BY lastname ASC

SELECT * FROM students WHERE course_quantity = 2 ORDER BY lastname ASC

SELECT * FROM students WHERE course_quantity = 3 ORDER BY lastname ASC