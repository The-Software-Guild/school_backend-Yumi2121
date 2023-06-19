package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.StudentDao;
import com.wileyedge.fullstackschool.dao.CourseDao;
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
    
    @Autowired
    CourseDao courseDao;

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
    	Student student = null;
    	
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
    	} else {
    	
    		student = studentDao.createNewStudent(student);
    	}
        return student;

        //YOUR CODE ENDS HERE
    }

    public Student updateStudentData(int id, Student student) {
        //YOUR CODE STARTS HERE
    	
    	if (id != student.getStudentId()) {
    		student.setStudentFirstName("IDs do not match, student not updated");
    		student.setStudentLastName("IDs do not match, student not updated");
    		
    	} else {
    		studentDao.updateStudent(student);	
    		
    	}
    	return student;
    	
        

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentById(int id) {
        //YOUR CODE STARTS HERE
    	studentDao.deleteStudent(id);

        //YOUR CODE ENDS HERE
    }

    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE
    	List<Course> courses = null;
    	List<Student> students = null;
    	
    	
    	courses = courseDao.getAllCourses();
    	boolean outcome = true;
    	for (Student s : students) {
    		if (s.getStudentId() == studentId) {
    			if(s.getStudentFirstName().contentEquals("Student Not Found")) {
    				System.out.println("Student not found");
    				outcome = false;
    			}
    		}
    	}
    	
    	for (Course c : courses) {
    		if (c.getCourseId() == courseId) {
    			if(c.getCourseName().equals("Course Not Found")) {
    				System.out.println("Course not found");
    				outcome = false;
    			}
    		}
    	}
    	
    	if (outcome) {
    		studentDao.addStudentToCourse(studentId, courseId);
    		System.out.println("Student: " + studentId + " deleted from course: " + courseId);
    	}
    	
    	
  

        //YOUR CODE ENDS HERE
    }

    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE
    try {
     	List<Course> courses = null;
    	List<Student> students = null;
    	
    	
    	courses = courseDao.getAllCourses();
    	boolean outcome = true;
    	for (Student s : students) {
    		if (s.getStudentId() == studentId) {
    			if(s.getStudentFirstName().contentEquals("Student Not Found")) {
    				System.out.println("Student not found");
    				outcome = false;
    			}
    		}
    	}
    	
    	for (Course c : courses) {
    		if (c.getCourseId() == courseId) {
    			if(c.getCourseName().equals("Course Not Found")) {
    				System.out.println("Course not found");
    				outcome = false;
    			}
    		}
    	}
    	
    	if (outcome) {
    		studentDao.addStudentToCourse(studentId, courseId);
    		System.out.println("Student: " + studentId + " added to course: " + courseId);
    	}
    } catch(Exception e) {
    	System.out.println("Student: " + studentId + " already enrolled in course: " + courseId);
    }
    	


        //YOUR CODE ENDS HERE
    }
}
