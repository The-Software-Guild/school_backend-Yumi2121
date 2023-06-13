package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.CourseDao;
import com.wileyedge.fullstackschool.model.Course;
import java.util.List;

public class CourseDaoStubImpl implements CourseDao {

    public Course onlyCourse;

    public CourseDaoStubImpl() {
        onlyCourse = new Course();
        onlyCourse.setCourseId(121);
        onlyCourse.setCourseName("Service Course Stub");
        onlyCourse.setCourseDesc("For Testing Only");
    }

    @Override
    public List<Course> getAllCourses() {
        //Pass through method no tests
        return null;
    }

    @Override
    public Course findCourseById(int id) {
        if (onlyCourse.getCourseId() != id) {
            onlyCourse.setCourseName("Course Not Found");
            onlyCourse.setCourseDesc("Course Not Found");
        }
        return onlyCourse;
    }

    @Override
    public Course createNewCourse(Course course) {
        if(course.getCourseName().toString() == "" ||
                course.getCourseDesc().toString() == ""){
            course.setCourseName("Name blank, course NOT added");
            course.setCourseDesc("Description blank, course NOT added");
        }
        return course;
    }

    @Override
    public void updateCourse(Course course) {
            onlyCourse.setCourseName(course.getCourseName());
            onlyCourse.setCourseDesc(course.getCourseDesc());
            onlyCourse.setTeacherId(course.getTeacherId());
    }

    @Override
    public void deleteCourse(int id) {
        //Pass through method no tests
    }

    @Override
    public void deleteAllStudentsFromCourse(int courseId) {
        //Pass through method no tests
    }

}
