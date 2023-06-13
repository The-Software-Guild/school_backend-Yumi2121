# Java Assignment: School Full-Stack Backend
## Table of Contents

* [Problem Statement](#problem-statement)
  * [Database Information](#database-information)
* [Instructions](#instructions)
  * [Overview](#overview)
  * [Details (Grouped by Package)](#details-grouped-by-package)
    * [Controller package](#controller-package)
    * [dao/mappers package](#daomappers-package)
    * [dao package](#dao-package)
    * [service package](#service-package)
* [Steps to Solve the Problem](#steps-to-solve-the-problem)
  * [Step 1: Verify the Setup Requirements](#step-1-verify-the-setup-requirements)
  * [Step 2: Access GitHub Classroom and the Repository](#step-2-access-github-classroom-and-the-repository)
  * [Step 3: Solve the Problem](#step-3-solve-the-problem)
  * [Step 4: Submit Your Work](#step-4-submit-your-work)

## Problem Statement

Using what you learned about creating a Java web service and implementing CRUD capabilities, dependency injection, and MVC structure (including the service layer), apply the following functionality in the relevant methods to produce a working CRUD-enabled web service.

### Database Information

The database for this assignment is embedded in the code provided in the GitHub Classroom repository, so you do not need to set up the database for use with this assignment. 

To see the database structure and the existing data in each table, see the page at <a href="DatabaseInformation.md">DatabaseInformation.md</a>.

Note that each time you run the code, the database will reset, so changes to the data (including insertions, updates, and deletions) will not persist.

## Instructions

In this assignment, you are asked to change multiple files in the project. Review the instructions carefully and ensure that you are editing ONLY the files listed in the following instructions.

Commit changes to the code frequently, to check for errors in the code as well as to check test results. 

The requested updates are grouped by package and file below.

Refer to the database information provided at the beginning of this assignment to identify column names and data types as needed.

### Overview

Using your knowledge of writing Java REST web services, create CRUD endpoints for each of the following:

* Course Controller:
  - Return a list of all courses
  - Return a course by ID
  - Add a new course
  - Edit an existing course
  - Delete a course

- Student Controller:
  - Return a list of all students
  - Return a student by ID
  - Add a new student
  - Edit an existing student
  - Delete a student
  - Delete a student from a course
  - Add a student to a course

- Teacher Controller:
  - Return a list of all teacher
  - Return a teacher by ID
  - Add a new teacher
  - Edit an existing teache
  - Delete a teacher


- Write code to map data from the database to the Course, Student, and Teacher objects.
- Write code to implement the `CourseDao`, `StudentDao`, and `TeacherDao` interfaces.
- Write code to implement the `CourseServiceInterface`, `StudentServiceInterface`, and `TeacherServiceInterface`.


### Details (Grouped by Package)

#### Controller package 

##### Course controller
Edit the *CourseController.java* file and complete the following: 

* Add code to the `getAllCourses()` method
* Add code to the `getCoursesById(int id)` method
* Add code to the `addCourse(Course course)` method
* Add code to the `updateCourse(int id, Course course)` method
* Add code to the `deleteCourse(int id)` method

##### Student controller

Edit the *StudentController.java* file and complete the following:

* Add code to the `getAllStudents()` method
* Add code to the `addStudent(Student student)` method
* Add code to the `getStudentById(int id)` method
* Add code to the `updateStudent(int id, Student student`) method
* Add code to the `deleteStudent(int id)` method
* Add code to the `deleteStudentFromCourse(int studentId, int courseId)` method
* Add code to the `addStudentToCourse(int studentId, int courseId)` method

##### Teacher controller
Edit the *TeacherController.java* file and complete the following:

* Add code to the `getAllTeachers()` method
* Add code to the `getTeacherById(int id)` method
* Add code to the `addTeacher(Teacher teacher)` method
* Add code to the `updateTeacher(int id, Teacher teacher)` method
* Add code to the `deleteTeacher(int id)` method

#### dao/mappers package

* Edit the *CourseMapper.java* file and add code to the `mapRow` method
* Edit the *StudentMapper.java* file and add code to the `mapRow` method
* Edit the *TeacherMapper.java* file and add code to the `mapRow` method

#### dao package

> ⚠ Do not change any of the dao interface files! ⚠

##### Course Dao

Edit the *CourseDaoImpl.java* file and complete the following:

* Add code to implement the `createNewCourse(Course course)` method
* Add code to implement the `getAllCourses()` method
* Add code to implement the `findCourseById(int id)` method
* Add code to implement the `updateCourse(Course course)` method
* Add code to implement the `deleteCourse(int id)` method
* Add code to implement the `deleteAllStudentsFromCourse(int courseId)` method

##### Student Dao
Edit the *StudentDaoImpl.java* file and complete the following:
* Add code to implement the `createNewStudent(Student student)` method
* Add code to implement the `getAllStudents()` method
* Add code to implement the `findStudentById(int id)` method
* Add code to implement the `updateStudent(Student student)` method
* Add code to implement the `deleteStudent(int id)` method
* Add code to implement the `addStudentToCourse(int studentId, int courseId)` method
* Add code to implement the `deleteStudentFromCourse(int studentId, int courseId)` method

##### Teacher Dao
Edit the *TeacherDaoImpl.java* file and complete the following:
* Add code to implement the `createNewTeacher(Teacher teacher)` method
* Add code to implement the `getAllTeachers()` method
* Add code to implement the `findTeacherById(int id)` method
* Add code to implement the `updateTeacher(Teacher teacher)` method
* Add code to implement the `deleteTeacher(int id)` method

#### service package

> ⚠ **Do not change any of the service layer interface files!** ⚠ 

##### Course Service Layer
Edit the *CourseServiceImpl.java* file and complete the following:

* Add code to the class for any variable properties and constructors
* Add code to implement the `getAllCourses()` method
    - Pass through method

* Add code to implement the `getCourseById(int id)` method
    - If `DataAccessException` is thrown, set `CourseName` and `CourseDesc` to "Course Not Found"

* Add code to implement the `addNewCourse(Course course)` method
    - If `CourseName` or `CourseDesc` is blank then
      set CourseName = "Name blank, course NOT added" or
      set CourseDesc = "Description blank, course NOT added"

* Add code to implement the `updateCourseData(int id, Course course)` method
     - If id is not equal to object id then set CourseName and CourseDesc = "IDs do not match, course not updated"

* Add code to implement the `deleteCourseById(int id)` method
     - After deletion, print a line to the server console: "Course ID: + id + " deleted"

##### Student Service Layer
Edit the *StudentServiceImpl.java* file and complete the following:

* Add code to the class for any variable properties and constructor
* Add code to implement the `getAllStudents()` method
    - Pass through method

* Add code to implement the `getStudentById(int id)` method
    - If `DataAccessException` is thrown, set `FirstName` and `LastName` to "Student Not Found"

* Add code to implement the `addNewStudent(Student student)` method
    - If FirstName or LastName is blank,
      set FirstName = "First Name blank, student NOT added" or
      set LastName = "Last Name blank, student NOT added"

* Add code to implement the `updateStudentData(int id, Student student)` method
    - If id is not equal to object id, set FirstName and LastName = "IDs do not match, student not updated"

* Add code to implement the `deleteStudent(int id)` method
    - Pass through method

* Add code to implement the `deleteStudentFromCourse(int studentId, int courseId)` method
    - If student first name is equal to "Student Not Found"
      print a line to server console "Student not found"
    - else if course name is equal to "Course Not Found"
      print a line to server console "Course not found"
    - else print a line to server console "Student: \<STUDENT ID> deleted from course: \<COURSE ID>"

* Add code to implement the `addStudentToCourse(int studentId, int courseId)` method
    - If student first name is equal to "Student Not Found"
      print a line to server console "Student not found"
    - else if course name is equal to "Course Not Found"
      print a line to server console "Course not found"
    - else print a line to server console "Student: \<STUDENT ID> added to course: \<COURSE ID>"
    - or catch exception 
      print line to server console "Student: \<STUDENT ID> already enrolled in course: \<COURSE ID>"

##### Teacher Service Layer
Edit the *TeacherServiceImpl.java* file and complete the following:

* Add code to the class for any variable properties and constructors
* Add code to implement the `getAllTeachers()` method
    - Pass through method

* Add code to implement the `getTeacherById(int id)` method
    - If DataAccessException is thrown, set TeacherFName and TeacherLName to "Teacher Not Found"

* Add code to implement the `addNewTeacher(Teacher teacher)` method
    - If TeacherFName or TeacherLName is blank then 
      set TeacherFName = "First Name blank, teacher NOT added" or
      set TeacherLName = "Last Name blank, teacher NOT added"

* Add code to implement the `updateTeacherData(int id, Teacher teacher)` method
    - If id is not equal to object id then set TeacherFName and TeacherLName = "IDs do not match, teacher not updated"

* Add code to implement the `deleteTeacherById(int id)` method
    - Pass through method

## Steps to Solve the Problem

### Step 1: Verify the Setup Requirements
- Java version 11 installed with the JAVA_HOME path variable
- An IDE with required plugins for Java
- Git
- A GitHub account

### Step 2: Access GitHub Classroom and the Repository
1. Your instructor will provide a link for the assessment in GitHub Classroom.
2. Open the link and authorize access using your GitHub account.
3. Clone the repository to a local folder.
   - Instructions for working with GitHub repositories are provided in the Git and GitHub section of the course.
4. Open the project folder in your selected IDE.

### Step 3: Solve the Problem
Read the problem statement carefully to be sure you understand what the code is expected to do.

 - You are encouraged to sketch out a flowchart, use pseudocode, or create class diagrams to plan out the code.
Open the indicated .java file on your computer. Make changes only to that file.

The .java files include comments to indicate where you should add your code.

- All new code must be added inside the placeholders provided.
- Do not delete the placeholder comments.
- Do not change any existing code elsewhere in the project.
- Do not alter existing class names, interface names, method signatures, or attribute names.
- Use Java naming conventions for the code you create.

The placeholders for your code will look like:


    //YOUR CODE STARTS HERE


    //YOUR CODE ENDS HERE


All new code should be added inside these placeholders.

### Step 4: Submit Your Work
1. Code solutions to the problem statements and run the code in the local IDE to check it as you work.
2. Incrementally commit the changes to the repository, labeling each commit numerically (Commit1, Commit2, etc.).
    - The number of commits can be as high as necessary; commit as frequently as you wish.
3. Each commit will be tested automatically against the relevant test cases. Open the repository in GitHub to view the test results.
    - A checkmark indicates that a test passed.
    - An X indicates that the test failed.
4. If any test fails, return to the local code to make corrections or add more code, then recommit the changes.
5. When the code passes all tests, commit one more time, labeling the last commit as "final commit."
    - You may need to make a minor edit to the code, such as adding a comment, so that Git knows the code is different.
6. Copy the URL for the GitHub repository and submit it to the assessment page in Engage.
7. Your instructor may also ask you to submit a pull request on the repository.
