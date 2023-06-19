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
	
    @Autowired
    StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
  
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
    	Student student = new Student();
    	
    	try {
    		student = studentDao.findStudentById(id);
    	} catch (DataAccessException e) {
    		student.setStudentFirstName("Student Not Found");
    		student.setStudentLastName("Student Not Found"); 
    	}
  
        return student;

        //YOUR CODE ENDS HERE
    }

    public Student addNewStudent(Student student) {
        //YOUR CODE STARTS HERE
    	
    	if (student.getStudentFirstName().equals("") || student.getStudentLastName().equals("")) {
    		student.setStudentFirstName("First Name blank, student NOT added");
    		student.setStudentLastName("Last Name blank, student NOT added");
    		return student;
    	}
    	
    	student = studentDao.createNewStudent(student);
        return student;

        //YOUR CODE ENDS HERE
    }

    public Student updateStudentData(int id, Student student) {
        //YOUR CODE STARTS HERE
    	
    	if (id != student.getStudentId()) {
    		student.setStudentFirstName("IDs do not match, student not updated");
    		student.setStudentLastName("IDs do not match, student not updated");
    		return student;
    		
    	} else {
    		studentDao.updateStudent(student);
    		return student;
    		
    	}
    	
        

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentById(int id) {
        //YOUR CODE STARTS HERE
    	studentDao.deleteStudent(id);

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE
    	Student student = studentDao.findStudentById(studentId);
    	Course course = courseService.getCourseById(courseId);
    	
    	if (student.getStudentFirstName().equals("Student Not Found")) {
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
    	Student student = studentDao.findStudentById(studentId);
    	Course course = courseService.getCourseById(courseId);
    	
    	try {
    	if (student.getStudentFirstName().equals("Student Not Found")) {
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
