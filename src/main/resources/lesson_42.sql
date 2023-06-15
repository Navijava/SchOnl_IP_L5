	CREATE TABLE IF NOT EXISTS public.students
	(
    id integer NOT NULL DEFAULT nextval('students'::regclass),
    name text COLLATE pg_catalog."default",
    lastname text COLLATE pg_catalog."default",
    age integer DEFAULT 18,
    phone integer,
    email text COLLATE pg_catalog."default",
    course_id integer,
    CONSTRAINT students_pkey PRIMARY KEY (id)
	)

	TABLESPACE pg_default;

	ALTER TABLE IF EXISTS public.students
    OWNER to postgres;
	
	INSERT INTO public.students(
	id, name, lastname, age, phone, email, course_id)
	VALUES (1, 'ann', 'babenko', 18, 0881234567, 'student@gmail.com', 1);
	
	SELECT name FROM students
	
	SELECT name, age, gender FROM students WHERE  gender = 'female'
	
	SELECT name, age, gender FROM students WHERE  gender = 'female' AND age in (18, 19)
	
	UPDATE students
	SET course_id = 2
	WHERE id in(2, 4, 6)
	
	INSERT INTO public.students(
	id, name, lastname, age, phone, email, course_id, gender)
	VALUES (7, 'booblik', 'booblik', 0, 0, 'booblik', 0, 'booblik');
	
	DELETE FROM public.students
	WHERE name = 'booblik';
	
	ALTER TABLE IF EXISTS public.students
    ADD COLUMN course text;
	
	UPDATE students
	SET course = 'java'
	
	UPDATE students
	SET course = 'python'
	WHERE id in (1, 4)
	
	UPDATE students
	SET course = 'javascript'
	WHERE id in (2, 3)	
	__________________________________________________________________________________________________________
	
	CREATE TABLE IF NOT EXISTS public.lectors
	(
		name text COLLATE pg_catalog."default",
		lastname text COLLATE pg_catalog."default",
		courses_id integer,
		lector_id integer,
		students_id integer,
		CONSTRAINT students_id FOREIGN KEY (students_id)
			REFERENCES public.students (id) MATCH SIMPLE
			ON UPDATE NO ACTION
			ON DELETE NO ACTION
	)

	TABLESPACE pg_default;

	ALTER TABLE IF EXISTS public.lectors
		OWNER to postgres;
		
		
	INSERT INTO public.lectors(
	name, lastname, courses_id, lector_id, students_id)
	VALUES ('bob', 'chub', 1, 2, 1);	
	__________________________________________________________________________________________________________
	
	ALTER TABLE IF EXISTS public.students
    ADD COLUMN multi_course_id integer[];
	
	UPDATE students
	SET multi_course_id = '{1}'
	WHERE id in (1, 4)
	
	UPDATE students
	SET multi_course_id = '{1, 2}'
	WHERE id in (3, 6)
	
	UPDATE students
	SET multi_course_id = '{2}'
	WHERE id in (2, 5)
	
	__________________________________________________________________________________________________________
	
	CREATE TABLE public.course
	(
    course_id integer NOT NULL DEFAULT 1,
    name text,
    lectures integer,
    students integer,
    PRIMARY KEY (course_id)
	);

	ALTER TABLE IF EXISTS public.course
		OWNER to postgres;
	
	INSERT INTO public.course(
	course_id, name, lectures, students)
	VALUES (1, 'java', 64, 12);
	
	INSERT INTO public.course(
	course_id, name, lectures, students)
	VALUES (2, 'javascript', 62, 16);
	
	INSERT INTO public.course(
	course_id, name, lectures, students)
	VALUES (3, 'python', 68, 10);	
	__________________________________________________________________________________________________________		
	
	CREATE TABLE public.lectures
	(
    lecture_id integer NOT NULL DEFAULT 1,
    course_id integer,
    name text,
    homework_id integer,
    additional_material_id integer,
    PRIMARY KEY (lecture_id)
	);

	ALTER TABLE IF EXISTS public.lectures
    OWNER to postgres;
	
	INSERT INTO public.lectures(
	lecture_id, course_id, name, homework_id, additional_material_id)
	VALUES (1, 1, 'if', 5, 7);
	
	INSERT INTO public.lectures(
	lecture_id, course_id, name, homework_id, additional_material_id)
	VALUES (2, 1, 'for', 6, 10);	
	__________________________________________________________________________________________________________	
	
	CREATE TABLE public.additional_material
	(
    additional_material_id integer NOT NULL DEFAULT 1,
    type text,
    source text,
    PRIMARY KEY (additional_material_id)
	);

	ALTER TABLE IF EXISTS public.additional_material
		OWNER to postgres;
		
	
	INSERT INTO public.additional_material(
		additional_material_id, type, source)
		VALUES (5, 'video', 'http...');
		
	INSERT INTO public.additional_material(
		additional_material_id, type, source)
		VALUES (2, 'wikipedia', 'http...');	
	__________________________________________________________________________________________________________	
	
	CREATE TABLE public.homework
	(
    homework_id integer NOT NULL DEFAULT 1,
    homework text,
    PRIMARY KEY (homework_id)
	);

	ALTER TABLE IF EXISTS public.homework
		OWNER to postgres;
		
	INSERT INTO public.homework(
	homework_id, homework)
	VALUES (5, 'create table homework...');
	
	INSERT INTO public.homework(
	homework_id, homework)
	VALUES (8, 'create table additional material...');
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	