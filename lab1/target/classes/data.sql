-- Insert data into the Student table
INSERT INTO address ( city, state, zip_code) VALUES ('Fairfield', 'IA', 52556);
INSERT INTO address (city, state, zip_code) VALUES ('Iowa City', 'IA', 52440);
INSERT INTO address (city,state, zip_code) VALUES ('Morrison', 'IL', 61270);

ALTER SEQUENCE student_student_id_seq RESTART WITH 111;
INSERT INTO student ( name, gpa, address_id) VALUES ( 'Dean', 3.5, 1);
INSERT INTO student (name, gpa, address_id) VALUES ( 'Zaineh', 3.8, 1);
INSERT INTO student (name, gpa, address_id) VALUES ('Yasmeen', 3.9, 2);


INSERT INTO course (course_id, name) VALUES (545, 'Web Application Architecture');
INSERT INTO course (course_id, name) VALUES (221, 'Data Structures');
INSERT INTO course (course_id, name) VALUES (105, 'Problem Solving in CS');
INSERT INTO course (course_id, name) VALUES (401, 'Modern Programming Practices');

INSERT INTO student_course (student_id, course_id) VALUES (111, '545');
INSERT INTO student_course (student_id, course_id) VALUES (111, '221');
INSERT INTO student_course (student_id, course_id) VALUES (112, '545');
INSERT INTO student_course (student_id, course_id) VALUES (112, '401');
INSERT INTO student_course (student_id, course_id) VALUES (113, '221');
INSERT INTO student_course (student_id, course_id) VALUES (113, '105');
INSERT INTO student_course (student_id, course_id) VALUES (113, '401');


INSERT INTO course_detail ( course_description, credit, program, last_update, course_id)
VALUES ('This course covers web...', 4, 'MSC', '2021', '545');

INSERT INTO course_detail ( course_description, credit, program, last_update, course_id)
VALUES ('In this course, the fundamentals...', 4, 'BSC', '2020', '221');

INSERT INTO course_detail (course_description, credit, program, last_update, course_id)
VALUES ( 'This course focuses on teaching...', 4, 'BSC', '2018', '105');

INSERT INTO course_detail (course_description, credit, program, last_update, course_id)
VALUES ('This course covers the basic...', 4, 'MSC', '2016', '401');

