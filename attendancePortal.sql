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


DROP TRIGGER IF EXISTS `sem_3_proj`.`students_BEFORE_INSERT`;
DELIMITER $$
USE `sem_3_proj`$$
CREATE DEFINER=`kushal`@`%` TRIGGER `students_BEFORE_INSERT` BEFORE INSERT ON `students` FOR EACH ROW BEGIN
IF length(NEW.student_phoneNo) > 10 THEN
	signal sqlstate '13190' set message_text = 'Invalid Phone No.';
END IF;
END$$
DELIMITER ;


DROP TRIGGER IF EXISTS `sem_3_proj`.`teachers_BEFORE_INSERT`;
DELIMITER $$
USE `sem_3_proj`$$
CREATE DEFINER=`kushal`@`%` TRIGGER `teachers_BEFORE_INSERT` BEFORE INSERT ON `teachers` FOR EACH ROW BEGIN
IF length(NEW.teachers_phoneNo) > 10 THEN
	signal sqlstate '13191' set message_text = 'Invalid Phone No.';
END IF;
END$$
DELIMITER ;