1:
SELECT lecture_name,
	firstname,
	lastname
FROM lecture
INNER JOIN lector ON lecture.lector_id = lector.lector_id
ORDER BY lecture_date


2:
SELECT firstname,
	lastname,
	tmp.count
FROM lector
INNER JOIN
	(SELECT lector_id,
			COUNT(lector_id)
		FROM lecture
		GROUP BY lector_id) AS tmp ON lector.lector_id = tmp.lector_id
ORDER BY tmp.count DESC

3:
-- lector with id = 3 is absent
-- task for lector with id = 8
SELECT lecture_date, lecture_name 
FROM lecture 
WHERE lector_id = 8 
ORDER BY lecture_date ASC

4:
SELECT course.course_name, 
	tmp.sum_lecture,
	tmp.lector_quantity,
	course.student_quantity,
	tmp.sum_homework,
	tmp.sum_add_mat
FROM course
RIGHT JOIN 
	(SELECT course_id, 
		COUNT(course_id) AS sum_lecture,
		COUNT(DISTINCT lector_id) AS lector_quantity, 
		SUM(hw_quantity) AS sum_homework,
		SUM(add_mat_quantity) AS sum_add_mat
	FROM lecture	 
	GROUP BY course_id 
	ORDER BY course_id) AS tmp ON course.course_id = tmp.course_id

5:
SELECT to_char(lecture_date, 'TMMonth') AS month_name,
	 COUNT(to_char(lecture_date, 'TMMonth')) AS lecture_quantity
FROM lecture
GROUP BY to_char(lecture_date, 'TMMonth')

6:
SELECT CONCAT('homework', ' has ', hw_quantity, ' tasks') AS which_more
FROM lecture
WHERE hw_quantity > add_mat_quantity
UNION ALL
SELECT CONCAT('add_mat', ' has ', add_mat_quantity, ' units')
FROM lecture
WHERE add_mat_quantity > hw_quantity

________________________________________________________________________________

-- additionally: 
a):
SELECT lecture_name,
	CONCAT('homework', ' has ', hw_quantity, ' tasks') AS which_more
FROM lecture
WHERE hw_quantity > add_mat_quantity
UNION ALL
SELECT lecture_name,
	CONCAT('add_mat', ' has ', add_mat_quantity, ' units')
FROM lecture
WHERE add_mat_quantity > hw_quantity

b):
SELECT hw_quantity, add_mat_quantity
FROM lecture
WHERE hw_quantity > add_mat_quantity
UNION ALL
SELECT hw_quantity, add_mat_quantity
FROM lecture
WHERE add_mat_quantity > hw_quantity