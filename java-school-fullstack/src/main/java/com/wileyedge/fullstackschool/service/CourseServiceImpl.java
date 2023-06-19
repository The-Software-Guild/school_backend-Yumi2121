package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.CourseDao;
import com.wileyedge.fullstackschool.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseServiceInterface {

    //YOUR CODE STARTS HERE
	
    @Autowired
    CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
        
    }
   

    //YOUR CODE ENDS HERE

    public List<Course> getAllCourses() {
        //YOUR CODE STARTS HERE
    	List<Course> courseList = courseDao.getAllCourses();
        return courseList;

        //YOUR CODE ENDS HERE
    }

    public Course getCourseById(int id) {
        //YOUR CODE STARTS HERE
    	Course course = new Course();
    	
    	try {
    		course = courseDao.findCourseById(id);
    	} catch (DataAccessException e) {
    		course.setCourseName("Course Not Found");
    		course.setCourseDesc("Course Not Found");
    	}
    	
        return course;

        //YOUR CODE ENDS HERE
    }

    public Course addNewCourse(Course course) {
        //YOUR CODE STARTS HERE
    	
    	
    	if (course.getCourseName().equals("") ||course.getCourseDesc().equals("")) {
    		course.setCourseName("Name blank, course NOT added");
    		course.setCourseDesc("Description blank, course NOT added");
    		return course;
    	}
    		
    	course = courseDao.createNewCourse(course);
        return course;

        //YOUR CODE ENDS HERE
    }

    public Course updateCourseData(int id, Course course) {
        //YOUR CODE STARTS HERE
    	
    	if (id != course.getCourseId()) {
    		course.setCourseName("IDs do not match, course not updated");
    		course.setCourseDesc("IDs do not match, course not updated");
    		return course;
    	} else {
    		courseDao.updateCourse(course);
    		return course;
    	}
    	
 
    	
  

        //YOUR CODE ENDS HERE
    }

    public void deleteCourseById(int id) {
        //YOUR CODE STARTS HERE
    	courseDao.deleteCourse(id);
    	System.out.println("Course ID: " + id + " deleted");

        //YOUR CODE ENDS HERE
    }
}
