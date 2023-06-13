-- DROP DATABASE IF EXISTS school;

-- create database school;
-- use school;

-- Table structure for student

DROP TABLE IF EXISTS student;
CREATE TABLE student (
  sid int AUTO_INCREMENT PRIMARY KEY,
  fName varchar(255) DEFAULT NULL,
  lName varchar(255) DEFAULT NULL
);

-- Table structure for teacher

DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher (
  tid int AUTO_INCREMENT PRIMARY KEY,
  tFName varchar(255) DEFAULT NULL,
  tLName varchar(255) DEFAULT NULL,
  dept varchar(255) DEFAULT NULL
);


-- Table structure for course

DROP TABLE IF EXISTS course;
CREATE TABLE course (
  cid int AUTO_INCREMENT PRIMARY KEY,
  courseCode varchar(255) DEFAULT NULL,
  courseDesc varchar(255) DEFAULT NULL,
  teacherId int DEFAULT NULL
);

-- Table structure for course_student

DROP TABLE IF EXISTS course_student;
CREATE TABLE course_student (
  student_id int,
  course_id int
);
