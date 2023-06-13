package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.model.Course;

import java.util.List;

public interface CourseServiceInterface {
    List<Course> getAllCourses();

    Course getCourseById(int id);

    Course addNewCourse(Course course);

    Course updateCourseData(int id, Course course);

    void deleteCourseById(int id);


}
