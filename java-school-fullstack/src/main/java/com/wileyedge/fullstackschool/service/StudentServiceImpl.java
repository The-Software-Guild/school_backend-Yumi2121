package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.StudentDao;
import com.wileyedge.fullstackschool.model.Course;
import com.wileyedge.fullstackschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

    //YOUR CODE STARTS HERE
	Student returnedStudent;
	
    @Autowired
    StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
        this.returnedStudent = new Student();
    }

    @Autowired
    CourseServiceImpl courseService;



    //YOUR CODE ENDS HERE

    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE
    	List<Student> students=studentDao.getAllStudents();
        return students;

        //YOUR CODE ENDS HERE
    }

    public Student getStudentById(int id) {
        //YOUR CODE STARTS HERE
    	returnedStudent.setStudentId(id);
    	
    	try {
    		returnedStudent = studentDao.findStudentById(id);
    	} catch (DataAccessException e) {
    		returnedStudent.setStudentFirstName("Student Not Found");
    		returnedStudent.setStudentLastName("Student Not Found"); 
    	}
  
        return returnedStudent;

        //YOUR CODE ENDS HERE
    }

    public Student addNewStudent(Student student) {
        //YOUR CODE STARTS HERE
    	returnedStudent = student;
    	
    	if (student.getStudentFirstName().equals("") || student.getStudentLastName().equals("")) {
    		returnedStudent.setStudentFirstName("First Name blank, student NOT added");
    		returnedStudent.setStudentLastName("Last Name blank, student NOT added");
    		return returnedStudent;
    	}
    	
    	returnedStudent = studentDao.createNewStudent(student);
        return returnedStudent;

        //YOUR CODE ENDS HERE
    }

    public Student updateStudentData(int id, Student student) {
        //YOUR CODE STARTS HERE
    	returnedStudent = student;
    	
    	if (id == returnedStudent.getStudentId()) {
    		studentDao.updateStudent(student);
    	} else {
    		returnedStudent.setStudentFirstName("IDs do not match, student not updated");
    		returnedStudent.setStudentLastName("IDs do not match, student not updated");
    		return returnedStudent;
    	}
    	
        return returnedStudent;

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentById(int id) {
        //YOUR CODE STARTS HERE
    	studentDao.deleteStudent(id);

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE
    	returnedStudent = studentDao.findStudentById(studentId);
    	Course course = courseService.getCourseById(courseId);
    	
    	if (returnedStudent.getStudentFirstName().equals("Student Not Found")) {
    		System.out.println("Student not found");
    	} else if (course.getCourseName().equals("Course Not Found")) {
    		System.out.println("Course not found");
    	} else {
    		studentDao.deleteStudentFromCourse(studentId, courseId);
    		System.out.println("Student: " + studentId + " deleted from course: " + courseId );
    	}
  

        //YOUR CODE ENDS HERE
    }

    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE
    	returnedStudent = studentDao.findStudentById(studentId);
    	Course course = courseService.getCourseById(courseId);
    	
    	try {
    	if (returnedStudent.getStudentFirstName().equals("Student Not Found")) {
    		System.out.println("Student not found");
    	} else if (course.getCourseName().equals("Course Not Found")) {
    		System.out.println("Course not found");
    	} else {
    		studentDao.addStudentToCourse(studentId, courseId);
    		System.out.println("Student: " + studentId + " added to course: " + courseId );}
    	} catch (Exception e) {
    		System.out.println("Student: " + studentId + " already enrolled in course: " + courseId );
    	}
    	


        //YOUR CODE ENDS HERE
    }
}
