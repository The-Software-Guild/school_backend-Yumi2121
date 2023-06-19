package com.wileyedge.fullstackschool.controller;

import com.wileyedge.fullstackschool.model.Course;
import com.wileyedge.fullstackschool.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        //YOUR CODE STARTS HERE
        return courseService.getAllCourses();

        //YOUR CODE ENDS HERE
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        //YOUR CODE STARTS HERE

        return courseService.getCourseById(id);

        //YOUR CODE ENDS HERE
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        //YOUR CODE STARTS HERE

        return courseService.addNewCourse(course);

        //YOUR CODE ENDS HERE
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        //YOUR CODE STARTS HERE
    	Course c = courseService.getCourseById(id);
    	
    	c.setCourseName(course.getCourseName());
    	c.setCourseDesc(course.getCourseDesc());
    	c.setTeacherId(course.getTeacherId());
 
    	courseService.updateCourseData(id, course);
    	return c;

        //YOUR CODE ENDS HERE
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        //YOUR CODE STARTS HERE

    	courseService.deleteCourseById(id);

        //YOUR CODE ENDS HERE
    }
}
