package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.CourseDao;
import com.wileyedge.fullstackschool.model.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CourseServiceTests {

    private CourseServiceImpl courseService;

    public CourseServiceTests() {
        CourseDao courseDao = new CourseDaoStubImpl();
        courseService = new CourseServiceImpl(courseDao);
    }

    @Test
    @DisplayName("Find Course Service test")
    public void findCourseServiceTest() {
        Course returnCourse = courseService.getCourseById(121);
        assertNotNull(returnCourse);
        assertEquals("Service Course Stub", returnCourse.getCourseName());
    }

    @Test
    @DisplayName("Course Not Found Service Test")
    public void courseNotFoundServiceTest() {
        Course notFound = courseService.getCourseById(99);
        assertNotNull(notFound);
        assertEquals("Course Not Found", notFound.getCourseName());
    }

    @Test
    @DisplayName("Update Course Service Test")
    public void updateCourseServiceTest() {
        Course course = new Course();
        course.setCourseId(121);
        course.setCourseName("Updated Course Name");
        course.setCourseDesc("Updated Course Desc");
        course.setTeacherId(10);

        Course upCourse = courseService.updateCourseData(121, course);
        upCourse = courseService.getCourseById(121);
        assertNotNull(upCourse);
        assertEquals(121, upCourse.getCourseId());
        assertEquals("Updated Course Name", upCourse.getCourseName());
        assertEquals("Updated Course Desc", upCourse.getCourseDesc());
        assertEquals(10, upCourse.getTeacherId());
    }

    @Test
    @DisplayName("Course Not Updated Service Test")
    public void courseNotUpdatedServiceTest() {
        Course course = new Course();
        course.setCourseId(121);
        course.setCourseName("Updated Course Name");
        course.setCourseDesc("Updated Course Desc");
        course.setTeacherId(10);

        Course upCourse = courseService.updateCourseData(99, course);
        assertEquals("IDs do not match, course not updated", course.getCourseName());
        assertEquals("IDs do not match, course not updated", course.getCourseDesc());
    }

    @Test
    @DisplayName("Course Add Service Test")
    public void courseAddServiceTest() {
        Course course = new Course();
        course.setCourseName("New Course Name");
        course.setCourseDesc("New Course Desc");
        Course newCourse = courseService.addNewCourse(course);
        assertNotNull(newCourse);
        assertEquals("New Course Name", newCourse.getCourseName());
        assertEquals("New Course Desc", newCourse.getCourseDesc());
    }

    @Test
    @DisplayName("Course No Add Service Test")
    public void courseNoAddServiceTest() {
        Course course = new Course();
        course.setCourseName("");
        course.setCourseDesc("");
        Course newCourse = courseService.addNewCourse(course);
        assertEquals("Name blank, course NOT added", course.getCourseName());
        assertEquals("Description blank, course NOT added", course.getCourseDesc());
    }
}
