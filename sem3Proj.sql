CREATE SCHEMA SEM_3_PROJ;

CREATE TABLE STUDENTS (
	student_id INTEGER PRIMARY KEY AUTO_INCREMENT,
	sapid VARCHAR(11) UNIQUE NOT NULL,
    student_name VARCHAR(40),
    student_addr VARCHAR(100),
    student_email VARCHAR(40),
    student_phoneNo VARCHAR(15),
    pass VARCHAR(30) NOT NULL
);

CREATE TABLE TEACHERS (
	teachers_id INTEGER PRIMARY KEY AUTO_INCREMENT,
	sapid VARCHAR(11) UNIQUE NOT NULL,
    teachers_name VARCHAR(40),
    teachers_addr VARCHAR(100),
    teachers_email VARCHAR(40),
    teachers_phoneNo VARCHAR(15),
    pass VARCHAR(30) NOT NULL
);

INSERT INTO STUDENTS(sapid, student_name, student_addr, student_email, student_phoneNo, pass) VALUES('60003210188', 'Kushal Amrish Vadodaria', '703/347, Srishti, Kalpatru, sec-3, Mira Road (E), Thane - 401 107', 'kushalv238@gmail.com','9892775337', 'pass@123');
INSERT INTO STUDENTS(sapid, student_name, student_addr, student_email, student_phoneNo, pass) VALUES('60003210185', 'Kely Mistry', 'Kandivali', 'kmistry7002@gmail.com','9892775337', 'kmistry@123');
INSERT INTO STUDENTS(sapid, student_name, student_addr, student_email, student_phoneNo, pass) VALUES('60003210203', 'Umang Jain', 'Kandivali', 'kmistry7002@gmail.com','9892775337', 'kmistry@123');
INSERT INTO STUDENTS(sapid, student_name, student_addr, student_email, student_phoneNo, pass) VALUES('60003210173', 'Araish Sheikh', 'Kandivali', 'kmistry7002@gmail.com','9892775337', 'kmistry@123');
INSERT INTO STUDENTS(sapid, student_name, student_addr, student_email, student_phoneNo, pass) VALUES('60003210212', 'Mithil Bhide', 'Kandivali', 'kmistry7002@gmail.com','9892775337', 'kmistry@123');

SELECT * FROM students;

INSERT INTO teachers(sapid, teachers_name, teachers_addr, teachers_email, teachers_phoneNo, pass) VALUES('60000000122', 'Neha Katre', 'Andheri, Mumbai', 'nehaKatre123@gmail.com','8022425160', 'neha098765');
INSERT INTO teachers(sapid, teachers_name, teachers_addr, teachers_email, teachers_phoneNo, pass) VALUES('60000000144', 'Neha Ram', 'Andheri, Mumbai', 'nehaKatre123@gmail.com','8022425160', 'ramNeha');
INSERT INTO teachers(sapid, teachers_name, teachers_addr, teachers_email, teachers_phoneNo, pass) VALUES('60000000166', 'Rupali Chandrashekhar', 'Andheri West', 'aerupali@gmail.com','794797387', 'ruplaic');

CREATE TABLE COURSES (
	cid INTEGER PRIMARY KEY AUTO_INCREMENT,
    cno INTEGER UNIQUE NOT NULL,
    course_name VARCHAR(40),
    teachers_id INTEGER NOT NULL REFERENCES TEACHERS(teachers_id)
);

CREATE TABLE course_appointed (
	student_id INTEGER NOT NULL,
    cid INTEGER NOT NULL,
    
    FOREIGN KEY(student_id) REFERENCES students(student_id),
    FOREIGN KEY(cid) REFERENCES courses(cid)
);
select course_name from courses
where cid like (Select distinct cid from course_appointed
				where student_id like (Select student_id from students where sapid like 60003210188));
