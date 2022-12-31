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

INSERT INTO teachers(sapid, teachers_name, teachers_addr, teachers_email, teachers_phoneNo, pass) VALUES('60000000122', 'Neha Katre', 'Andheri, Mumbai', 'nehaKatre123@gmail.com','8022425160', 'neha098765');

CREATE TABLE COURSES (
	cid INTEGER PRIMARY KEY AUTO_INCREMENT,
    cno INTEGER UNIQUE NOT NULL,
    course_name VARCHAR(40),
    teachers_id INTEGER,
    
    FOREIGN KEY(teachers_id) REFERENCES TEACHERS(teachers_id)
);